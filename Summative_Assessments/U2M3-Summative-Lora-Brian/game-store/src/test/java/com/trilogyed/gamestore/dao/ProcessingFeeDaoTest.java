package com.trilogyed.gamestore.dao;

import com.trilogyed.gamestore.model.ProcessingFee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoTest {
    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {
        List<ProcessingFee> processingFees = processingFeeDao.getAllProcessingFees();
        for(ProcessingFee p : processingFees) {
            processingFeeDao.deleteProcessingFee(p.getProductType());
        }
    }

    @Test
    public void addGetDeleteProcessingFee() {
        // add
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(new BigDecimal("10.99"));
        processingFee.setProductType("CONSOLE");
        processingFee = processingFeeDao.addProcessingFee(processingFee);
        // get
        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());
        assertEquals(processingFee1, processingFee);
        // delete
        processingFeeDao.deleteProcessingFee(processingFee.getProductType());
        processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());
        assertNull(processingFee1);
    }

    @Test
    public void updateProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(new BigDecimal("10.99"));
        processingFee.setProductType("CONSOLE");
        processingFee = processingFeeDao.addProcessingFee(processingFee);
        // set values and store in DB
        processingFee.setFee(new BigDecimal("11.56"));
        processingFeeDao.updateProcessingFee(processingFee);
        // test for equality after update
        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());
        assertEquals(processingFee1, processingFee);
    }
}