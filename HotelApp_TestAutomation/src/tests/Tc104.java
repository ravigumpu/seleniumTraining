package tests;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class Tc104 {

	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  public String SelectText="Sydney";
	  private String expectedtext;

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.adactin.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testTC104() throws Exception {
	    driver.get(baseUrl + "/HotelApp/index.php");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("adactin123");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("adactin123");
	    driver.findElement(By.id("login")).click();
	    
	    //Logic to check whether the selected option from Dropdown is Sydney or not
	    
	    WebElement select = driver.findElement(By.id("location"));
	    List<WebElement> options = select.findElements(By.id("location"));
	    for (WebElement option : options) {
	        if(SelectText.equals(option.getText()))
	            option.click();
	        assertEquals(SelectText,expectedtext);
	    }
	    
	    
	    new Select(driver.findElement(By.id("hotels"))).selectByVisibleText("Hotel Creek");
	    new Select(driver.findElement(By.id("room_type"))).selectByVisibleText("Standard");
	    driver.findElement(By.id("datepick_in")).clear();
	    driver.findElement(By.id("datepick_in")).sendKeys("02/11/2015");
	    driver.findElement(By.id("datepick_out")).clear();
	    driver.findElement(By.id("datepick_out")).sendKeys("03/11/2015");
	    driver.findElement(By.id("Submit")).click();
	    
}	  
	  @After
	  public void quit(){
		  driver.quit();
		  
	  }
}