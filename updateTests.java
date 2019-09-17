/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updateTestCases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author RLAMA
 */
public class updateTests {
    WebDriver driver;
    @Given("^Open chrome and start facebook application$")
    public void Open_chrome_and_start_facebook_application() throws Throwable {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rlama\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/"); 
    }

    @When("^I enter valid username and valid password to login$")
    public void I_enter_valid_username_and_valid_password_to_login() throws Throwable {
        driver.findElement(By.name("firstname")).sendKeys("Raj Kumar");
        driver.findElement(By.name("lastname")).sendKeys("Lama");
        driver.findElement(By.cssSelector("input#u_0_h")).sendKeys("lokumarlama89@gmail.com");
        driver.findElement(By.cssSelector("input#u_0_k")).sendKeys("lokumarlama89@gmail.com");
        driver.findElement(By.cssSelector("input#u_0_o")).sendKeys("Selenium123");
        driver.findElement(By.id("month")).sendKeys("Jan");
        driver.findElement(By.id("day")).sendKeys("01");
        driver.findElement(By.id("year")).sendKeys("2000");
        driver.findElement(By.cssSelector("input#u_0_a")).click();
        driver.findElement(By.cssSelector("button#u_0_u")).click();
        Thread.sleep(2000);

    }

    @Then("^User should be able to login and update status successfully$")
    public void User_should_be_able_to_login_and_update_status_successfully() throws Throwable {
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.name("q")).sendKeys("Mercury Marine");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.className("_32mo")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("_1vp5")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("_5yk2")).sendKeys("I am feeling exciting today.");
        driver.findElement(By.xpath("//div[@class='_45wg _69yt']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("u_0_c")).click();
        driver.findElement(By.id("findFriendsNav")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("q")).sendKeys("Dustin Balcerowisk");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER); 
        driver.findElement(By.id("userNavigationLabel")).click(); // logout button
 
        Thread.sleep(3000);
        driver.findElement(By.xpath
        ("//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']//a[@class='_54nc']//span//span[@class='_54nh']")).click();
        driver.close();
    }
    
}
