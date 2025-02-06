package com.casaflamingo.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;

    UserHelper user;
    HomePageHelper home;
    BaseHelper base;

    int i = (int)((System.currentTimeMillis()/1000%3600));

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://hostel-casa-flamingo-f95tn.ondigitalocean.app/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        home = new HomePageHelper(driver);
        base = new BaseHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public HomePageHelper getHome() {
        return home;
    }

    public BaseHelper getBase() {
        return base;
    }
}
