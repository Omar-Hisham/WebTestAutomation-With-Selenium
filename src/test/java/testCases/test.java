/**
 * Test cases to verify search functionality on a search engine and navigating to different pages.
 * This class extends BaseTest class to utilize setup and teardown methods.
 */
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

	
	/**
     * Test case to perform search and verify search results pagination.
     * 
     * @param keyword The keyword to search for.
     * @throws InterruptedException If the execution is interrupted while sleeping.
     */
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
	
	


