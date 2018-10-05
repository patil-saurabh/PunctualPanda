package com.punctualpanda.punctualpanda.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.punctualpanda.punctualpanda.model.TodoTask;
import com.punctualpanda.punctualpanda.repository.TodoTaskRepository;

public class TodoTaskServiceImpl implements ITodoTaskService{

	@Autowired
	TodoTaskRepository todoTaskRepository; 
	
	@Override
	public List<TodoTask> getAllTodoTasks() {
		return todoTaskRepository.findAll();
	}

	@Override
	public TodoTask addTodoTask(String userName, String taskName, Date dueDate) {
		//TODO: remove direct dependency while creating objects. 
		TodoTask todoTask = new TodoTask();

		if(userName == null || userName == null){
			return todoTask;
		}
		
		todoTask.setTaskName(taskName);
		todoTask.setUserName(userName);  
		todoTask.setDueDate(dueDate);
		todoTask = todoTaskRepository.save(todoTask);
		return todoTask;
	}

	@Override
	public void deleteTodoTask(long taskId) {
		todoTaskRepository.deleteById(taskId);
	}
	
}

