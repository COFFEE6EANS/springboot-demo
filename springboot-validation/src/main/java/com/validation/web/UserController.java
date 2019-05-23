package com.validation.web;

import com.base.msg.ObjectRestResponse;
import com.base.vo.LoginFormVo;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/5/13
 * @Description：
 */
@RestController
public class UserController {
    @RequestMapping("/login")
    public ObjectRestResponse login(@Valid LoginFormVo loginFormVo, BindingResult bindingResult){
        System.out.println(bindingResult);
        return new ObjectRestResponse().code(200).msg("success").result(loginFormVo);
    }
}
