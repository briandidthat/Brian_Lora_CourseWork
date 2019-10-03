package com.trilogyed.gamestore.service;

import com.trilogyed.gamestore.dao.*;
import com.trilogyed.gamestore.model.*;
import com.trilogyed.gamestore.viewmodel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ServiceLayerTest {
    GameDao gameDao;
    ConsoleDao consoleDao;
    TShirtDao tShirtDao;
    InvoiceDao invoiceDao;
    SalesTaxRateDao salesTaxRateDao;
    ProcessingFeeDao processingFeeDao;
    InvoiceService invoiceService;


    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpTShirtDaoMock();
        setUpSalesTaxRateDao();
        setUpProcessingFeeDaoMock();
        invoiceService = new InvoiceService(consoleDao,gameDao,invoiceDao,tShirtDao,processingFeeDao,salesTaxRateDao);
    }

    @Test
    public void saveFindInvoice() {
        // Must pass invoice object without any tax, total, subtotal, unit-price values, processingFee
        // Actual values will be created inside of the service layer
        Invoice invoice = new Invoice();
        invoice.setName("Brian Lora");
        invoice.setStreet("502 Broadway");
        invoice.setCity("New York");
        invoice.setState("NY");
        invoice.setZipCode("10040");
        invoice.setItemType("consoles");
        invoice.setItemId(1);
        invoice.setQuantity(2);

        InvoiceViewModel invoiceViewModel = invoiceService.saveInvoice(invoice);
        InvoiceViewModel invoiceViewModel1 = invoiceService.findInvoiceById(invoiceViewModel.getId());
        assertEquals(invoiceViewModel1, invoiceViewModel);
    }

    @Test
    public void updateInvoice() {
        Invoice invoice = new Invoice();

    }

    // SETUP METHODS
    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);
        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("i7");
        console.setPrice(BigDecimal.valueOf(30.00));
        console.setQuantity(10);

        Console console1 = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("i7");
        console.setPrice(BigDecimal.valueOf(30.00));
        console.setQuantity(10);

        List<Console> consoles = new ArrayList<>();
        consoles.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(consoles).when(consoleDao).getAllConsoles();
        doReturn(console).when(consoleDao).getConsoleById(1);
    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoJdbcTemplateImpl.class);

        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Tekken 6");
        game.setEsrbRating("E");
        game.setDescription("Fight using your favorite characters.");
        game.setPrice(BigDecimal.valueOf(60.00));
        game.setStudio("2K Studios");
        game.setQuantity(10);

        Game game1 = new Game();
        game.setTitle("Tekken 6");
        game.setEsrbRating("E");
        game.setDescription("Fight using your favorite characters.");
        game.setPrice(BigDecimal.valueOf(60.00));
        game.setStudio("2K Studios");
        game.setQuantity(10);

        List<Game> games = new ArrayList<>();

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGameById(1);
        doReturn(games).when(gameDao).getAllGames();
    }

    private void setUpTShirtDaoMock() {
        tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);

        TShirt tShirt = new TShirt();
        tShirt.setTShirtId(1);
        tShirt.setSize("M");
        tShirt.setColor("Blue");
        tShirt.setDescription("New Gucci shirt.");
        tShirt.setPrice(BigDecimal.valueOf(20.00));
        tShirt.setQuantity(10);

        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("M");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("New Gucci shirt.");
        tShirt1.setPrice(BigDecimal.valueOf(20.00));
        tShirt1.setQuantity(10);

        List<TShirt> tShirts = new ArrayList<>();
        tShirts.add(tShirt);

        doReturn(tShirt).when(tShirtDao).addTShirt(tShirt1);
        doReturn(tShirt).when(tShirtDao).getTShirtById(1);
        doReturn(tShirts).when(tShirtDao).getAllTShirts();
    }

    private void setUpInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setName("Brian Lora");
        invoice.setStreet("502 Broadway");
        invoice.setCity("New York");
        invoice.setState("NY");
        invoice.setZipCode("10040");
        invoice.setItemType("consoles");
        invoice.setItemId(1);
        invoice.setQuantity(2);
        invoice.setUnitPrice(BigDecimal.valueOf(30.00));
        invoice.setSubTotal(BigDecimal.valueOf(60.00));
        invoice.setTax(BigDecimal.valueOf(3.59f));
        invoice.setProcessingFee(BigDecimal.valueOf(14.99));
        invoice.setTotal(BigDecimal.valueOf(78.58));

        Invoice invoice1 = new Invoice();
        invoice1.setName("Brian Lora");
        invoice1.setStreet("502 Broadway");
        invoice1.setCity("New York");
        invoice1.setState("NY");
        invoice1.setZipCode("10040");
        invoice1.setItemType("consoles");
        invoice1.setItemId(1);
        invoice1.setQuantity(2);
        invoice1.setUnitPrice(BigDecimal.valueOf(30.00));
        invoice1.setSubTotal(BigDecimal.valueOf(60.00));
        invoice1.setTax(BigDecimal.valueOf(3.59f));
        invoice1.setProcessingFee(BigDecimal.valueOf(14.99));
        invoice1.setTotal(BigDecimal.valueOf(78.58));

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        doReturn(invoices).when(invoiceDao).getAllInvoices();
        doReturn(invoice).when(invoiceDao).getInvoiceById(1);
    }

    private void setUpProcessingFeeDaoMock() {
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("consoles");
        processingFee.setFee(BigDecimal.valueOf(14.99));

        ProcessingFee processingFee1 = new ProcessingFee();
        processingFee1.setProductType("games");
        processingFee1.setFee(BigDecimal.valueOf(1.98));

        ProcessingFee processingFee2 = new ProcessingFee();
        processingFee2.setProductType("tshirts");
        processingFee2.setFee(BigDecimal.valueOf(1.49));

        doReturn(processingFee).when(processingFeeDao).getProcessingFee("consoles");
        doReturn(processingFee1).when(processingFeeDao).getProcessingFee("games");
        doReturn(processingFee2).when(processingFeeDao).getProcessingFee("tshirts");
    }

    private void setUpSalesTaxRateDao() {
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NY");
        salesTaxRate.setRate(BigDecimal.valueOf(0.06));

        SalesTaxRate salesTaxRate1 = new SalesTaxRate();
        salesTaxRate1.setState("NJ");
        salesTaxRate1.setRate(BigDecimal.valueOf(0.05));

        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("NY");
        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("NJ");
    }

}