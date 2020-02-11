package com.lohith.demo.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lohith.demo.todoApp.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {

}
