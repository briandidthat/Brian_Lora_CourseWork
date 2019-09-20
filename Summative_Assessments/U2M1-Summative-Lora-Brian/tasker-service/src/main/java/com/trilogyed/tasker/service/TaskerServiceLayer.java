package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    TaskerDao taskerDao;
    AdClient adClient;

    @Autowired
    public TaskerServiceLayer(TaskerDao taskerDao, AdClient adClient) {
        this.taskerDao = taskerDao;
        this.adClient = adClient;
    }

    public TaskViewModel fetchTask(int id) {
        Task task = taskerDao.getTask(id);
        TaskViewModel tvm = buildTaskViewModel(task);
        tvm.setAdvertisement(adClient.getAd());

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> tasks = taskerDao.getAllTasks();
        List<TaskViewModel> taskViewModels = new ArrayList<>();

        for (Task t : tasks) {
            TaskViewModel tvm = buildTaskViewModel(t);
            taskViewModels.add(tvm);
        }
        return taskViewModels;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> tasks = taskerDao.getTasksByCategory(category);
        List<TaskViewModel> taskViewModels = new ArrayList<>();

        for (Task t : tasks) {
            TaskViewModel tvm = buildTaskViewModel(t);
            taskViewModels.add(tvm);
        }
        return taskViewModels;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setDescription(task.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        task = taskerDao.createTask(task);

        taskViewModel.setId(task.getId());
        taskViewModel.setAdvertisement(adClient.getAd());

        return taskViewModel;
    }

    public void deleteTask(int id) {
        taskerDao.deleteTask(id);
    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
    }

    private TaskViewModel buildTaskViewModel(Task task) {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        return tvm;
    }
}
