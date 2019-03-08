package com.quartz.task;

import java.util.Date;

import com.common.utils.DateUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

//作业不并发
@DisallowConcurrentExecution
@Component
public class HelloWorldJob implements Job{

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {

        System.out.println("这是一个定时任务 "+arg0.getJobDetail().getKey()+"  "+ DateUtils.fullTime(new Date()));
        
    }

}