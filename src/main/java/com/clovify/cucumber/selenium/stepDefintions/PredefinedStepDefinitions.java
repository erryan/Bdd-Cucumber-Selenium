package com.clovify.cucumber.selenium.stepDefintions;


import com.clovify.cucumber.selenium.BaseTest;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
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

    /**
     * Checks, that page contains specified text
     *
     * Example :  Given should see text "Google"
     * Example :  When I should see text "Google"
     *
     * @param text
     */
    @Then("(?:|I )should see text \\\"([^\\\"]*)\\\"$")
    public static void assertPageContainsText(String text){

        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains(text));
    }

    /**
     * Checks, that page doesn't contain specified text
     *
     * Example :  Given should not see text "Google"
     * Example :  When I should not see text "Google"
     *
     * @param text
     */
    @Then("(?:|I )should not see text \\\"([^\\\"]*)\\\"$")
    public static void assertNotPageContainsText(String text){

        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertFalse(bodyText.contains(text));
    }

    /**
     * Checks, that element with specified CSS contains specified text
     *
     * Example :  Given should see text "text" in the "css_selector" elements
     * Example :  When I should see text "text" in the "css_selector" elements
     *
     * @param elementText
     * @param selectors
     */
    @Then("(?:|I )should see text \\\"([^\\\"]*)\\\" in the \\\"([^\\\"]*)\\\" elements$")
    public static void elementTextCointains(String elementText, String selectors){

        String getElementText = driver.findElement(By.cssSelector(selectors)).getText();

        Assert.assertTrue(getElementText.contains(elementText));
    }

    /**
     * Checks, that element with specified CSS doesn't contain specified text
     *
     * Example :  Given should not see text "text" in the "css_selector" elements
     * Example :  When I should not see text "text" in the "css_selector" elements
     *
     * @param elementText
     * @param selectors
     */
    @Then("(?:|I )should not see text \\\"([^\\\"]*)\\\" in the \\\"([^\\\"]*)\\\" elements$")
    public static void elementTextNotCointains(String elementText, String selectors){

        String getElementText = driver.findElement(By.cssSelector(selectors)).getText();

        Assert.assertFalse(getElementText.contains(elementText));
    }

    // Action Steps

    /**
     * Click on an element based on given css selector.
     *
     * Example :  Given I click on "button.showModal"
     * Example :  When I click on "button.showModal"
     *
     * @param selector
     */
    @Then("^I click on \"([^\"]*)\"$")
    public static void click(String selector){

        driver.findElement(By.cssSelector(selector)).click();
    }

    /**
     * Click button on an element based on given css selector.
     *
     * Example :  Given I click button on "button.showModal"
     * Example :  When I click button on "button.showModal"
     *
     * @param selector
     */
    @Then("^I click button on \"([^\"]*)\"$")
    public static void clickButton(String selector){

        Assert.assertEquals("button",driver.findElement(By.cssSelector(selector)).getTagName());
        driver.findElement(By.cssSelector(selector)).submit();
    }

    /**
     * Press a button element with string argument interpreted as (in order):
     *
     * Example :  Given I follow "https://github.com/about"
     * Example :  When I follow "https://github.com/about"
     *
     * @param href
     */
    @Then("^I follow \"([^\"]*)\"$")
    public static void followHref(String href){

        driver.findElement(By.cssSelector("a[href=\'"+href+"\']")).click();
    }

    /**
     * Submits a form found by given selector. The submit command may also be applied to any element that is a descendant of a <form> element.
     *
     * Example :  Given I submit "button.showModal"
     * Example :  When I submit "button.showModal"
     *
     * @param selector
     */
    @Then("^I submit \"([^\"]*)\" form$")
    public static void submitForm(String selector){

        driver.findElement(By.cssSelector(selector)).submit();
    }

}
