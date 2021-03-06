package com.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author itoutsource.cz10
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.mybatisplus"})
@EnableSwagger2
@MapperScan(basePackages = {"com.mybatisplus.mapper"})
public class MybatisplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisplusApplication.class, args);
	}

}
