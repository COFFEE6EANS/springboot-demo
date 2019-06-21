package com.redis.web;

import com.base.vo.LoginFormVo;
import com.redis.form.AvoidRepeatableCommit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author guojianfeng.
 * @date Created in  2019/6/21
 * @desc
 */
@Api("表单提交")
@RestController
public class FormSubmitController {

    @AvoidRepeatableCommit(timeout = -1)
    @ApiOperation("form")
    @PostMapping("/form/user")
    public String addUser(@Valid LoginFormVo loginFormVo) {
        System.out.println(loginFormVo);
        return "success";
    }
}
