package example.adapters.datasource.task;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import example.models.task.StatusType;
import example.models.task.Task;
import example.models.task.TaskList;
import example.models.task.TaskRepository;

@Repository
@Profile("dev")
public class TaskHashMap implements TaskRepository {

	private Map<Long, Task> repositoryMap;
	private long counter;
	
	public TaskHashMap() {
		this.repositoryMap = new HashMap<>();
		counter = 1;
		setup();
	}
	
	protected void setup() {
		Task initial = new Task();
	    setProperty(initial, "title", "書籍を購入する");
	    setProperty(initial, "memo", "ネット通販を利用する");
	    setProperty(initial, "status", StatusType.未実行);
	    save(initial);

	    initial = new Task();
	    setProperty(initial, "title", "プログラミングをする");
	    setProperty(initial, "memo", "プロファイルで切り替える");
	    setProperty(initial, "status", StatusType.実行済);
	    save(initial);

	    initial = new Task();
	    setProperty(initial, "title", "電話する");
	    setProperty(initial, "memo", null);
	    setProperty(initial, "status", StatusType.実行中);
	    save(initial);
	}
	
	public static void setProperty(Object target, String filedName, Object value) {
		Class<? extends Object> clazz = target.getClass();
		try {
			Field field = clazz.getDeclaredField(filedName);
			field.setAccessible(true);
			field.set(target, value);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public void save(Task task) {
		if (repositoryMap.containsKey(task.getId())) {
			Task before = repositoryMap.get(task.getId());
			setProperty(task, "createAt", before.getCreateAt());
			repositoryMap.put(task.getId(), task);
			return;
		}
		setProperty(task, "id", counter++);
		setProperty(task, "createAt", LocalDateTime.now());
		repositoryMap.put(task.getId(), task);
	}

	@Override
	public void delete(Task task) {
		repositoryMap.remove(task.getId());
	}

	@Override
	public Task findBy(long id) {
		return repositoryMap.get(id);
	}

	@Override
	public TaskList listAll() {
		return new TaskList(new ArrayList<>(repositoryMap.values()));
	}

}
