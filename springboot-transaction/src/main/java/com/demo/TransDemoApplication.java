package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/13
 * @Description：
 */
@MapperScan("com.demo.mapper")
@SpringBootApplication
public class TransDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransDemoApplication.class, args);
    }
}