package com.dh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Administrator
 * @MapperScan(basePackages = {"com.dh.mapper","com.dh.noxml"})相当于对这两个包内所有Java类添加@Mapper注解
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.dh.mapper","com.dh.noxml"})
@ServletComponentScan(value = {"com.dh.config.datasource"})//servlet,filter
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class);
    }
}
