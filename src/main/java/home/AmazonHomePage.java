package home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonHomePage {
    public WebDriver driver = null;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\IdeaProjects\\MavinProject-1\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanUp(){
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop", Keys.ENTER);
        Thread.sleep(2000);
    }

        @Test
        public void test2(){
            String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
            String actualTitle = driver.getTitle();
            System.out.println(actualTitle);
            Assert.assertEquals(actualTitle, expectedTitle);

    }

}



