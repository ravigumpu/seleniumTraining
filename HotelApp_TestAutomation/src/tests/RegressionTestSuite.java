package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegressionTestSuite {
	
	  public WebDriver driver;
	  public String baseUrl;
	  public String expectedText = "Enter Password"; 
	  public String actualText;
	
	  @Before
	  public void setUp() throws Exception {
	      driver = new FirefoxDriver();
	      baseUrl = "http://www.adactin.com/";
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      
	    }
@Test
public void regressionTestSuite() throws Exception {
	//Instantiating Object for each of the tests
	
	MyFirstWebDriverTest wdt1 = new MyFirstWebDriverTest();
	VerificationPointTest vpt2 = new VerificationPointTest();
	
	//Defining Which test to run
	
	Boolean bMyFirstWebDriverTest = true;
	Boolean bVerificationPointTest = true;
	
	//Call and run tests
	
	if (bMyFirstWebDriverTest)
		wdt1.testMyFirstWebDriver();
	
	if (bVerificationPointTest)
		vpt2.testMyFirstWebDriver();
}
/*@After
public void tearDown() throws Exception {
  driver.quit();
  
  }*/

}
