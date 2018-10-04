package com.punctualpanda.punctualpanda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoTask{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long taskId; 
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="taskName")
	private String taskName;

	public final long getTaskId() {
		return taskId;
	}

	public final void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public final String getUserName() {
		return userName;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final String getTaskName() {
		return taskName;
	}

	public final void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
}