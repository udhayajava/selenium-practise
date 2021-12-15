package webtable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.jetty.stop.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment1 {
    public WebDriver driver;
    public WebElement table;
    /*Assignment 1: Verify that there are only 4 structure values present.
                    1.Read the 'Structure' column and find out the total number of structures present.
                    2.Read the value of 'Total' column and match with the previous step.*/
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


    public void assignment1() {
        //1.structure column.........
        List<WebElement> structure =table.findElements(By.cssSelector("tbody tr th"));
        int totalNum=0;
        for (WebElement totalNumberOfStructure:structure) {
            String ListOfStructure =totalNumberOfStructure.getText();
            System.out.println("list the Structure in table:"+ListOfStructure);
            totalNum++;

        }
        System.out.println("Hence total number of structures in the column-->" +totalNum);
        //2.total
        WebElement total =  driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tfoot/tr/td"));
        String totalValueStr = total.getText();
        System.out.println(totalValueStr);
        Pattern regex = Pattern.compile("[0-9]");
        Matcher matcher = regex.matcher(totalValueStr);
        while (matcher.find()){
            String totalValueRegex = matcher.group();
            Integer totalValue =Integer.parseInt(totalValueRegex);
            System.out.println("converted to integer-->" +totalValue);
            if(totalNum==totalValue){
                System.out.println("Same And testPass");
            }else {
                System.out.println("NotSame And testFail");
            }
        }driver.quit();}
    public static void main(String[] args) {
        Assignment1 assignment1 = new Assignment1();{
            assignment1.browserOperation();
            assignment1.webTableHandle1();
            assignment1.assignment1();}
    }
}
