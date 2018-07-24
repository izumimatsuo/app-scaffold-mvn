package example.controllers.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.models.task.Task;
import example.models.task.TaskList;
import example.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskApiController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> index() {
        TaskList tasklist = taskService.listAll();
        return tasklist.asList();
    }

    @GetMapping("/{id}")
    public Task show(@PathVariable long id) {
        Task task = taskService.findBy(id);
        return task;
    }

}
