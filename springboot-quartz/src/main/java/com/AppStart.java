package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动入口
 * @author 小卖铺的老爷爷
 * @date 2017年6月8日
 * @website www.laoyeye.net
 */
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@MapperScan(basePackages = "com.mapper")
public class AppStart {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppStart.class, args);
    }
}
