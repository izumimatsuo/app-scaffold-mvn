package example.models.task;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskList {

    private List<Task> values;

    public int counts() {
        return values.size();
    }

    public List<Task> asList() {
        return Collections.unmodifiableList(values);
    }
}
