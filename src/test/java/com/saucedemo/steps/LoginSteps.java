package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.support.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    @Given("the user opens the SauceDemo login page")
    public void userOpensLoginPage() {
        new LoginPage(DriverManager.getDriver()).open();
    }

    @When("the user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        new LoginPage(DriverManager.getDriver()).loginWithConfiguredCredentials();
    }

    @Then("the products page is displayed")
    public void productsPageIsDisplayed() {
        assertTrue(new ProductsPage(DriverManager.getDriver()).isDisplayed(),
                "Expected the SauceDemo products page after successful login.");
    }
}
