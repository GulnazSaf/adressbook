package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.DateData;
import ru.stqa.pft.addressbook.model.EmploymentData;
import ru.stqa.pft.addressbook.model.NameData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {

        super(driver);
    }
    public void initContactCreation() {
        if (isElementPresent(By.tagName("h1")) &&
                driver.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
            return;
        } else {
            click(By.linkText("add new"));
        }
    }
    public void submitContactCreation() {

        click(By.name("submit"));
    }

    public void fillContactName(NameData nameData) {
        type(nameData.firstName(), By.name("firstname"));
        type(nameData.middleName(), By.name("middlename"));
        type(nameData.lastName(), By.name("lastname"));
        type(nameData.nickname(), By.name("nickname"));
    }

    public void fillEmployment(EmploymentData employmentData) {
        type(employmentData.title(), By.name("title"));
        type(employmentData.company(), By.name("company"));
    }

    public void fillAddress(AddressData addressData) {
        type(addressData.address(), By.name("address"));
        type(addressData.home(), By.name("home"));
        type(addressData.mobile(), By.name("mobile"));
        type(addressData.email(), By.name("email"));
    }

    public void fillBDate(DateData dateData) {
        choose(dateData.day(), By.name("bday"));
        choose(dateData.month(), By.name("bmonth"));
        type(dateData.year(), By.name("byear"));
    }

    public void fillADate(DateData dateData) {
        choose(dateData.day(), By.name("aday"));
        choose(dateData.month(), By.name("amonth"));
        type(dateData.year(), By.name("ayear"));
    }

    public void fillGroup(String groupName, boolean creation) {
        if (creation) {
            choose(groupName, By.name("new_group"));
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
        driver.switchTo().alert().accept();
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@title='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void createContactShort(NameData nameData) {
        initContactCreation();
        fillContactName(nameData);
        submitContactCreation();
        returnToHomePage();
    }

    public boolean isContactThere() {
        return isElementPresent(By.name("selected[]"));
    }

}
