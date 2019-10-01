package com.trilogyed.gamestore.dao;

import com.trilogyed.gamestore.model.Invoice;

import java.util.List;

/*Task:
 *
 */
public interface InvoiceDao {
    Invoice addInvoice(Invoice invoice);
    Invoice getInvoiceById(int id);

    List<Invoice> getAllInvoices();

    void updateInvoice(Invoice invoice);
    void deleteInvoice(int id);
}
