package org.docemonos.hackaton1.backend1.mapper;

import java.util.List;

import org.docemonos.hackaton1.backend1.dto.TaskDto;
import org.docemonos.hackaton1.backend1.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    List<TaskDto> taskListToTaskDTOList(List<Task> taskList);
    TaskDto taskToTaskDTO(Task task);

    List<Task> taskDTOListToTaskList(List<TaskDto> taskDTOList);
    Task taskDTOToTask(TaskDto taskDto);
}
