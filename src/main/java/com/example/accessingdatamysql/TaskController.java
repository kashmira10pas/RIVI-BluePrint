package com.example.accessingdatamysql;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	@Autowired
    TaskRepository taskRepository;

// Get All Tasks
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }

// Create a new Task
    @PostMapping("/tasks")
    public Task createNote(@Valid @RequestBody Task task) {
        return taskRepository.save(task);
    }
    
 // Get a Single Task
    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable(value = "id") Long taskId) throws TaskNotFoundException {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));
    }

 //Update a Task
    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable(value = "id") Long taskId,
                           @Valid @RequestBody Task taskDetails) throws TaskNotFoundException {

Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

task.setAssignedTo(taskDetails.getAssignedTo());
task.setAssignedToStory(taskDetails.getAssignedToStory());
//task.setut(taskDetails.getut());
task.setDescription(taskDetails.getDescription());
task.setId(taskDetails.getId());
task.setTitle(taskDetails.getTitle());



Task updatedTask = taskRepository.save(task);

return updatedTask;
    }

// Delete a Task
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(value = "id") Long taskId) throws TaskNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        taskRepository.delete(task);

return ResponseEntity.ok().build();
    }

}
