
package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerificationPointTest1 {
  private WebDriver driver;
  private String baseUrl;
  private String expectedText = "Enter Username"; 
  private String actualText;

  
  @Before
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
    driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("");
    driver.findElement(By.id("login")).click();
//   actualText = driver.findElement(By.id("username_span")).getText();
    actualText = driver.findElement(By.cssSelector(".login_error")).getText();
   assertEquals(expectedText,actualText);
    
    
  }


  @After
  public void tearDown() throws Exception {
    driver.quit();
    
    }
  }

  