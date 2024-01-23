package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

    private ContactHelper contactHelper;

    public void init(String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            throw new Exception("Incorrect Browser");
        }

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("http://127.0.0.1/addressbook/");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        contactHelper = new ContactHelper(driver);

        SessionHelper sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper () {
        return contactHelper;
    }
}
