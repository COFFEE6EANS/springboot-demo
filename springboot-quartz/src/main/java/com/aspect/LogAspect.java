package com.aspect;

import com.annotation.Log;
import com.common.utils.HttpClientUtil;
import com.common.utils.JSONUtils;
import com.common.utils.WebUtils;
import com.dto.LogDO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

/**
 * 数据库日志记录 
 * @author 小卖铺的老爷爷
 * @date 2018年7月1日
 * @website www.laoyeye.net
 */
@Aspect
@Component
public class LogAspect {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志
        saveLog(point, time);
        return result;
    }

    void saveLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogDO sysLog = new LogDO();
        Log log = method.getAnnotation(Log.class);
        if (log != null) {
            // 注解上的描述
            sysLog.setOperation(log.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String params = Arrays.toString(args);
            //太长的没啥意义
            if (params.length() > 4999) {
                params = null;
            }
            sysLog.setParams(params);
            String params2 = JSONUtils.beanToJson(args[0]);
            if (params2.length() > 4999) {
                params2 = null;
            }
            sysLog.setParams2(params2);
        } catch (Exception e) {

        }
        // 获取request
        HttpServletRequest request = HttpClientUtil.getHttpServletRequest();
        // 设置IP地址
        sysLog.setIp(WebUtils.getIpAddress(request));
        // 用户名
        sysLog.setTime((int) time);
        // 系统当前时间
        Date date = new Date();
        sysLog.setCreateTime(date);
        // 保存系统日志
        logger.info(" log--> {} {}",LocalDateTime.now(),log.toString());
    }
}
