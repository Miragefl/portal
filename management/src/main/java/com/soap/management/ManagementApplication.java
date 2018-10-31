package com.soap.management;

import com.soap.management.util.ConfigUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.soap")
@MapperScan("com.soap.management.mapper")
@ServletComponentScan
public class ManagementApplication {
	public static void main(String[] args) {
		ConfigUtil.init();
		SpringApplication.run(ManagementApplication.class, args);
	}

}
