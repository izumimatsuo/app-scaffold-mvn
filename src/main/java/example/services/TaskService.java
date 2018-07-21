package example.services;

import org.springframework.stereotype.Service;

import example.models.Task;
import example.models.TaskList;
import example.models.TaskRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public Task findOne(long id) {
        return taskRepository.findOne(id);
    }

    public TaskList findAll() {
        return taskRepository.findAll();
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void delete(long id) {
        taskRepository.delete(id);
    }
}
