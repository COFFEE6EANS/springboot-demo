package com.enable.redislock.rest;

import com.enable.redislock.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/12
 * @Description：
 */
@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping("/")
    public String doSomething(){
        return demoService.doSomething();
    }
}
