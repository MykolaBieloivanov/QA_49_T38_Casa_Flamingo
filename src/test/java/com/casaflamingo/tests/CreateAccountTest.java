package com.casaflamingo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {


    @Test
    public void newUserRegistrationPositiveTest() {

        int i = (int)((System.currentTimeMillis()/1000%3600));

        // click on Login link
        clickOnLoginLink();

        //click on Registration button
        clickOnRegistrationButton();

        //enter firstName
        fillRegisterForm("tyson" + i + "@gmail.com", "Qwerty123!");

        //click on registration button
        clickOnRegistrationButton();

        //  verify that we are sign up
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login']")).isDisplayed(), "No such element has been found");
    }


    public void click(By locator) {
        driver.findElement(locator).click();
    }


    @Test
    public void alreadyExistedUserNegativeTest() {
        // click on Login link
        clickOnLoginLink();

        //click on Registration button
        clickOnRegistrationButton();

        //fill important info
        fillRegisterForm("tyson777777@gmail.com", "Qwerty123!");

        //click on registration button
        clickOnRegistrationButton();

        //  verify that user already exist
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'User with email')]")).isDisplayed(),
                "No message");
    }


}
