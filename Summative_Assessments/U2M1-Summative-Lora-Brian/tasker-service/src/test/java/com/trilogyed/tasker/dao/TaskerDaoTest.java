package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {
    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception {
        List<Task> tasks = taskerDao.getAllTasks();
        for (Task task : tasks) {
            taskerDao.deleteTask(task.getId());
        }
    }

    @Test
    public void addGetDeleteTask() {
        // ADD
        Task task = new Task();
        task.setTaskDescription("Create all unit tests");
        task.setCreateDate(LocalDate.of(2019, 9, 20));
        task.setDueDate(LocalDate.of(2019, 9, 21));
        task.setCategory("Summative");
        task = taskerDao.createTask(task);
        // GET
        Task task1 = taskerDao.getTask(task.getId());
        assertEquals(task1, task);
        // DELETE
        taskerDao.deleteTask(task.getId());
        task1 = taskerDao.getTask(task.getId());
        assertNull(task1);
    }

    @Test
    public void getAllTasks() {
        // ADD TO DB
        Task task = new Task();
        task.setTaskDescription("Create all unit tests");
        task.setCreateDate(LocalDate.of(2019, 9, 20));
        task.setDueDate(LocalDate.of(2019, 9, 21));
        task.setCategory("Summative");
        task = taskerDao.createTask(task);
        // VERIFY THAT ONLY ONE TASKS EXISTS
        List<Task> tasks = taskerDao.getAllTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    public void getTasksByCategory() {
        // ADD TO DB
        Task task = new Task();
        task.setTaskDescription("Create all unit tests");
        task.setCreateDate(LocalDate.of(2019, 9, 20));
        task.setDueDate(LocalDate.of(2019, 9, 21));
        task.setCategory("Summative");
        task = taskerDao.createTask(task);
        // VERIFY THAT ONLY ONE TASKS EXISTS
        List<Task> tasks = taskerDao.getAllTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    public void updateTask() {
        // ADD TO DB
        Task task = new Task();
        task.setTaskDescription("Create all unit tests");
        task.setCreateDate(LocalDate.of(2019, 9, 20));
        task.setDueDate(LocalDate.of(2019, 9, 21));
        task.setCategory("Summative");
        task = taskerDao.createTask(task);
        // UPDATE VALUES
        task.setDueDate(LocalDate.of(2019, 9, 22));
        task.setTaskDescription("Create all unit tests");
        taskerDao.updateTask(task);
        // CHECK TO ENSURE NEW VALUES
        Task task1 = taskerDao.getTask(task.getId());
        assertEquals(task1, task);
    }

}