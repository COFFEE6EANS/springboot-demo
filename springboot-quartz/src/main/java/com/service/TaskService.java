package com.service;

import com.dto.TaskDO;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/5
 * @Description：
 */

public interface TaskService {

    TaskDO get(Long id);

    List<TaskDO> list();

    int save(TaskDO taskScheduleJob);

    int update(TaskDO taskScheduleJob);

    int remove(Long id);

    int removeBatch(Long[] ids);

    void initSchedule() throws SchedulerException;

    void changeStatus(Long jobId, String jobStatus) throws SchedulerException;

    void updateCron(Long jobId) throws SchedulerException;

    void run(TaskDO scheduleJob) throws SchedulerException;
}
