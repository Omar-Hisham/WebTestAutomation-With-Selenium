//package testCases;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import java.util.concurrent.TimeUnit;
//
//public class test {
//
//	public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
////		WebDriverManager.chromedriver().setup();
////		WebDriver driver = new ChromeDriver();
////		
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
//
//		driver.get("https://www.bing.com/");
//		driver.findElement(By.id("sb_form_q")).sendKeys("Vodafone");
//		driver.findElement(By.id("search_icon")).click();
//	
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		Thread.sleep(3000);
//		while(!driver.findElement(By.xpath("//a[@aria-label='Page 2']")).isEnabled())
//		{
//			System.out.println("entered");
//			 Thread.sleep(30);
//		}
//			
//		driver.findElement(By.xpath("//a[@aria-label='Page 2']")).click();	
//			
////		//while(c<3) {
////		try {
////		driver.findElement(By.xpath("//a[@aria-label='Page 2']")).click();
////		}
////		catch(Exception e) {
////		System.out.println("second click"+c);
////		driver.findElement(By.xpath("//a[@aria-label='Page 2']")).click();
////			 Thread.sleep(1000);
////			 c++;
////		}
//		
//
//		WebElement E = driver.findElement(By.id("b_results"));
//	    List<WebElement> l = E.findElements(By.xpath("//li[@class='b_algo b_ccontain']"));
//		
//		System.out.print("The size is: "+l.size()+"\n");
//		
//		
//		//li[@class='b_algo b_ccontain qbrs']
//		
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		driver.findElement(By.xpath("//a[@aria-label='Page 3']")).click();
//		
//		 E = driver.findElement(By.id("b_results"));
//		 List<WebElement> l2 = E.findElements(By.xpath("//li[@class='b_algo b_ccontain']"));
//			
//		 System.out.print("The size is of 2: "+l2.size()+"\n");
//			
//		 
//		//li[@class='b_algo b_ccontain qbrs']//div[@class='tpcn']
//	driver.close();
//	}
//	
//
//}

//
package testCases;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class test extends BaseTest {

	@Test(dataProvider = "data-provider" )	
	public void testcaseone(String keyword) throws InterruptedException
	{
        	Assert.assertEquals(driver.getCurrentUrl(),URL_DATA.getProperty("HOME_PAGE_LINK"));     
            
        	driver.findElement(By.id(locator.getProperty("SEARCH_INPUT_FIELD"))).sendKeys(keyword);
            driver.findElement(By.id(locator.getProperty("SEARCH_ICON_BUTTON"))).click();
           

            Assert.assertEquals(driver.getTitle(),URL_DATA.getProperty("PAGE_TITLE"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            
            
            // Wait for the second page btn to be clickable
            WebElement Page_2_Btn = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getProperty("PAGE_2_BTN"))));
            
           
            js.executeScript("arguments[0].click();", Page_2_Btn);            

            Assert.assertEquals(driver.getTitle(),URL_DATA.getProperty("PAGE_TITLE"));

            
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
           
            
            List<WebElement> searchResultsPage2 = new WebDriverWait(driver,Duration.ofSeconds(15))
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator.getProperty("SEARCH_RESULTS"))));            
            

            
            // Wait for the third page btn to be clickable
            WebElement Page_3_Btn = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getProperty("PAGE_3_BTN"))));

            js.executeScript("arguments[0].click();", Page_3_Btn);
 
            Assert.assertEquals(driver.getTitle(),URL_DATA.getProperty("PAGE_TITLE"));
               
            
            List<WebElement> searchResultsPage3 = new WebDriverWait(driver,Duration.ofSeconds(15))
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator.getProperty("SEARCH_RESULTS"))));
            
            Assert.assertEquals(searchResultsPage2.size(),searchResultsPage3.size());
            Reporter.log("\n searchResultsPage2: " + searchResultsPage2.size()+" searchResultsPage3: " +searchResultsPage3.size());
    }
	
	
	
	@DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
	 return new Object[][] {
		 {"Vodafone"}
		 };
    }
	}
	
	


