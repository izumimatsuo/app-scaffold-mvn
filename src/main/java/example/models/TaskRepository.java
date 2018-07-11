package example.models;

import java.util.List;

public interface TaskRepository {

    void save(Task task);

    void delete(long id);

    Task findOne(long id);

    List<Task> findAll();
}
