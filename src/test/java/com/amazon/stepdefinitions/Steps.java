package com.amazon.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Steps {

    private WebDriver driver;
    private Actions action;

    @Before()
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/home/nana/Descargas/chromedriver");
        driver= new ChromeDriver();
        action = new Actions(driver);
    }
    @Given("juan navigates to www.amazon.com")
    public void juan_navigates_to_www_amazon_com() throws InterruptedException {
        driver.get("https://www.amazon.com/?language=es_US");
        Thread.sleep(3000);
    }
    @Given("Searches for Alexa")
    public void searches_for_alexa() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Alexa");
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).submit();
        Thread.sleep(3000);
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

    @After()
    public void finish(){
        driver.quit();
    }
}
