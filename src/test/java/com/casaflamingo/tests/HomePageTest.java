package com.casaflamingo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void isHomeComponentPresentTest() {

//        driver.findElement(By.cssSelector("h2"));
        Assert.assertTrue(isHomeComponentPresent());
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("h2")).size() > 0;
    }

    public boolean isElementPresent(By locator) {

        return driver.findElements(locator).size() > 0;
    }


}



