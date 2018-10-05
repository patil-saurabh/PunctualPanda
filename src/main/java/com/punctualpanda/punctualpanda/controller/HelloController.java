package com.punctualpanda.punctualpanda.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.punctualpanda.punctualpanda.model.TodoTask;
import com.punctualpanda.punctualpanda.service.ITodoTaskService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class HelloController {
	
	@Autowired
	@Qualifier("todoTaskService")
	ITodoTaskService todoTaskService;
	
	@RequestMapping("/welcome")
	public String blankone(Map<String, Object> model){
		System.out.println("blankone is called!!");
		return "welcomeView";
	}
	
	@RequestMapping("/hello")
	public String hello(@ModelAttribute("todoTask") TodoTask todoTask, Map<String, Object> model){
		System.out.println("hello function is called!!");
		System.out.println("todoTaskService.getAllTodoTasks() returns: "+todoTaskService.getAllTodoTasks().size());
		
//		todoTaskService.addTodoTask("TestUser", "Test Task.. 1 ");
//		System.out.println("todoTaskService.getAllTodoTasks() returns: "+todoTaskService.getAllTodoTasks().size());
		model.put("alltasks",todoTaskService.getAllTodoTasks());
		model.put("todoTaskFromLogin", todoTask);
		model.put("userName", todoTask.getUserName());
		return "hello";
	}
	
	@RequestMapping("/login")
	public String login(Map<String, Object> model){
		System.out.println("Login is called!!");
		return "login";
	}

}
