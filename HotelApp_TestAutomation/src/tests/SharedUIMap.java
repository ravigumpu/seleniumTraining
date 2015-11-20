
package tests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SharedUIMap {
  private WebDriver driver;
  private String baseUrl;
  public Properties prop;
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.adactin.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    prop = new Properties();
    prop.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
    
    
  }

  @Test
  public void testMyFirstWebDriver() throws Exception {
    driver.get(baseUrl + "/HotelApp/");
    driver.findElement(By.linkText(prop.getProperty("New_Users_Registration_txt"))).isDisplayed(); 
    driver.findElement(By.id(prop.getProperty("Username"))).clear();
    
//    driver.findElement(By.xpath(".//*[@id='username']")).clear();
    
    driver.findElement(By.id(prop.getProperty("Username"))).sendKeys("adactin123");
    
//    driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("adactin123");
    
    driver.findElement(By.id(prop.getProperty("Password"))).clear();
//    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id(prop.getProperty("Password"))).sendKeys("adactin123");
//    driver.findElement(By.id("password")).sendKeys("adactin123");
    driver.findElement(By.id("login")).click();
//  driver.findElement(By.id("login")).click();
    
  }


  @After
  public void tearDown() throws Exception {
    driver.quit();
    
    }
  }

  