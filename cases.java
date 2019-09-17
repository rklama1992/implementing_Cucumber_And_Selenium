/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author RLAMA
 */
public class cases {
        WebDriver driver;
    @Given("^Open chrome and start application$")
    public void Open_chrome_and_start_application() throws Throwable 
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rlama\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/"); 
    
    }
    @When("^I enter valid username and valid password$")
    public void I_enter_valid_username_and_valid_password() throws Throwable 
    {
        driver.findElement(By.name("firstname")).sendKeys("Raj Kumar");
        driver.findElement(By.name("lastname")).sendKeys("Lama");
        driver.findElement(By.cssSelector("input#u_0_h")).sendKeys("lokumarlama89@gmail.com");
        driver.findElement(By.cssSelector("input#u_0_k")).sendKeys("lokumarlama89@gmail.com");
        driver.findElement(By.cssSelector("input#u_0_o")).sendKeys("Selenium123");
        driver.findElement(By.cssSelector("input#u_0_a")).click();
        driver.findElement(By.id("month")).sendKeys("Jan");
        driver.findElement(By.id("day")).sendKeys("01");
        driver.findElement(By.id("year")).sendKeys("2000");

    }
    @Then("^User should be able to login successfully$")
    public void User_should_be_able_to_login_successfully() throws Throwable 
    {
        driver.findElement(By.cssSelector("button#u_0_u")).click();

    }
    
}
