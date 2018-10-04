package com.punctualpanda.punctualpanda.service;

import java.util.List;

import com.punctualpanda.punctualpanda.model.TodoTask;

public interface ITodoTaskService{

	public List<TodoTask> getAllTodoTasks();
	
	public void addTodoTask(String userName, String taskName);
	
	public void deleteTodoTask(long taskId);


}

