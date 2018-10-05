package com.punctualpanda.punctualpanda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.punctualpanda.punctualpanda.model.TodoTask;

@Repository
public interface TodoTaskRepository extends CrudRepository<TodoTask, Long>{
	
	List<TodoTask> findAll();	
	@SuppressWarnings("unchecked")
	TodoTask save(TodoTask todoTask);
	void deleteById(Long taskId);
}
