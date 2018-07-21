package example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import example.models.StatusType;
import example.models.Task;
import example.models.TaskList;
import example.services.TaskService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @ModelAttribute("task")
    Task setupTask() {
        return new Task();
    }

    @ModelAttribute("statusTypes")
    StatusType[] statusTypes() {
        return StatusType.values();
    }

    @GetMapping
    public String index(Model model) {
        TaskList tasklist = taskService.listAll();
        model.addAttribute("task_counts", tasklist.counts());
        model.addAttribute("task_list", tasklist.asList());
        return "tasks/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        Task task = taskService.findBy(id);
        model.addAttribute("task", task);
        return "tasks/show";
    }

    @GetMapping("/add")
    public String add() {
        return "tasks/add";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Task task = taskService.findBy(id);
        model.addAttribute("task", task);
        return "tasks/edit";
    }

    @PostMapping
    public String create(@Validated Task task, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "tasks/add";
        }
        taskService.save(task);
        attributes.addFlashAttribute("notice", "タスクの登録に成功しました。");
        return "redirect:/tasks";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable long id, @Validated Task task, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "tasks/edit";
        }
        taskService.save(task);
        attributes.addFlashAttribute("notice", "タスクの更新に成功しました。");
        return "redirect:/tasks/" + id;
    }

    @DeleteMapping("/{id}")
    public String destroy(@PathVariable long id, RedirectAttributes attributes) {
        Task task = taskService.findBy(id);
        taskService.delete(task);
        attributes.addFlashAttribute("notice", "タスクの削除に成功しました。");
        return "redirect:/tasks";
    }
}
