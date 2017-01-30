package com.clovify.cucumber.selenium;


import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Env {

    static WebDriver driver = null;
    static String browserName = null;

    public static String getBrowserName(){

        browserName = System.getProperty("browser");

        if(browserName == null)
            browserName = "chrome";
        return browserName;
    }


    public static WebDriver CreateWebDriver(String browser){

        switch (browser.toLowerCase()) {
            case "ch":
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "ff":
            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "ie" :
            case "internetexplorer":
                driver = new InternetExplorerDriver();
                break;

            case "sf" :
            case "safari":
                driver = new SafariDriver();
                break;

            case "uh" :
            case "unithtml":
                driver = new HtmlUnitDriver();
                break;

            case "pjs" :
            case "phantomjs":
                driver = new PhantomJSDriver();
                break;

            default:
                System.out.println("Invalid browser name "+browser);
                System.exit(0);
                break;
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        return driver;
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
