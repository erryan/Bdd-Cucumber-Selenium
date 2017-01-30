package com.clovify.cucumber.selenium.stepDefintions;


import com.clovify.cucumber.selenium.BaseTest;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.net.MalformedURLException;
import java.net.URL;


public class PredefinedStepDefinitions extends BaseTest {


    // Navigations Steps

    /**
     * Opens specified page
     *
     * Example :  Given I am on "https://github.com/"
     * Example :  When I am on "https://github.com/"
     *
     * @param pageUrl
     */
    @Then("I am on \\\"([^\\\"]*)\\\"$")
    public static void openSpecifiedPage(String pageUrl){

        driver.get(pageUrl);
    }

    /**
     * Reflehs current page
     *
     * Example :  Given reflesh the page
     * Example :  When I reflesh the page
     *
     */
    @Then("(?:|I )reflesh the page")
    public static void refleshCurrentPage(){

        driver.navigate().refresh();
    }

    /**
     * Reloads current page with executing JavaScript
     *
     * Example :  Given reload the page
     * Example :  When I reload the page
     */
    @Then("(?:|I )reload the page")
    public static void reloadCurrentPage(){

        ((JavascriptExecutor) driver).executeScript("location.reload();");
    }

    /**
     * Takes youback by one page on the browser’s history.
     *
     * Example :  Given I move backward one page
     * Example :  When move backward one page
     *
     */
    @Then("(?:|I )move backward one page")
    public static void backwardOnePage(){

        driver.navigate().back();
    }

    /**
     * Takes you forward by one page on the browser’s history.
     *
     * Example :  Given I move forward one page
     * Example :  When move forward one page
     *
     */
    @Then("(?:|I )move forward one page")
    public static void forwardOnePage(){

        driver.navigate().forward();
    }


    // Assertion Steps

    /**
     * Current url checking
     *
     * Example :  Given should see current url as "https://github.com/"
     * Example :  When I should see current url as "https://github.com/"
     *
     * @param currentUrl
     */
    @Then("(?:|I )should see current url as \\\"([^\\\"]*)\\\"$")
    public static void assertCurrentUrl(String currentUrl){

        Assert.assertEquals(driver.getCurrentUrl(),currentUrl);
    }

    /**
     * Current url path checking
     *
     * Example :  Given should see current url path as "/"
     * Example :  When I should see current url path as "/"
     *
     * @param currentUrlPath
     * @throws MalformedURLException
     */
    @Then("(?:|I )should see current url path as \\\"([^\\\"]*)\\\"$")
    public static void assertCurrentUrlPath(String currentUrlPath) throws MalformedURLException {

        URL url = new URL(driver.getCurrentUrl());

        Assert.assertEquals(url.getPath(),currentUrlPath);
    }

    /**
     * Page title checking
     *
     * Example :  Given should see page title as "Google"
     * Example :  When I should see page title as "Google"
     *
     * @param pageTitle
     */
    @Then("(?:|I )should see page title as \\\"([^\\\"]*)\\\"$")
    public static void assertPageTitle(String pageTitle){

        Assert.assertEquals(driver.getTitle(),pageTitle);
    }


}
