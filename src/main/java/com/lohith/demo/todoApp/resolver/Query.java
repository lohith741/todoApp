package com.lohith.demo.todoApp.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lohith.demo.todoApp.model.SubTask;
import com.lohith.demo.todoApp.model.Task;
import com.lohith.demo.todoApp.repository.SubTaskRepository;
import com.lohith.demo.todoApp.repository.TaskRepository;

@Component
public class Query implements GraphQLQueryResolver {
	private TaskRepository taskRepository ;
	private SubTaskRepository subTaskRepository ;
	
	@Autowired
	public Query(TaskRepository taskRepository, SubTaskRepository subTaskRepository) {
		this.taskRepository = taskRepository;
		this.subTaskRepository = subTaskRepository;
	}
	
	public Iterable<Task> findAllTasks() {
		return taskRepository.findAll();
	}

	public Iterable<SubTask> findAllSubTasks() {
		return subTaskRepository.findAll();
	}

	public long countTasks() {
		return taskRepository.count();
	}

	public long countSubTasks() {
		return subTaskRepository.count();
	}

}