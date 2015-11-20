package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import functions.HotelApp_BusinessFunctions;


public class FunctionCallingTests extends HotelApp_BusinessFunctions {
	
	//private WebDriver driver;
	 // private String baseUrl;
	  //public Properties prop;
	  
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.adactin.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testMyFirstWebDriver() throws Exception {
	    driver.get(baseUrl + "/HotelApp/");   
	    
	    ha_bf_login("krishnav","1234");
	    
//	    driver.findElement(By.linkText("New User Register Here")).isDisplayed();
//	    driver.findElement(By.xpath(".//*[@id='username']")).clear();
//	    driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("adactin123");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("adactin123");
//	    driver.findElement(By.id("login")).click();
//	    
	  }


	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    
	    }
	

//	public void login(){
//		
//		ha_bf_login();
//	}
}
