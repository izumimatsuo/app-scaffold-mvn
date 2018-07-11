package example.adapters.persistence;

import java.util.List;

import example.models.Task;
import example.models.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    @Autowired
    private TaskMapper taskMapper;

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
    public List<Task> findAll() {
       return taskMapper.selectAll();
    }
}
