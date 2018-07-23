package example.models.task;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskList {

    private List<Task> taskList;

    public int counts() {
        return taskList.size();
    }

    public List<Task> asList() {
        return Collections.unmodifiableList(taskList);
    }
}
