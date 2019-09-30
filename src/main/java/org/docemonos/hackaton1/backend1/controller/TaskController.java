package org.docemonos.hackaton1.backend1.controller;

import java.util.List;
import java.sql.Timestamp;

import org.docemonos.hackaton1.backend1.dto.UserDto;
import org.docemonos.hackaton1.backend1.model.Tareas;
import org.docemonos.hackaton1.backend1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/task")
public class TaskController {
	
    @Autowired
    private  TaskService taskService;


    @GetMapping("/activas")
    public List<Tareas> getTaskActivas() {
        return taskService.getActivas();
    }

    @GetMapping("/")
    public List<Tareas> getAllTasks() {
        return taskService.getAll();
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTask(@RequestBody Tareas tarea){
        taskService.createTask(tarea);
    }

}
