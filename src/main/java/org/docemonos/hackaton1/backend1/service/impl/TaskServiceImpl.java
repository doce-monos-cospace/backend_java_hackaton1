package org.docemonos.hackaton1.backend1.service.impl;

import java.util.Date;
import java.util.List;

import org.docemonos.hackaton1.backend1.dao.TareasRepository;
import org.docemonos.hackaton1.backend1.model.Tareas;
import org.docemonos.hackaton1.backend1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired 
	TareasRepository tareasRepository;
	@Override
	public List<Tareas> getActivas() {
		
		return tareasRepository.findAllByEsPausadaFalseAndEsCerradaFalseOrderById();
	}
	@Override
	public void createTask(Tareas tarea) {
		if (tarea.getTiempo_ini()==null)  
			tarea.setTiempo_ini(new Date());
		tareasRepository.save(tarea);
		
	}

	@Override
	public List<Tareas> getAll() {
		return tareasRepository.findAll();
	}

}
