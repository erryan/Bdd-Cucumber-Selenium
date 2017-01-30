package com.clovify.cucumber.selenium;

import org.openqa.selenium.WebDriver;

public class BaseTest {

    public static WebDriver driver = Env.CreateWebDriver(Env.getBrowserName());

}
