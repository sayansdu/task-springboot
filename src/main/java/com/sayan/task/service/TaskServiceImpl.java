package com.sayan.task.service;

import com.sayan.task.model.Task;
import com.sayan.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public
    Task findById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> findTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
