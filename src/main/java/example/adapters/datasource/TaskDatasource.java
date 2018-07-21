package example.adapters.datasource;

import org.springframework.stereotype.Repository;

import example.models.Task;
import example.models.TaskList;
import example.models.TaskRepository;
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
    public void delete(long id) {
        taskMapper.delete(id);
    }

    @Override
    public Task findOne(long id) {
        return taskMapper.select(id);
    }

    @Override
    public TaskList findAll() {
       return new TaskList(taskMapper.selectAll());
    }
}
