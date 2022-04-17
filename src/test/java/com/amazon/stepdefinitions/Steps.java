package com.amazon.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    private WebDriver driver;
    @Given("juan navigates to www.amazon.com")
    public void juan_navigates_to_www_amazon_com() {
        System.setProperty("webdriver.chrome.driver","/home/nana/Descargas/chromedriver");
        driver= new ChromeDriver();
        driver.get("https://www.amazon.com/");
        System.out.println("open chrome");
    }
    @Given("Searches for Alexa")
    public void searches_for_alexa() {
        System.out.println("search for alexa");
    }
    @Given("navigates to the second page")
    public void navigates_to_the_second_page() {
        System.out.println("navigates");
    }
    @Given("selects the third item")
    public void selects_the_third_item() {
        System.out.println("selects");
    }
    @Then("assert that the item would be available for purchase")
    public void assert_that_the_item_would_be_available_for_purchase() {
        System.out.println("assert");
    }
}
