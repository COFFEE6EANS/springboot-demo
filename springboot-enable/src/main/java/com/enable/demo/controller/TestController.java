package com.enable.demo.controller;

import com.enable.demo.api.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/8
 * @Description：
 */
@RestController
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public ApiResponse getRes(){
        return new ApiResponse(200,"success",null);
    }
}
