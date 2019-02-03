import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class latestCorporationKITM {

    WebDriver narsykle; //

    @BeforeTest
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "/home/acura/chromedriver"); //maven nebutina
        narsykle=new ChromeDriver();
        narsykle.manage().window().maximize();
        narsykle.manage().deleteAllCookies();
        narsykle.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        narsykle.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void searchInKitm(){
        narsykle.get("http://kitm.lt");
        waitForElementByName(narsykle,5,"s");
        narsykle.findElement(By.id("s")).click();
        narsykle.findElement(By.id("s")).sendKeys("Zykas");
        narsykle.findElement(By.xpath("//*[@id='searchsubmit']")).click();
        waitForElementByCssSelector(narsykle,5,"h3.post-7732");
        WebElement laukas= narsykle.findElement(By.cssSelector("h3.post-7732"));
        String atsakymas =laukas.getText();
        System.out.println(atsakymas);
        if (atsakymas.contains("KITM")) {
            Assert.assertEquals(atsakymas,"KITM – ATEA ACTION KONFERENCIJOJE");
        }else{
            System.out.println("wtf man RTFM ");
        }
    }




    @AfterTest
    public void exitNarsykle(){
        narsykle.quit();
    }


    static private void waitForElementById (WebDriver narsykle, int timeOutInSec, String id){
        WebDriverWait waitas=new WebDriverWait(narsykle,timeOutInSec);
        waitas.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    static private void waitForElementByClassName (WebDriver narsykle, int timeOutInSec, String className){
        WebDriverWait waitas=new WebDriverWait(narsykle,timeOutInSec);
        waitas.until(ExpectedConditions.elementToBeClickable(By.className(className)));
    }

    static private void waitForElementByName (WebDriver narsykle, int timeOutInSec, String Name){
        WebDriverWait waitas=new WebDriverWait(narsykle,timeOutInSec);
        waitas.until(ExpectedConditions.elementToBeClickable(By.name(Name)));
    }

    static private void waitForElementByXpath (WebDriver narsykle, int timeOutInSec, String Xpath){
        WebDriverWait waitas=new WebDriverWait(narsykle,timeOutInSec);
        waitas.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
    }
    static private void waitForElementByCssSelector (WebDriver narsykle, int timeOutInSec, String CSSSelector){
        WebDriverWait waitas=new WebDriverWait(narsykle,timeOutInSec);
        waitas.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSSSelector)));
    }



}
