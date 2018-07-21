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

    public Task findBy(long id) {
        return taskRepository.findBy(id);
    }

    public TaskList listAll() {
        return taskRepository.listAll();
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void delete(long id) {
        taskRepository.delete(id);
    }
}
