/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cucumberverifyproject;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


/**
 *
 * @author RLAMA
 */
public class TakeShots {
    
    public static void captureScreenShots(WebDriver driver,String screenShotName) throws IOException
    {
        try
        {
            TakesScreenshot screen =(TakesScreenshot)driver;
            File srcFile = screen.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile, new File("./ScreenShots/" + screenShotName +".png"));
            System.out.println("Screen shot is taken.");
        }
        catch(Exception e)
        {
            System.out.println("Error while taking screenshot.");
        }
        
    }
}