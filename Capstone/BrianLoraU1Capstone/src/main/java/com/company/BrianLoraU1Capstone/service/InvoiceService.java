package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.ConsoleDao;
import com.company.BrianLoraU1Capstone.dao.GameDao;
import com.company.BrianLoraU1Capstone.dao.InvoiceDao;
import com.company.BrianLoraU1Capstone.dao.TShirtDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceService {
    GameDao gameDao;
    TShirtDao tShirtDao;
    ConsoleDao consoleDao;
    InvoiceDao invoiceDao;

    @Autowired
    public InvoiceService(GameDao gameDao, TShirtDao tShirtDao, ConsoleDao consoleDao, InvoiceDao invoiceDao) {
        this.gameDao = gameDao;
        this.tShirtDao = tShirtDao;
        this.consoleDao = consoleDao;
        this.invoiceDao = invoiceDao;
    }

}
