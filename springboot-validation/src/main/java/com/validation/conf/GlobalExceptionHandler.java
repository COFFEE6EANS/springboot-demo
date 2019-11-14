package com.validation.conf;

import com.base.msg.ObjectRestResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**该注解会 适用所有的@RequestMapper() 结合@ExceptionHander 实现全局异常处理
 *  */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class) /*定义拦截 异常的范围 此时 是拦截所有异常*/
    public ObjectRestResponse<String> exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        if (e instanceof BindException){
            /*注意：此处的BindException 是 Spring 框架抛出的Validation异常*/
            BindException ex = (BindException)e;
            List<ObjectError> errors = ex.getAllErrors();/*抛出异常可能不止一个 输出为一个List集合*/
            ObjectError error = errors.get(0);/*取第一个异常*/
            String errorMsg = error.getDefaultMessage(); /*获取异常信息*/
            return new ObjectRestResponse().code(500).msg(errorMsg);
        }else {
            return new ObjectRestResponse().code(500).msg("系统异常");
        }
    }
}
