package com.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;


public class Tooltip {
    WebDriver driver;
    public void tooltipText() throws InterruptedException {
     WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
     driver.get("http://www.leafground.com/pages/tooltip.html");
        driver.manage().window().maximize();
     WebElement element = driver.findElement(
                By.xpath("//input[@id='age']"));
     Actions action = new Actions(driver);
     action.moveToElement(element).perform();
     String toolTip = element.getAttribute("title");
        System.out.println("ToolTip text is " +toolTip);

        driver.close();
    }


    public static void main(String[] args) throws InterruptedException {
        Tooltip tp = new Tooltip();
        tp.tooltipText();
    }


    }
