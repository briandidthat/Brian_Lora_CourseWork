package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.ProcessingFee;

import java.util.List;

public interface ProcessingFeeDao {
    ProcessingFee addProcessingFee(ProcessingFee processingFee);
    ProcessingFee getProcessingFee(String productType);

    List<ProcessingFee> getAllProcessingFees();

    void updateProcessingFee(ProcessingFee processingFee);
}