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
	
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);	
		Date date = new Date();
		String Data_extention = date.toString().replace(" ", "-").replace(":", "-");
		String path =  System.getProperty("user.dir")+"\\screenshots\\"+ScreenShot_Name+Data_extention+".png";
		FileUtils.copyFile(SrcFile, new File(path));
		return path;
	}
}
