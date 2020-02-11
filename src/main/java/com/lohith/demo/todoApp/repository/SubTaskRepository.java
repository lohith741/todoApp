package com.lohith.demo.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lohith.demo.todoApp.model.SubTask;

public interface SubTaskRepository extends JpaRepository<SubTask, Long>{

}
