package com.casaflamingo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginPositiveTest() {

        //Login pAge
        clickOnLoginLink();

        //click on Login button
        click(clickOnLoginButton());

        //enter email
        type(By.name("userEmail"), "tyson777777@gmail.com");

        //enter last Name
        type(By.name("password"), "Qwerty123!");

        //click on registration button
        click(clickOnLoginButton());

        //Assert
        Assert.assertTrue(logOutButtonExist().isDisplayed(),
                "The button 'Log out' is not found");

    }

}
