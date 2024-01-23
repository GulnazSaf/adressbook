package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.DateData;
import ru.stqa.pft.addressbook.model.EmploymentData;
import ru.stqa.pft.addressbook.model.NameData;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactName
                (new NameData("ewdfe", "vzdcvs", "zvesv", "zevwe"));
        app.getContactHelper().fillEmployment(new EmploymentData("plumber", "acr"));
        app.getContactHelper().fillAddress(new AddressData("Moscow", "0975323456","67890","email@mail.com"));
        app.getContactHelper().fillBDate(new DateData("12","March","1996"));
        app.getContactHelper().fillADate(new DateData("13", "April","1990"));
        app.getContactHelper().fillGroup("new2", true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

    }
