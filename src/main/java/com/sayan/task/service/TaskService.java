package com.sayan.task.service;

import com.sayan.task.model.Task;

import java.util.List;

public interface TaskService {

    Task findById(long id);

    List<Task> findTasks();

    Task save(Task task);

}
