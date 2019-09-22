package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdClient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TaskerServiceLayerTest {
    TaskerServiceLayer taskerServiceLayer;
    TaskerDao taskerDao;
    AdClient adClient;


    @Before
    public void setUp() throws Exception {
        setUpTaskerDaoMock();
        setUpAdClientMock();
        taskerServiceLayer = new TaskerServiceLayer(taskerDao, adClient);
    }

    @Test
    public void fetchTask() {
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setTaskDescription("Summative 6");
        taskViewModel.setCreateDate(LocalDate.of(2019,9,20));
        taskViewModel.setDueDate(LocalDate.of(2019,9,22));
        taskViewModel.setCategory("Homework assignment");
    }

    @Test
    public void fetchAllTasks() {
        List<TaskViewModel> tasks = taskerServiceLayer.fetchAllTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    public void fetchTasksByCategory() {
        List<TaskViewModel> tasks = taskerServiceLayer.fetchTasksByCategory("Homework assignment");
        assertEquals(1, tasks.size());
    }

    @Test
    public void newTask() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setTaskDescription("Summative 6");
        tvm.setCreateDate(LocalDate.of(2019,9,20));
        tvm.setDueDate(LocalDate.of(2019,9,22));
        tvm.setCategory("Homework assignment");
        tvm = taskerServiceLayer.newTask(tvm);

        System.out.println(tvm.getId());
        TaskViewModel taskViewModel2 = taskerServiceLayer.fetchTask(tvm.getId());
        assertEquals(taskViewModel2, tvm);
    }

    @Test
    public void updateTask() {
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setId(33);
        taskViewModel.setTaskDescription("Summative 7");
        taskViewModel.setCreateDate(LocalDate.of(2019,9,23));
        taskViewModel.setDueDate(LocalDate.of(2019,9,30));
        taskViewModel.setCategory("Summative assessment");
        taskViewModel.setAdvertisement(adClient.getAd());
        taskerServiceLayer.updateTask(taskViewModel);
        // GET UPDATED CLASS AND
        TaskViewModel taskViewModel1 = taskerServiceLayer.fetchTask(taskViewModel.getId());
        assertEquals(taskViewModel1, taskViewModel);
    }

    private void setUpAdClientMock() {
        adClient = mock(AdClient.class);
        doReturn("Get a new Car today").when(adClient).getAd();
    }

    private void setUpTaskerDaoMock() {
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();
        task.setId(1);
        task.setTaskDescription("Summative 6");
        task.setCreateDate(LocalDate.of(2019,9,20));
        task.setDueDate(LocalDate.of(2019,9,22));
        task.setCategory("Homework assignment");

        Task task1 = new Task();
        task1.setTaskDescription("Summative 6");
        task1.setCreateDate(LocalDate.of(2019,9,20));
        task1.setDueDate(LocalDate.of(2019,9,22));
        task1.setCategory("Homework assignment");

        Task task2 = new Task();
        task2.setId(33);
        task2.setTaskDescription("Summative 7");
        task2.setCreateDate(LocalDate.of(2019,9,23));
        task2.setDueDate(LocalDate.of(2019,9,30));
        task2.setCategory("Summative assessment");

        List<Task> tasks = new ArrayList<>();
        tasks.add(task);

        // will mimic GetTask, Update, GetAll,, GetTasksByCategory, DeleteTask
        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(1);
        doReturn(task2).when(taskerDao).getTask(33);
        doReturn(tasks).when(taskerDao).getAllTasks();
        doReturn(tasks).when(taskerDao).getTasksByCategory("Homework assignment");
        doNothing().when(taskerDao).deleteTask(1);
        doNothing().when(taskerDao).updateTask(task2);
    }

}