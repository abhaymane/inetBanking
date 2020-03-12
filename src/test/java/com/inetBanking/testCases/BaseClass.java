package com.inetBanking.testCases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
public String baseURL=readconfig.getApplicationURL();
public String username=readconfig.getUsername();
public String password=readconfig.getPassword();
public static WebDriver driver;
public static Logger logger;
@Parameters("browser")
@BeforeClass
public void setup(String br) {
	
	logger=Logger.getLogger("ebanking");
	PropertyConfigurator.configure("Log4j.properties");
	if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());

		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	else if(br.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
		driver=new FirefoxDriver();
	}
	driver.get(baseURL);
}
 @AfterClass
public void  teardown() {
	driver.quit();
}
 public void capturescreenShot(WebDriver driver,String tname) throws IOException {
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File src=ts.getScreenshotAs(OutputType.FILE);
	 File dest=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	 FileUtils.copyFile(src, dest);
	 System.out.println("Screenshot taken");
 }
 public String randomestring() {
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	public static String randomeNum() {
		String generatedString2=RandomStringUtils.randomNumeric(4);
		return generatedString2;
	}
}

