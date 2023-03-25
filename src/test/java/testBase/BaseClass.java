package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {

	public static WebDriver driver;
	public	Logger logger; 
	
	public ResourceBundle rb;//logging

	//@BeforeClass
//	@Parameters("Browser")
	/*
	 * public void setUp(String br) throws Exception {
	 * 
	 * logger =LogManager.getLogger(this.getClass()); //logging
	 * 
	 * if(br.equals("Chrome")) { ChromeOptions co = new ChromeOptions();
	 * 
	 * co.addArguments("--remote-allow-origins=*");
	 * 
	 * driver = new ChromeDriver(co); } else if(br.equals("Edge")){ driver =new
	 * EdgeDriver(); } else { driver=new FirefoxDriver() ; }
	 */
	@BeforeClass(groups= {"Regression","Master","Sanity"})
	public void setUp() throws Exception {
		rb=ResourceBundle.getBundle("config");
		logger =LogManager.getLogger(this.getClass());
		ChromeOptions co = new ChromeOptions();
		  co.addArguments("--remote-allow-origins=*");
		  
		 driver = new ChromeDriver(co);
		driver.manage().deleteAllCookies()	;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		Thread.sleep(2000);
		driver.manage().window().maximize();

		   
		
	}
	@AfterClass(groups= {"Regression","Master","Sanity"})
	public void teardown() {

		driver.quit();
		
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);

	}

	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return (generatedNumber);
	}

	public String randomAlpanumeric() {
		String st = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(10);
		return (st + "@" + num);
	}

	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File Source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "-" + timeStamp + ".png";

		try {
			FileUtils.copyFile(Source, new File(destination));

		} catch (Exception e) {

			e.getMessage();
		}

		return destination;

	}
	
}