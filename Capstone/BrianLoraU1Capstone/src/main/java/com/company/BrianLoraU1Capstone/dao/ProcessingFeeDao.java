package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.ProcessingFee;

public interface ProcessingFeeDao {
    ProcessingFee addProcessingFee(ProcessingFee processingFee);
    ProcessingFee getProcessingFee(String productType);

    void updateProcessingFee(ProcessingFee processingFee);
    void deleteProcessingFee(int id);
}