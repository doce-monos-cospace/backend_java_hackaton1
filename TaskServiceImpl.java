package org.docemonos.hackaton1.backend1.service.impl;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.docemonos.hackaton1.backend1.dao.TareasRepository;
import org.docemonos.hackaton1.backend1.model.Task;
import org.docemonos.hackaton1.backend1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.docemonos.hackaton1.backend1.exceptions.*;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired 
	TareasRepository tareasRepository;
	@Override
	public List<Task> getActivas() {
		
		return tareasRepository.findAllByEsPausadaFalseAndEsCerradaFalseOrderById();
	}
	@Override
	public void createTask(Task tarea) {
		if (tarea.getTiempo_ini()==null)  
			tarea.setTiempo_ini(LocalDateTime.now());
		tareasRepository.save(tarea);
		
	}
	@Override
	public List<Task> getTerminadas() {
		// TODO Auto-generated method stub
		return tareasRepository.findAllByEsCerradaTrueOrderById();
	}
	@Override
	public String getTaskNombre(String id) throws NotFoundException {
		// TODO Auto-generated method stub
		Task task = tareasRepository.findById(id).orElseThrow(NotFoundException::new);
		return task.getNombre();
	}
	@Override
	public void deleteTask(String id) {
		// TODO Auto-generated method stub
		if (!tareasRepository.existsById(id))
			throw new NotFoundException();
		tareasRepository.deleteById(id);
	}
	@Override
	public Task updateTaskPause(String id) throws NotFoundException {
		// TODO Auto-generated method stub
		Task task = tareasRepository.findById(id).orElseThrow(NotFoundException::new);
		if (!task.getEsPausada())
		{
			task.setEsPausada(true);
			task.setTiempo_fin(LocalDateTime.now());
			task.setAcumulada(Duration.between(task.getTiempo_ini(), task.getTiempo_fin()).getSeconds());
		}
		tareasRepository.save(task);
		return task;
	}
	@Override
	public Task updateTaskOn(String id) throws NotFoundException {
		// TODO Auto-generated method stub
		Task task = tareasRepository.findById(id).orElseThrow(NotFoundException::new);
		tareasRepository.save(task);
		return task;
	}
	@Override
	public Task updateTaskEnd(String id) throws NotFoundException {
		// TODO Auto-generated method stub
		Task task = tareasRepository.findById(id).orElseThrow(NotFoundException::new);
		tareasRepository.save(task);
		return task;
	}

}
