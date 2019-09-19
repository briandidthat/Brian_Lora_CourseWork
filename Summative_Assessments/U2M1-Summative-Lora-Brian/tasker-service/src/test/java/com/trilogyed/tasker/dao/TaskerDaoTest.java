package com.trilogyed.tasker.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {
  @Autowired
  TaskerDao taskerDao;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void addGetDeleteTask() {}

  @Test
  public void getAllTasks() {}

  @Test
  public void getTasksByCategory() {}

  @Test
  public void updateTask() {}
}