package com.punctualpanda.punctualpanda.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.punctualpanda.punctualpanda.model.TodoTask;
import com.punctualpanda.punctualpanda.service.ITodoTaskService;

@Controller
public class TodoTaskController {
	
	@Autowired
	ITodoTaskService todoTaskService;
	
	@RequestMapping("/addTask")
	public String addTodoTaskT(@ModelAttribute("todoTask") TodoTask todoTask,Map<String, Object> model ){
		//todoTaskService.addTodoTask(userName, taskName);
		System.out.println("Add Task is called!!");
		System.out.println("Task submitted:  "+todoTask.getTaskName());
		System.out.println("Datesubmitted:  "+ todoTask.getDueDate());
		
		todoTask = todoTaskService.addTodoTask(todoTask.getUserName(), todoTask.getTaskName(), todoTask.getDueDate());
		model.put("alltasks",todoTaskService.getAllTodoTasks());
		model.put("todoTask", new TodoTask());
		
		return "hello";
	}
	
	@RequestMapping("/deleteTask")
	public String deleteTodoTaskT(@ModelAttribute("todoTask") TodoTask todoTask,Map<String, Object> model ){
		
		//first delete 
		long taskId = todoTask.getTaskId();
		System.out.println("Task Id to be deleted: "+ taskId);
		todoTaskService.deleteTodoTask(taskId);
		
		//then populate
		model.put("alltasks",todoTaskService.getAllTodoTasks());
		model.put("todoTask", new TodoTask());
		
		return "hello";
		
	}


}
