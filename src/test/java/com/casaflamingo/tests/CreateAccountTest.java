package com.casaflamingo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {


    @Test
    public void newUserRegistrationPositiveTest() {
        // click on Login link
        click(By.cssSelector("LINKONREGISTRATIONBUTTON"));

        //enter email
        type(By.name("email"), "bibaboba@gmail.com");

        //enter password
        type(By.name("password"), "bibaboba12345678!");

        //click on registration button
        click(By.name("registration"));

        //verify SignOut Button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("LinkOnSignOutButton")));
    }


    @Test
    public void existedUserRegistrationNegativeTest() {
        // click on Login link
        click(By.cssSelector("LINKONREGISTRATIONBUTTON"));

        //enter email
        type(By.name("email"), "bibaboba@gmail.com");

        //enter password
        type(By.name("password"), "bibaboba12345678!");

        //click on registration button
        click(By.name("registration"));

        //verify Alert is displayed
        Assert.assertTrue(isAlertDisplayed()); //в случае если у нас будет окно придупреждения
    }


}
