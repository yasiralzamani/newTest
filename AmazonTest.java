package first;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class AmazonTest {
    WebDriver driver;
    @BeforeMethod
    public void setUP() {
//this is for set up seting
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://amazon.com/#/");
    }

    @Test
    public void run() {
        // this is for run and element
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("qa testing for beginners");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]")).click();
        WebElement conf = driver.findElement(By.id("newBuyBoxPrice"));
        String ExpectedPrice = conf.getText();
        String ActualPrice = "$47.49";
        if (ActualPrice.contentEquals(ExpectedPrice))
            System.out.println("the price is macth");
        else
            System.out.println("not macth");
        driver.findElement(By.id("add-to-cart-button")).click();
        WebElement conf2 = driver.findElement(By.xpath("//span[@class=\"a-color-price hlb-price a-inline-block a-text-bold\"]"));
        String secondtPrice = conf2.getText();
        driver.findElement(By.id("hlb-ptc-btn-native")).click();
        System.out.println("the book in cart and it's proceed to checkout");
    }
@AfterMethod
    public void teardown() {
       driver.quit();
    }
}



