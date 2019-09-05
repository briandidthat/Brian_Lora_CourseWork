package com.company.BrianLoraU1Capstone.controller;

import com.company.BrianLoraU1Capstone.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsoleController {

    @Autowired
    InvoiceService invoiceService;
}
