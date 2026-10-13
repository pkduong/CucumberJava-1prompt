package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private static final By PAGE_TITLE = By.cssSelector(".title");
    private static final By INVENTORY_CONTAINER = By.id("inventory_container");

    private final WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(INVENTORY_CONTAINER)).isDisplayed()
                && "Products".equals(wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE)).getText());
    }
}
