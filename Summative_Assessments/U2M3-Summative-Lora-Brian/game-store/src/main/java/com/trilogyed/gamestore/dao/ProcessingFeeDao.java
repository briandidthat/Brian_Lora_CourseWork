package com.trilogyed.gamestore.dao;

import com.trilogyed.gamestore.model.ProcessingFee;

import java.util.List;

/*Task:
 *
 */
public interface ProcessingFeeDao {
    ProcessingFee addProcessingFee(ProcessingFee processingFee);
    ProcessingFee getProcessingFee(String productType);

    List<ProcessingFee> getAllProcessingFees();

    void updateProcessingFee(ProcessingFee processingFee);
    void deleteProcessingFee(String productType);
}
