package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.support.ui.Select;

import functions.HotelApp_BusinessFunctions;


public class ParametrisationTest extends HotelApp_BusinessFunctions {
	
	  
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.adactin.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testMyFirstWebDriver() throws Exception {
	    driver.get(baseUrl + "/HotelApp/");   
	    
	    ha_bf_login("krishnav","123456");
	  
	    String strFile="./DataPool/HA_hotelSearch.xls";
	    String strLocatin = HA_GF_readXL(1,"Location",strFile);
	    
	    new Select(driver.findElement(By.id("location"))).selectByVisibleText(strLocatin);
	    driver.findElement(By.id("Submit")).click();
	 
	  }


	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    
	    }
	
}
