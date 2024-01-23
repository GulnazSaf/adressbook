package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    public WebDriver driver;

    public HelperBase(WebDriver driver) {

        this.driver = driver;
    }

    protected void click(By locator) {

        driver.findElement(locator).click();
    }

    protected void type(String text, By locator) {
      click(locator);
      if (text != null) {
          String existingText = driver.findElement(locator).getAttribute("value");
          if (!text.equals(existingText)) {
              driver.findElement(locator).clear();
              driver.findElement(locator).sendKeys(text);
          }
      }
    }

    protected void choose(String text, By locator){
        driver.findElement(locator).click();
        {
            Select dropdown = new Select(driver.findElement(locator));
            dropdown.selectByVisibleText(text);
        }
    }

    /**
     * It checks to see if an alert message is present.
     * It uses WebDriver methods to check to
     * see if a JavaScript alert() message is on the screen.
     * @return This will return true is an alert message is on the screen.
     */
    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        } // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        } // catch
    } // isAlertPresent()

    public boolean isElementPresent(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
