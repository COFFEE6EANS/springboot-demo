package com.web;

import com.annotation.Log;
import com.common.utils.YYBlogResult;
import com.dto.TaskDO;
import com.enums.JobStatusEnum;
import com.service.TaskService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * job控制器
 * @author 小卖铺的老爷爷
 * @date 2018年6月25日
 * @website www.laoyeye.net
 */
@Controller
@RequestMapping("/task")
public class TaskController{
    @Autowired
    private TaskService taskService;

    @ResponseBody
    @PostMapping("/list")
    public List<TaskDO> list() {
        // 查询列表数据
        return taskService.list();
    }

    @Log("修改任务")
    @PostMapping("/edit")
    @ResponseBody
    public YYBlogResult edit(@RequestBody TaskDO task) {
//        TaskDO taskServer = taskService.get(task.getId());
//        if (JobStatusEnum.RUNNING.getCode().equals(taskServer.getJobStatus())) {
//            return YYBlogResult.build(403, "修改之前请先停止任务！");
//        }
        taskService.update(task);
        return YYBlogResult.ok();
    }

    @Log("修改任务状态")
    @PostMapping("/changeStatus/{id}")
    @ResponseBody
    public YYBlogResult changeStatus(@PathVariable("id") Long id,@RequestParam Boolean jobStatus) {
        String status = jobStatus == true ? JobStatusEnum.RUNNING.getCode() : JobStatusEnum.STOP.getCode();
        try {
            taskService.changeStatus(id, status);
            return YYBlogResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return YYBlogResult.build(403, "任务状态修改失败");
    }

    /**
     * 删除
     */
    @Log("删除任务")
    @PostMapping("/remove/{id}")
    @ResponseBody
    public YYBlogResult remove(@PathVariable("id") Long id) {
        TaskDO taskServer = taskService.get(id);
        if (JobStatusEnum.RUNNING.getCode().equals(taskServer.getJobStatus())) {
            return YYBlogResult.build(403, "删除前请先停止任务！");
        }
        if (taskService.remove(id) > 0) {
            return YYBlogResult.ok();
        }
        return YYBlogResult.build(403, "删除任务失败！");
    }
    
    /**
     * 立即运行
     */
    @Log("立即运行任务")
    @PostMapping("/run/{id}")
    @ResponseBody
    public YYBlogResult run(@PathVariable("id") Long id) {
        TaskDO taskServer = taskService.get(id);
        try {
            if (JobStatusEnum.STOP.getCode().equals(taskServer.getJobStatus())) {
                return YYBlogResult.build(403, "立即执行请先开启任务！");
            }
            taskService.run(taskServer);
            return YYBlogResult.ok();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return YYBlogResult.build(403, "立即运行任务失败！");
    }

    /**
     * 删除
     */
    @Log("批量删除任务")
    @PostMapping("/removeBatch")
    @ResponseBody
    public YYBlogResult removeBatch(@RequestParam("ids") Long[] ids) {
        for (Long id : ids) {
            TaskDO taskServer = taskService.get(id);
            if (JobStatusEnum.RUNNING.getCode().equals(taskServer.getJobStatus())) {
                return YYBlogResult.build(403, "删除前请先停止任务！");
            }
        }
        taskService.removeBatch(ids);
        return YYBlogResult.ok();
    }
    
    /**
     * 新增保存
     */
    @Log("新增任务")
    @ResponseBody
    @PostMapping("/save")
    public YYBlogResult save(@RequestBody TaskDO task) {
        if (taskService.save(task) > 0) {
            return YYBlogResult.ok();
        }
        return YYBlogResult.build(403, "新增任务失败！");
    }
}
