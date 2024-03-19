/**
 * This class serves as the base test class providing setup and teardown methods for test execution.
 * It extends the file_prop_utlities class to utilize properties file reading utilities.
 */
package base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.file_prop_utlities;

public class BaseTest extends file_prop_utlities {

	 public static WebDriver driver;
	 public static Properties locator;
	 public static Properties URL_DATA;
	 
	 
	 /**
	     * Sets up the WebDriver instance and initializes properties for locator and URL data.
	     * 
	     * @param browser The browser in which the test will be executed.
	     * @throws IOException If an I/O error occurs while reading properties files.
	     */
	@Parameters("browser")
	@BeforeMethod()
	public void setup(String browser) throws IOException 
	{
		 
		locator = getData(System.getProperty("user.dir") +"\\src\\test\\resources\\configrations\\locators.properties");
		URL_DATA = getData(System.getProperty("user.dir") +"\\src\\test\\resources\\testData\\testdata.properties");

//		String browser = getValue("browser_type", System.getProperty("user.dir") + "\\src\\test\\resources\\configrations\\config.properties");
		String url = getValue("url", System.getProperty("user.dir") + "\\src\\test\\resources\\configrations\\config.properties");
 
		switch (browser){
		
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(url);
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(url);
				break;
		
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.get(url);
				break;	
		};
	}
	
	
	  /**
     * Closes the WebDriver instance after each test method execution.
     */
	@AfterMethod
	public void Terminate() {
		
		driver.close();
	}
	
	
	
}
