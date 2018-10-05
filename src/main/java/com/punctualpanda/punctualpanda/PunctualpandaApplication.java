package com.punctualpanda.punctualpanda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.punctualpanda.punctualpanda.service.ITodoTaskService;
import com.punctualpanda.punctualpanda.service.TodoTaskServiceImpl;

@SpringBootApplication
public class PunctualpandaApplication {

	
	@Bean
	public ITodoTaskService todoTaskService(){
		//TODO: remove this direct dependency. Can introduce some creation pattern
		return new TodoTaskServiceImpl();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PunctualpandaApplication.class, args);
	}
}
