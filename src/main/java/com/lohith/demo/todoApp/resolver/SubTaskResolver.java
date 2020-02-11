package com.lohith.demo.todoApp.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.lohith.demo.todoApp.model.SubTask;
import com.lohith.demo.todoApp.model.Task;
import com.lohith.demo.todoApp.repository.TaskRepository;

@Component
public class SubTaskResolver implements GraphQLResolver<SubTask> {
	@Autowired
	private TaskRepository taskRepository ;

	public SubTaskResolver(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Task getTask( SubTask subTask) {
		return taskRepository.findOne(subTask.getTask().getId());
	}

}
