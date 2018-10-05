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
		model.put("loginUserName", todoTask.getUserName());
		model.put("todoTask", new TodoTask());
		
		if(todoTask.getTaskName()!=null && !todoTask.getTaskName().isEmpty() && todoTask.getDueDate()!=null){
			todoTask = todoTaskService.addTodoTask(todoTask.getUserName(), todoTask.getTaskName(), todoTask.getDueDate());
		}
		
		model.put("alltasks",todoTaskService.getAllTodoTasks());
		
		return "hello";
	}
	
	@RequestMapping("/deleteTask")
	public String deleteTodoTaskT(@ModelAttribute("todoTask") TodoTask todoTask,Map<String, Object> model ){
		//first delete 
		long taskId = todoTask.getTaskId();
		System.out.println("Task Id to be deleted: "+ taskId);
		todoTaskService.deleteTodoTask(taskId);
		
		//then read
		model.put("loginUserName", todoTask.getUserName());
		model.put("alltasks",todoTaskService.getAllTodoTasks());
		model.put("todoTask", new TodoTask());
		
		return "hello";
		
	}
	
	void eraseFields(TodoTask todoTask){
		todoTask.setTaskName(null);
		todoTask.setDueDate(null);
		todoTask.setTaskId(0);
	}


}
