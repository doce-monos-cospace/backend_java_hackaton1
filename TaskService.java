package org.docemonos.hackaton1.backend1.service;

import java.util.List;

import org.docemonos.hackaton1.backend1.model.Task;

public interface TaskService {
	
    List<Task> getActivas();

	void createTask(Task tarea);

	List<Task> getTerminadas();

	String getTaskNombre(String id);

	void deleteTask(String id);

	Task updateTaskPause(String id);

	Task updateTaskOn(String id);

	Task updateTaskEnd(String id);

}
