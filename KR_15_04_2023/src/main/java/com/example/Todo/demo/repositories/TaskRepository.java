package com.example.Todo.demo.repositories;

import com.example.Todo.demo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
