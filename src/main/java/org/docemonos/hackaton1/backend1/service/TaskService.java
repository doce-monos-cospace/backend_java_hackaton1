package org.docemonos.hackaton1.backend1.service;

import java.util.List;

import org.docemonos.hackaton1.backend1.model.Tareas;

public interface TaskService {
	
    List<Tareas> getActivas();

	void createTask(Tareas tarea);

}
