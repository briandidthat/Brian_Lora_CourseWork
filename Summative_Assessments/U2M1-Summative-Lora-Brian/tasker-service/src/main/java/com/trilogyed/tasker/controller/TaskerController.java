package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/tasks")
public class TaskerController {
    @Autowired
    TaskerServiceLayer service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<TaskViewModel> getAllTasks() {
        return service.fetchAllTasks();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel task) {
        return service.newTask(task);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateTask(@RequestBody @Valid TaskViewModel taskViewModel) {
        service.updateTask(taskViewModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TaskViewModel getTaskById(@PathVariable int id) {
        TaskViewModel taskViewModel = service.fetchTask(id);
        if (taskViewModel == null) {
            throw new NotFoundException("Sorry, there are no tasks with that id.");
        } else {
            return taskViewModel;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTask(@PathVariable("id") int id) {
        service.deleteTask(id);
    }

    @RequestMapping(value="/category/{category}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> getTaskByCategory(@PathVariable("category") String category) {
        return service.fetchTasksByCategory(category);
    }
}
