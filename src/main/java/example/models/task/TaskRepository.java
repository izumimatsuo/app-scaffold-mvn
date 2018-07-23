package example.models.task;

public interface TaskRepository {

    void save(Task task);

    void delete(Task task);

    Task findBy(long id);

    TaskList listAll();
}
