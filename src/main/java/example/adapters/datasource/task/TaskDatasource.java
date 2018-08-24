package example.adapters.datasource.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import example.models.task.Task;
import example.models.task.TaskList;
import example.models.task.TaskRepository;

@Repository
public class TaskDatasource implements TaskRepository {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public void save(Task task) {
        int result = taskMapper.update(task);
        if (result == 0) {
            taskMapper.insert(task);
        }
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
