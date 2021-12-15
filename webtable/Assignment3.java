package webtable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class Assignment3 {
     /*Assignment 3: Verify that Burj Khalifa has a height of 829m (similar for other structures)*/
     WebDriver driver;
    WebElement table;
    Scanner scan;
    public void browserOperation() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
    }
    public void webTableHandle1() {
        table = driver.findElement(By.xpath("//table[@summary='Sample Table']"));

    }
    public void assignment3(){
        for (int i = 1; i <3 ; i++) {


        List<WebElement> structure =table.findElements(By.xpath("//table[@summary='Sample Table']/tbody/tr["+ i +"]/th"));
            System.out.println(structure);
        }
    }


    public static void main(String[] args) {
        Assignment3 assignment3 = new Assignment3();
        assignment3.browserOperation();
        assignment3.webTableHandle1();
        assignment3.assignment3();

    }
}
