package com.company.BrianLoraU1Capstone;

import com.company.BrianLoraU1Capstone.dao.*;
import com.company.BrianLoraU1Capstone.service.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GameDaoTest.class,
        ConsoleDaoTest.class,
        TShirtDaoTest.class,
        InvoiceDaoTest.class,
        ConsoleServiceTest.class,
        GameServiceTest.class,
        InvoiceService.class,
        TShirtServiceTest.class
})
public class BrianLoraU1CapstoneTestSuite {
}
