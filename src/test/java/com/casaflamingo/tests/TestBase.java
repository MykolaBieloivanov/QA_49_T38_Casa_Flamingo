package com.casaflamingo.tests;

import com.casaflamingo.fw.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    WebDriver driver;

    protected ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();

    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        app.stop();
    }

}
