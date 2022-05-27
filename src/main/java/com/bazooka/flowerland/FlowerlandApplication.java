package com.bazooka.flowerland;

import com.bazooka.flowerland.interceptors.LoggerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@SpringBootApplication
public class FlowerlandApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FlowerlandApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FlowerlandApplication.class);
	}
}
