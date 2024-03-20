/**
 * This class provides utilities for taking screenshots using Selenium WebDriver.
 * It extends the BaseTest class to inherit necessary functionalities.
 */
package utilities;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class test_utilities extends BaseTest {
	public String getSnapshot(String ScreenShot_Name) throws IOException {
	    /**
	     * Captures a screenshot and saves it with the provided name and timestamp.
	     * 
	     * @param ScreenShot_Name The name to be given to the screenshot file.
	     * @return The path of the saved screenshot file.
	     * @throws IOException If an I/O error occurs while saving the screenshot.
	     */
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);	
		Date date = new Date();
		String Data_extention = date.toString().replace(" ", "-").replace(":", "-");
		String path =  System.getProperty("user.dir")+"\\screenshots\\"+ScreenShot_Name+Data_extention+".png";
		FileUtils.copyFile(SrcFile, new File(path));
		return path;
	}
}
