package example.models;

public interface TaskRepository {

    void save(Task task);

    void delete(long id);

    Task findBy(long id);

    TaskList listAll();
}
