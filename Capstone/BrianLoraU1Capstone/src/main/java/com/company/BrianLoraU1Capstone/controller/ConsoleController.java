package com.company.BrianLoraU1Capstone.controller;

import com.company.BrianLoraU1Capstone.service.InvoiceService;
import com.company.BrianLoraU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    InvoiceService invoiceService;

}
