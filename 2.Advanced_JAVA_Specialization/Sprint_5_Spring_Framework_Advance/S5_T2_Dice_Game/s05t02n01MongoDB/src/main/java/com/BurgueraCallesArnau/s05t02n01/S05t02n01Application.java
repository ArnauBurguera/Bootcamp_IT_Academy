package com.BurgueraCallesArnau.s05t02n01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class S05t02n01Application {

	public static void main(String[] args) {
		SpringApplication.run(S05t02n01Application.class, args);
		//http://localhost:9000/swagger-ui/index.html
	}

}
