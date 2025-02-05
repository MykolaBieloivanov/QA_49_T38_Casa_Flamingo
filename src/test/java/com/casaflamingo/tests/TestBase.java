package com.casaflamingo.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    public static By clickOnLoginButton() {
        return By.xpath("//button[text()='Login']");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://hostel-casa-flamingo-f95tn.ondigitalocean.app/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
}

    public boolean isElementPresent(By locator){
                return driver.findElements(locator).size()>0;
    }

    public boolean isHomeComponentPresent(){
            return isElementPresent(By.cssSelector("SELECTOR"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isAlertDisplayed() {

        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }

    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[text()='Register']"));
    }

    public void fillRegisterForm(String email, String password) {
        //enter firstName
        type(By.name("firstName"), "Mike");

        //enter last Name
        type(By.name("lastName"), "Tyson");

        //enter phone
        type(By.name("phoneNumber"), "12345678910");

        //enter email
        type(By.name("userEmail"), email);

        //enter last Name
        type(By.name("password"), password);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='#/loginpage']"));
    }

    public WebElement logOutButtonExist() {
        return driver.findElement(By.xpath("//button[text()='Log out']"));
    }
}
