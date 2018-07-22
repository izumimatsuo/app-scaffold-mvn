package example.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.models.Task;
import example.models.TaskList;
import example.services.TaskService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskApiController {

    private final TaskService taskService;

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
