package com.lohith.demo.todoApp.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.lohith.demo.todoApp.model.SubTask;
import com.lohith.demo.todoApp.model.Task;
import com.lohith.demo.todoApp.repository.SubTaskRepository;
import com.lohith.demo.todoApp.repository.TaskRepository;

import javassist.NotFoundException;

public class Mutation implements GraphQLMutationResolver{
	private TaskRepository taskRepository ;
	private SubTaskRepository subTaskRepository ;
	
	@Autowired
	public Mutation(TaskRepository taskRepository, SubTaskRepository subTaskRepository) {
		this.taskRepository = taskRepository;
		this.subTaskRepository = subTaskRepository;
	}

	public Task createTask(String name, String description) {
		Task task = new Task();
		task.setName(name);
		task.setDescription(description);

		taskRepository.save(task);

		return task;
	}

	public SubTask createSubTask(String title, String description, Long taskId) {
		SubTask subtask = new SubTask();
		subtask.setTask(new Task(taskId));
		subtask.setTitle(title);
		subtask.setDescription(description);

		subTaskRepository.save(subtask);

		return subtask;
	}
	
	public boolean deleteSubTask(Long id) {
		subTaskRepository.delete(id);
		return true;
	}
	
	public SubTask updateSubTask(Long id, String title, String description) throws NotFoundException {
		SubTask subtask = subTaskRepository.findOne(id);

		if (subtask!= null) {

			if (title != null)
				subtask.setTitle(title);
			if (description != null)
				subtask.setDescription(description);

			subTaskRepository.save(subtask);
			return subtask;
		}

		throw new NotFoundException("Not found Tutorial to update!");
	}
}

