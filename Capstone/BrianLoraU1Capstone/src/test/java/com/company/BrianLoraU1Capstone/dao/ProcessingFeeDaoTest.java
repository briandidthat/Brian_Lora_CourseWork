package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.ProcessingFee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

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

    }


    @Test
    public void updateProcessingFee() {
        
    }
}