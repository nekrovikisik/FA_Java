package com.example.Todo.demo.services;

import com.example.Todo.demo.models.Task;
import com.example.Todo.demo.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class TaskService {

//    @Autowired
    private TaskRepository taskRepository;

//    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }


    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTask(Integer id) {
        return (Task)this.taskRepository.findById(id).get();
    }


    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }


}
