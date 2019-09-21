package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    }

    @Test
    public void getAllTasks() {

    }

    @Test
    public void getTasksByCategory() {

    }

    @Test
    public void updateTask() {

    }


}