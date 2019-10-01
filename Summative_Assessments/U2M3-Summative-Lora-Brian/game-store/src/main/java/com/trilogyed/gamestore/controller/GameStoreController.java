package com.trilogyed.gamestore.controller;

import com.trilogyed.gamestore.exception.NotFoundException;
import com.trilogyed.gamestore.service.InvoiceService;
import com.trilogyed.gamestore.viewmodel.InvoiceViewModel;
import com.trilogyed.gamestore.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/invoice")
public class GameStoreController {
    @Autowired
    InvoiceService invoiceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody @Valid OrderViewModel orderViewModel) {
        return invoiceService.saveInvoice(orderViewModel);
    }

    // ID PATH VARIABLE
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable("id") int invoiceId) {
        InvoiceViewModel invoiceViewModel = invoiceService.findInvoiceById(invoiceId);
        if (invoiceViewModel == null) {
            throw new NotFoundException("Sorry, an invoice could not be retrieved for id: " + invoiceId + ".");
        }
        return invoiceViewModel;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@PathVariable("id") int invoiceId, @RequestBody @Valid InvoiceViewModel invoiceViewModel) {
        if (invoiceViewModel.getId() == 0) {
            invoiceViewModel.setId(invoiceId);
        }
        if (invoiceId != invoiceViewModel.getId()) {
            throw new IllegalArgumentException("Invoice ID on path must match the ID in the Customer object");
        }
        invoiceService.updateInvoice(invoiceViewModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable("id") int invoiceId) {
        invoiceService.removeInvoice(invoiceId);
    }

}
