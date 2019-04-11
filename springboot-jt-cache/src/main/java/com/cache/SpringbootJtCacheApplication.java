package com.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringbootJtCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJtCacheApplication.class, args);
    }

}
