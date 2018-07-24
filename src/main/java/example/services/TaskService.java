package example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.models.task.Task;
import example.models.task.TaskList;
import example.models.task.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task findBy(long id) {
        Task task = taskRepository.findBy(id);
        if (task == null) {
            throw new ApplicationException();
        }
        return task;
    }

    public TaskList listAll() {
        return taskRepository.listAll();
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }
}
