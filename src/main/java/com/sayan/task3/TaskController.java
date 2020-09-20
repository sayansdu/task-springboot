package com.sayan.task3;

import com.sayan.task3.model.Task;
import com.sayan.task3.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isEmpty()) {
            throw new RuntimeException("task is not found");
        }
        return task.get();
    }

    @PostMapping("/tasks")
    public ResponseEntity<Object> createTask(@RequestBody Task task) {
        Task savedTask = taskRepository.save(task);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedTask.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
