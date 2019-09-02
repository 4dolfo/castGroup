package com.group.cast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.group.cast.service.AppService;
import com.group.cast.service.AppServiceImpl;

@SpringBootApplication
@ComponentScan("com.group.cast")
public class ApiCastGroupApplication {

	public static void main(String[] args) {
		 ApplicationContext ctx =SpringApplication.run(ApiCastGroupApplication.class, args);
		
		AppServiceImpl appService = ctx.getBean(AppServiceImpl.class);
		
	}

}
