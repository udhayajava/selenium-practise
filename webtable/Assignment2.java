package webtable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.jetty.stop.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.crypto.Mac;
import java.time.Duration;
import java.util.List;

public class Assignment2 {
    /* Assignment 2: Read All the Values from the table row-wise and print them all
    Solution Hint:
    Use for loop to read all the values of the table.*/

    WebDriver driver;
    WebElement table;
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

    public void assignment2(){
        List<WebElement> rowWise = driver.findElements(By.xpath("//table[@summary='Sample Table']/tbody/tr"));
        for (WebElement rowList:rowWise
             ) {
            String rowListText = rowList.getText();
            System.out.println("*" +rowListText);
        }
        driver.quit();
    }

    public static void main(String[] args) {
        Assignment2 assignment2 = new Assignment2();
        assignment2.browserOperation();
        assignment2.webTableHandle1();
        assignment2.assignment2();
    }
}
