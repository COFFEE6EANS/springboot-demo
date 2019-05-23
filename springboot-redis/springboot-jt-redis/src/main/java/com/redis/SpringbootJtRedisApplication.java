package com.redis;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwaggerBootstrapUI
@SpringBootApplication
public class SpringbootJtRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJtRedisApplication.class, args);
	}

}
