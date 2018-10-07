package com.punctualpanda.punctualpanda.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class TodoTask{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long taskId; 
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="taskName")
	private String taskName;

	@Column(name="dueDate")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dueDate;

	
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

	public final Date getDueDate() {
		return dueDate;
	}

	public final void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TodoTask))
			return false;
		TodoTask other = (TodoTask) obj;
		if (taskName == null) {
			if (other.taskName != null)
				return false;
		} else if (!taskName.equals(other.taskName))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
}