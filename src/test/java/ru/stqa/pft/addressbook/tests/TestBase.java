package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void testSetup() throws Exception
    {
        app.init("firefox");
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }
}
