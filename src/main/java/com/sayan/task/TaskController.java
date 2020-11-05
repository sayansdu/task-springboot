package com.sayan.task;

import com.sayan.task.model.Task;
import com.sayan.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.findTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Object> createTask(@RequestBody Task task) {
        Task savedTask = taskService.save(task);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedTask.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/tasks")
    public ResponseEntity<Object> updateTask(@RequestBody Task task) {
        Task savedTask = taskService.save(task);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedTask.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
