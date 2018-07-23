package example.adapters.datasource;

import org.springframework.stereotype.Repository;

import example.models.task.Task;
import example.models.task.TaskList;
import example.models.task.TaskRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class TaskDatasource implements TaskRepository {

    private final TaskMapper taskMapper;

    @Override
    public void save(Task task) {
        if (task.isNew()) {
            taskMapper.insert(task);
            return;
        }
        taskMapper.update(task);
    }

    @Override
    public void delete(Task task) {
        taskMapper.delete(task);
    }

    @Override
    public Task findBy(long id) {
        return taskMapper.select(id);
    }

    @Override
    public TaskList listAll() {
       return new TaskList(taskMapper.selectAll());
    }
}
