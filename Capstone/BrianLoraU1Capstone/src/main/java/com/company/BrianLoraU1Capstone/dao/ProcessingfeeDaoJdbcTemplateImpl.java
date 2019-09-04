package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProcessingfeeDaoJdbcTemplateImpl implements ProcessingFeeDao {
    private JdbcTemplate jdbcTemplate;

    // PREPARED STATEMENTS
    private static final String INSERT_PROCESSING_FEE_SQL =
            "insert into processing_fee (product_type, fee) values (?, ?)";
    private static final String SELECT_PROCESSING_FEE_BY_PRODUCT_TYPE_SQL =
            "select * from processing_fee where product_type = ?";
    private static final String SELECT_ALL_PROCESSING_FEES_SQL =
            "select * from processing_fee";
    private static final String UPDATE_PROCESSING_FEE_SQL =
            "update processing_fee set fee = ? where product_type = ?";
    @Autowired
    public ProcessingfeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public ProcessingFee addProcessingFee(ProcessingFee processingFee) {
        return null;
    }

    @Override
    public ProcessingFee getProcessingFee(String productType) {
        return null;
    }

    @Override
    public List<ProcessingFee> getAllProcessingFees() {
        return null;
    }

    @Override
    public void updateProcessingFee(ProcessingFee processingFee) {
        jdbcTemplate.update(UPDATE_PROCESSING_FEE_SQL,
                processingFee.getFee(),
                processingFee.getProductType());
    }

    // HELPER METHOD
    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }
}
