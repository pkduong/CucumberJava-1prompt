package com.saucedemo.pages;

import com.saucedemo.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private static final By USERNAME_FIELD = By.id("user-name");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By LOGIN_FORM = By.id("login_button_container");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        driver.get(TestConfig.get("base.url"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FORM));
    }

    public void loginWithConfiguredCredentials() {
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        username.clear();
        username.sendKeys(TestConfig.get("username"));

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        password.clear();
        password.sendKeys(TestConfig.get("password"));

        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
    }
}
