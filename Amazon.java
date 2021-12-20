package Amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Amazon {
    WebDriver driver;
    public void openAmazon(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }
    public void searchMobile(){
       WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
       searchBox.sendKeys("iPhone 12 Mini (256GB)");
       searchBox.sendKeys(Keys.ENTER);
       WebElement mobile = driver.findElement
               (By.xpath("//span[contains(text(),'New Apple iPhone 12 Mini (256GB)')]"));
       mobile.click();
    }
    public void addToCart(){
        Set<String>windowHandle = driver.getWindowHandles();
        System.out.println(windowHandle);
        List<String> listOfWindows= new ArrayList(windowHandle);
        driver.switchTo().window(listOfWindows.get(1));
        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addToCart.click();
    }
    public void checkOut(){
        driver.findElement(By.xpath("//form[@id='attach-view-cart-button-form']")).click();


    }
    public static void main(String[] args) {
        Amazon amazon = new Amazon();
        amazon.openAmazon();
        amazon.searchMobile();
        amazon.addToCart();
        amazon.checkOut();


    }
}
