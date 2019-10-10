package org.docemonos.hackaton1.backend1.controller;

import java.util.List;

import org.docemonos.hackaton1.backend1.dto.TaskDto;
import org.docemonos.hackaton1.backend1.mapper.TaskMapper;
import org.docemonos.hackaton1.backend1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/task")
public class TaskController {
	
   
    @Autowired
    private  TaskService taskService;
    @Autowired
    private  TaskMapper taskMapper;

    
    //GET ACTIVAS
    @GetMapping("/activas")
    public List<TaskDto> getTaskActiva() {
        return taskMapper.taskListToTaskDTOList(taskService.getActivas());
    }

    //GET TERMINADA
    @GetMapping("/terminadas")
    public List<TaskDto> getTaskTerminada() {
        return taskMapper.taskListToTaskDTOList(taskService.getTerminadas());
    }    
    
    //GET NOMBRE
    @GetMapping("/nombre/{id}")
    public String getTaskNombre(@PathVariable("id") String id) {
        return taskService.getTaskNombre(id);
    }

    //GET ALL
    @GetMapping("/")
    public List<TaskDto> getTasks() {
        return taskMapper.taskListToTaskDTOList(taskService.getTerminadas());
    } 
    
    //POST CREATE
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTask(@RequestBody TaskDto tarea){
        taskService.createTask(taskMapper.taskDTOToTask(tarea));
    }

    //DELETE BORRAR
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteTask(@PathVariable("id") String id) {
        taskService.deleteTask(id);
    }

    
    //PUT PAUSAR TAREA
    @PutMapping("pausar/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public TaskDto pauseTask(@PathVariable("id") String id) {
        return taskMapper.taskToTaskDTO(taskService.updateTaskPause(id));
    }
    
    //PUT CONTINUAR TAREA
    @PutMapping("continuar/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public TaskDto continueTask(@PathVariable("id") String id) {
        return taskMapper.taskToTaskDTO(taskService.updateTaskOn(id));
    }
    
    //PUT FINALIZAR TAREA
    @PutMapping("finalizar/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public TaskDto endTask(@PathVariable("id") String id) {
        return taskMapper.taskToTaskDTO(taskService.updateTaskEnd(id));
    }
    
}
