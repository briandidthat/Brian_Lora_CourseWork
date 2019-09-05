package com.company.BrianLoraU1Capstone.controller;

import com.company.BrianLoraU1Capstone.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TShirtController {

    @Autowired
    InvoiceService invoiceService;


}
