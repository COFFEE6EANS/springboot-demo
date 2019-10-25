package com.validation.web;

import com.base.msg.ObjectRestResponse;
import com.base.vo.LoginFormVo;
import com.validation.param.User;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/5/13
 * @Description：
 */
@RestController
public class UserController {
    @Bean
    public BeanPostProcessor beanValidationPostProcessor() {
        return new BeanValidationPostProcessor();
    }
    @PostMapping("/login")
    public ObjectRestResponse login(@Valid @RequestBody LoginFormVo loginFormVo){
//        System.out.println(bindingResult);
//        if (bindingResult.hasErrors()){
//            return new ObjectRestResponse().code(500).result(bindingResult.getFieldErrors());
//        }
        return new ObjectRestResponse().code(200).msg("success").result(loginFormVo);
    }
    @PostMapping("/test")
    public ObjectRestResponse test( @RequestBody User user){
        return new ObjectRestResponse().code(200).msg("success").result(user);
    }
    @GetMapping("/get")
    public ObjectRestResponse test(){
        User user = new User();
        user.setName("tom");
        user.setNow(LocalDateTime.now());
        user.setBirth(LocalDateTime.now());
        return new ObjectRestResponse().code(200).msg("success").result(user);
    }
    @GetMapping("/get1")
    public ObjectRestResponse test1(User user){
        return new ObjectRestResponse().code(200).msg("success").result(user);
    }
}
