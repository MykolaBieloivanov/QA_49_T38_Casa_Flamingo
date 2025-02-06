package com.casaflamingo.tests;

import com.casaflamingo.fw.UserHelper;
import com.casaflamingo.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    WebDriver driver;


    @Test
    public void loginPositiveTest() {

        //Login pAge
        app.getUser().clickOnLoginLink();

        //click on Login button
        app.getUser().click(UserHelper.clickOnLoginButton());

        //fill login form
        app.getUser().fillRegisterLoginForm(new User().setEmail("tyson777777@gmail.com").setPassword("Qwerty123!"));

        //click on registration button
        app.getUser().click(UserHelper.clickOnLoginButton());

        //Assert
        Assert.assertTrue(app.getUser().logOutButtonExist().isDisplayed(),
                "The button 'Log out' is not found");

    }


    @Test
    public void loginNegativeWithoutEmailTest() {

        //Login pAge
        app.getUser().clickOnLoginLink();

        //click on Login button
        app.getUser().click(UserHelper.clickOnLoginButton());

        //enter email
        app.getUser().fillRegisterLoginForm(new User().setEmail("").setPassword("Qwerty123!"));

        //click on registration button
        app.getUser().click(UserHelper.clickOnLoginButton());

        // CheckError
        WebElement errorMessage = driver.findElement(By.cssSelector("div._error_o39hb_35"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error 'Username is required!'");

    }

}
