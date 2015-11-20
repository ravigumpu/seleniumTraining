
package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerificationPointTestNGTest {
  private WebDriver driver;
  private String baseUrl;
  private String expectedText = "Enter Password"; 
  private String actualText;

  
  @BeforeMethod
public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.adactin.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
  }

  @Test
  public void testMyFirstWebDriver() throws Exception {
    driver.get(baseUrl + "/HotelApp/");
    driver.findElement(By.linkText("New User Register Here")).isDisplayed();
    driver.findElement(By.xpath(".//*[@id='username']")).clear();
    driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("adactin123");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("");
    driver.findElement(By.id("login")).click();
   actualText = driver.findElement(By.id("password_span")).getText();
   AssertJUnit.assertEquals(expectedText,actualText);
    
    
  }


  @AfterMethod
public void tearDown() throws Exception {
    driver.quit();
    
    }
  }

  