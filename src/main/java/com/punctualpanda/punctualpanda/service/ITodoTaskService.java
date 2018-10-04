package com.punctualpanda.punctualpanda.service;

import java.util.Date;
import java.util.List;

import com.punctualpanda.punctualpanda.model.TodoTask;

public interface ITodoTaskService{

	public List<TodoTask> getAllTodoTasks();
		
	public void deleteTodoTask(long taskId);

	public TodoTask addTodoTask(String userName, String taskName, Date dueDate);


}

