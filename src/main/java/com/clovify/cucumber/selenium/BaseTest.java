package com.clovify.cucumber.selenium;

import org.openqa.selenium.WebDriver;

import static com.clovify.cucumber.selenium.Env.CreateWebDriver;

public class BaseTest {

    protected static WebDriver driver = CreateWebDriver(Env.getBrowserName());

}
