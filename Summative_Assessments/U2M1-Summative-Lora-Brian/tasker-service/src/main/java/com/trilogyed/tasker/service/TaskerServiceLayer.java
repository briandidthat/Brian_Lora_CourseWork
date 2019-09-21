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
        if (task == null) {
            return null;
        } else {
            return buildTaskViewModel(task);
        }
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
        task.setTaskDescription(taskViewModel.getTaskDescription());
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
        task.setTaskDescription(taskViewModel.getTaskDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        taskerDao.updateTask(task);
    }

    private TaskViewModel buildTaskViewModel(Task task) {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(task.getId());
        tvm.setTaskDescription(task.getTaskDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(adClient.getAd());

        return tvm;
    }
}
