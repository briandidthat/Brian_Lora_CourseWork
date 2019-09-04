package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.Invoice;

import java.util.List;

public interface InvoiceDao {
    Invoice addInvoice(Invoice invoice);
    Invoice getInvoiceById(int id);

    List<Invoice> getAllInvoices();

    void updateInvoice(Invoice invoice);
    void deleteInvoice(int id);
}
