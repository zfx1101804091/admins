package com.example.admins;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages ="com.example.admins" )
@MapperScan("com.example.admins.Dao")
@SpringBootApplication
//@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class AdminsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminsApplication.class, args);
    }

}



