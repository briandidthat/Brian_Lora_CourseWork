package com.trilogyed.gamestore.controller;

import com.trilogyed.gamestore.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GameStoreController {
    @Autowired
    InvoiceService invoiceService;
}
