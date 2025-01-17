package com.casaflamingo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @Test
    public void loginPositiveTest(){

        // click on Login link
        click(By.cssSelector("LINKONREGISTRATIONBUTTON"));

        //enter email
        type(By.name("email"), "bibaboba@gmail.com");

        //enter password
        type(By.name("password"), "bibaboba12345678!");

        //click Login Button
        click(By.name("Login Button LOCATOR"));

        //verify SignOut Button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("LinkOnSignOutButton")));
    }
}
