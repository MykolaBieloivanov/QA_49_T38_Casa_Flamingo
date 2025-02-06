package com.casaflamingo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {


    @Test
    public void newUserRegistrationPositiveTest() {

        int i = (int)((System.currentTimeMillis()/1000%3600));

        // click on Login link
        app.getUser().clickOnLoginLink();

        //click on Registration button
        app.getUser().clickOnRegistrationButton();

        //enter firstName
        app.getUser().fillRegisterForm("tyson" + i + "@gmail.com", "Qwerty123!");

        //click on registration button
        app.getUser().clickOnRegistrationButton();

        //  verify that we are sign up
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login']")).isDisplayed(), "No such element has been found");
    }




    public void click(By locator) {
        app.getUser().click(locator);
    }


    @Test (enabled = false)
    public void alreadyExistedUserNegativeTest() {
        // click on Login link
        app.getUser().clickOnLoginLink();

        //click on Registration button
        app.getUser().clickOnRegistrationButton();

        //fill important info
        app.getUser().fillRegisterForm("tyson777777@gmail.com", "Qwerty123!");

        //click on registration button
        app.getUser().clickOnRegistrationButton();

        //  verify that user already exist
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'User with email')]")).isDisplayed(),
                "No message");
    }


}
