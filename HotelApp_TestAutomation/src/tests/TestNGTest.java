
package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestNGTest {
  private WebDriver driver;
  private String baseUrl;
  public Properties prop;
  
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
    driver.findElement(By.id("password")).sendKeys("adactin123");
    driver.findElement(By.id("login")).click();
    
  }


  @AfterMethod
public void tearDown() throws Exception {
    driver.quit();
    
    }
  }

  