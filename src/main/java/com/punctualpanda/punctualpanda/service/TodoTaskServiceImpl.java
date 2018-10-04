package com.punctualpanda.punctualpanda.service;

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
	public void addTodoTask(String userName, String taskName) {
		if(userName == null || userName == null){
			return;
		}

		//TODO: remove direct dependency while creating objects. 
		
		TodoTask todoTask = new TodoTask();
		todoTask.setTaskName(taskName);
		todoTask.setUserName(userName);  
		todoTaskRepository.save(todoTask);
	
	}

	@Override
	public void deleteTodoTask(long taskId) {
		todoTaskRepository.deleteById(taskId);
	}
	
}

