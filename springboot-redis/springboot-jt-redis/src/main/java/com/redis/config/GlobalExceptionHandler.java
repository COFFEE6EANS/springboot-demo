package com.redis.config;

import com.base.msg.ObjectRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@CrossOrigin
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ObjectRestResponse processException(Exception ex, HttpServletRequest request, HttpServletResponse response){
		log.error("请求地址:{}，全局异常处理器捕获到了异常:{}！",request.getRequestURI(),ex.getMessage(),ex);

		ex.printStackTrace();
		return new ObjectRestResponse(500, "服务器异常", null);
		
	}
}