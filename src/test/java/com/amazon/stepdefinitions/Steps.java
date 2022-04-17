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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Steps {

    private WebDriver driver;
    private Actions action;

    private WebDriverWait waitElement;

    @Before()
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/home/nana/Descargas/chromedriver");
        driver= new ChromeDriver();
        action = new Actions(driver);
        waitElement = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Given("juan navigates to www.amazon.com")
    public void juan_navigates_to_www_amazon_com() throws InterruptedException {
        driver.get("https://www.amazon.com/?language=es_US");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }
    @Given("Searches for Alexa")
    public void searches_for_alexa() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Alexa");
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).submit();
       
    }
    @Given("navigates to the second page")
    public void navigates_to_the_second_page() throws InterruptedException {
        waitElement.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[28]/div/div/span/a[1]")));

        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[28]/div/div/span/a[1]")).click();

    }
    @Given("selects the third item")
    public void selects_the_third_item() throws InterruptedException {

        waitElement.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a")));
        WebElement mobileElement = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a"));

        action.moveToElement(mobileElement).build().perform();

        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a")).click();

    }
    @Then("assert that the item would be available for purchase")
    public void assert_that_the_item_would_be_available_for_purchase() {
        waitElement.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[@id=\"availability\"]/span")));
       String result=driver.findElement(By.xpath("//*[@id=\"availability\"]/span")).getText().trim();
        assertEquals("Disponible.",result);
    }

//    @After()
//    public void finish(){
//        driver.quit();
//    }
}
