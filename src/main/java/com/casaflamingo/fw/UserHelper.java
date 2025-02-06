package com.casaflamingo.fw;

import com.casaflamingo.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper  extends BaseHelper{

    int i = (int)((System.currentTimeMillis()/1000%3600));

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public static By clickOnLoginButton() {
        return By.xpath("//button[text()='Login']");
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
        fillRegisterLoginForm(new User().setEmail("tyson" + i + "@gmail.com").setPassword("Qwerty123!"));
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='#/loginpage']"));
    }

    public WebElement logOutButtonExist() {
        return driver.findElement(By.xpath("//button[text()='Log out']"));
    }

    public void fillRegisterLoginForm(User user) {
        //enter email
        type(By.name("userEmail"), user.getEmail());
        //enter password
        type(By.name("password"), user.getPassword());
    }
}
