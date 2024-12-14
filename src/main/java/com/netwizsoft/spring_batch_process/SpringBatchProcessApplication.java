package com.netwizsoft.spring_batch_process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringBatchProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProcessApplication.class, args);
	}

}
