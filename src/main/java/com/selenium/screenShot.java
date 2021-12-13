package com.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class screenShot {
    WebDriver driver;
    String filename;
    String path = "";
    TakesScreenshot takesScreenshot;
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.leafground.com/");
       }
    public void screenShotVisibleScreen() throws IOException, InterruptedException {
         Thread.sleep(5000);
        //Takescreenshot is a interface,driver is webdriver instance//
        takesScreenshot = (TakesScreenshot)driver;
        File sourceFile =  takesScreenshot.getScreenshotAs(OutputType.FILE);
        driver.quit();

        { this.filename = new String();
        Scanner scan = new Scanner(System.in);
        System.out.println("Name Your File Name end with .png");
        this.filename = scan.nextLine();
        String directory = System.getProperty("user.dir");
        path = directory + File.separator + filename;
        System.out.println("Filepath is " + path);}
        File destinationFile = new File(filename);
        FileHandler.copy(sourceFile,destinationFile);

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        screenShot snap =new screenShot();
        snap.openBrowser();
        snap.screenShotVisibleScreen();
    }
}
