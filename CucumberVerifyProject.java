/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cucumberverifyproject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 *
 * @author RLAMA
 */
public class CucumberVerifyProject {

    /**
     * @param args the command line arguments
     */
    WebDriver driver;
    JavascriptExecutor jse;
    Screen myscreen;
    public static void main(String[] args) throws InterruptedException 
    {
        // TODO code application logic here
        try
        {
            CucumberVerifyProject locate = new CucumberVerifyProject();
            locate.loginNormally();
            locate.loginUsingExcelSheet();    
        }
        catch(Exception e)
        {
            System.out.println("Error trying to login in both of the ways.");
                    
        }
    }
    public void loginNormally()
    {
        try
        {
            invokeBrowser();
            loginCommand();
            loginInfo();
            Thread.sleep(3000);
            updateInfo();
            sikuliImageClass();
            logout(); 
        }
        catch(Exception e)
        {
            System.out.println("Error login.")  ;
        }
        
    }
    public void loginUsingExcelSheet()
    {
        try
        {
            FacebookLoginWithExcel read = new FacebookLoginWithExcel(
                    "C:\\Users\\rlama\\Documents\\ExcelData\\TestData.xlsx");
            read.displayNumRows(0);
            read.getData(0, 0, 0);
            passData("rlama","Selenium");
            Thread.sleep(5000);
            logout();
        }
        catch(Exception e)
        {
            System.out.println("Error login");
        }   
    }
    
    public void invokeBrowser()
    {
        try
        {
//            String PROXY = "10.8.186.78:8080"; // setting up the IP Address and the port
//            org.openqa.selenium.Proxy prox = new org.openqa.selenium.Proxy();
//            prox.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY);
//            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setCapability(CapabilityType.PROXY, prox);   
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rlama\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        jse = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/"); 
        }
        catch ( Exception e)
        {
            System.out.println("Error while trying to open the browser.");
        }
    }
    public void loginCommand() throws InterruptedException
    {
        try
        {
            driver.findElement(By.name("firstname")).sendKeys("Raj Kumar");
            Thread.sleep(1000);
            driver.findElement(By.name("lastname")).sendKeys("Lama");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input#u_0_h")).sendKeys("lokumarlama89@gmail.com");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input#u_0_k")).sendKeys("lokumarlama89@gmail.com");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input#u_0_o")).sendKeys("Selenium123");
            driver.findElement(By.cssSelector("input#u_0_a")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("month")).sendKeys("Jan");
            Thread.sleep(1000);
            driver.findElement(By.id("day")).sendKeys("01");
            Thread.sleep(1000);
            driver.findElement(By.id("year")).sendKeys("2000");
            TakeShots.captureScreenShots(driver, "FacebookLoginPage");
            driver.findElement(By.cssSelector("button#u_0_u")).click();
        }
        catch(Exception e)
        {
            System.out.println("Error in loginCommand.");
        }
        
    }
    
    
    public String[][] passData(String username, String password)
    {
        invokeBrowser();
        FacebookLoginWithExcel exelFile = new FacebookLoginWithExcel(
                "C:\\Users\\rlama\\Documents\\Raj's Folder\\FacebookLogin2Version\\ExcelDataSheet\\LoginData.xlsx");
        int numRows = exelFile.displayNumRows(0);
        String [][]data = new String[numRows][2];
        for(int i = 0; i< numRows; i++)
        {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(By.id("email")).sendKeys(username = data[i][0] = exelFile.getData(0, i, 0));
            driver.findElement(By.id("pass")).sendKeys(password = data[i][1] = exelFile.getData(0, i, 1));
            driver.findElement(By.id("loginbutton")).click(); 
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   
        }
        return data;   
    }
    
    public void loginInfo()
    {
        String title, urlInfo;
        title = driver.getTitle();
        urlInfo = driver.getCurrentUrl();
        System.out.println("The title of the page is: " + title);
        System.out.println("The URL of the website: " + urlInfo);
    }
    
    public void updateInfo() throws InterruptedException
    {
        try
        {
            driver.navigate().refresh();
            Thread.sleep(2000);
            driver.findElement(By.name("q")).sendKeys("Mercury Marine");
            Thread.sleep(2000);
            driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            TakeShots.captureScreenShots(driver, "MercuryMarine");
            driver.findElement(By.className("_32mo")).click();
            Thread.sleep(3000);
            jse.executeScript("window.scrollBy(0,2000)");
            TakeShots.captureScreenShots(driver, "Homepage");
            Thread.sleep(2000);
            driver.findElement(By.className("_1vp5")).click();
            Thread.sleep(4000);
            driver.findElement(By.className("_5yk2")).sendKeys("Hello world.");
            driver.findElement(By.xpath("//div[@class='_45wg _69yt']")).click();
            Thread.sleep(2000);
            driver.findElement(By.className("_5yk2")).sendKeys("Welcome to automation Testing.");
            driver.findElement(By.xpath("//div[@class='_45wg _69yt']")).click();
            Thread.sleep(2000);
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            TakeShots.captureScreenShots(driver, "updatedStatus");
    //        Thread.sleep(5000);
    //        WebElement element = driver.findElement(By.id("u_0_a"));
    //        jse.executeScript("argument[0].scrollIntoView(true);",element);
            Thread.sleep(2000);
            driver.findElement(By.id("u_0_c")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("findFriendsNav")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("q")).sendKeys("Dustin Balcerowisk");
            driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
            TakeShots.captureScreenShots(driver, "friendPage");
            Thread.sleep(2000);
            driver.findElement(By.className("_1vp5")).click();
            
        }
        catch(Exception e)
        {
            System.out.println("Error in updateInfo");
        }
        
    }
    
    public void logout() throws InterruptedException
    {
        try
        {
            driver.findElement(By.id("userNavigationLabel")).click(); // logout button
            TakeShots.captureScreenShots(driver, "logoutPage");
            Thread.sleep(3000);
            driver.findElement(By.xpath
            ("//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']//a[@class='_54nc']//span//span[@class='_54nh']")).click();
            driver.close();
            
        }
        catch(Exception e)
        {
            System.out.println("Error while logging out.");
        }
        
    }
     public void sikuliImageClass()
     {
         try
         {
             ImagePath.setBundlePath("C:\\Users\\rlama\\Documents\\Raj's Folder\\SikuliImages");
             myscreen = new Screen();
             Pattern timeline = new Pattern("timeline.PNG");
             Pattern view = new Pattern("timelineView.PNG");
             myscreen.wait(timeline,5);
             myscreen.click(timeline);
             myscreen.wait(3.0);
             driver.navigate().back();
             myscreen.wait(2.0);
             myscreen.hover(view);
             myscreen.wait(1.0);
             myscreen.type(Key.DOWN);
             myscreen.wait(1.0);
             myscreen.type(Key.DOWN);
             myscreen.wait(1.0);
             myscreen.type(Key.ENTER);
             driver.navigate().refresh();
             myscreen.wait(4.0);     
         }
         catch(FindFailed e)
         {
             System.out.println("Did not find the image.");          
         }       
     }
    
}
