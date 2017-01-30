package com.clovify.cucumber.selenium.stepDefintions;


import com.clovify.cucumber.selenium.BaseTest;
import cucumber.api.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;


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


}
