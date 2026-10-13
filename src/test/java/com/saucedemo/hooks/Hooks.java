package com.saucedemo.hooks;

import com.saucedemo.support.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void startBrowser() {
        DriverManager.startDriver();
    }

    @After
    public void stopBrowser() {
        DriverManager.stopDriver();
    }
}
