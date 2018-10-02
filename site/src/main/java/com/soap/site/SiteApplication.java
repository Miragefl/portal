package com.soap.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.soap")
public class SiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);
    }
}
