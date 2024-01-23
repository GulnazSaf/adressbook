package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(username, By.name("user"));
        type(password, By.name("pass"));
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
