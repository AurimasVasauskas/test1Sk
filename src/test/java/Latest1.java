import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.beans.Visibility;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class Latest1 {

    private static WebDriver narsykle;

    @BeforeTest
    public void setup(){
        narsykle = new ChromeDriver();
        narsykle.manage().window().maximize();
        narsykle.manage().deleteAllCookies();
        narsykle.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        narsykle.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @Test
    public void urlTest(){
        narsykle.get("http://www.dublintaxi.ie");
        String currentUrl= narsykle.getCurrentUrl();
        System.out.println("Current url is "+ currentUrl);
        Assert.assertEquals(currentUrl,"http://www.dublintaxi.ie/");
    }

    @Test
    public void searchTest(){
        WebDriverWait wait = new WebDriverWait(narsykle,10);
        narsykle.get("https://www.wikipedia.org");
        narsykle.findElement(By.id("searchInput")).sendKeys("Dalailama");
        narsykle.findElement(By.cssSelector(".pure-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstHeading")));
        String headeris=narsykle.findElement(By.id("firstHeading")).getText();
        Assert.assertEquals(headeris,"Dalailama");
        System.out.println("headeris yra "+ headeris);
        System.out.println("Dalailama valdo");
    }

    @Test(enabled = false)
    public  void KITMCorporationSearch(){
        narsykle.get("http://www.kitm.lt");

    }

    @AfterTest
    public void closeBrowser(){
        narsykle.quit();
    }

}
