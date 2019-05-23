package com.redis.web;

import com.redis.util.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/4/12
 * @Description：
 */
@RestController
public class RedisStringController {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;
    @ApiOperation("设置获取")
    @GetMapping("/setget")
    public String env(String para){
        redisTemplate.opsForValue().set("string:test",para);
        return redisTemplate.opsForValue().get("string:test");
    }
    @ApiOperation("leftPush")
    @GetMapping("/leftPush")
    public String leftPush(){
        redisTemplate.opsForList().rightPush("string:list","user3");
        redisTemplate.opsForList().leftPush("string:list","user3","user2");
        return redisTemplate.opsForList().index("string:list",1L);
    }
    @ApiOperation("redisUtil:leftPush")
    @GetMapping("/redisUtil/leftPush")
    public String redisLeftPush(){
        redisTemplate.opsForList().leftPush("list","user1");
        return redisUtil.get("list");
    }
}
