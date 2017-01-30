package com.clovify.cucumber.selenium;

import org.openqa.selenium.WebDriver;

/**
 *
 * Created by tazedirekt on 30/01/17.
 */

public class BaseTest {

    public static WebDriver driver = Env.CreateWebDriver(Env.getBrowserName());

}
