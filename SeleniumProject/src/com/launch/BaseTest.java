package com.launch;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest
{
	public static WebDriver driver;
	public static String projectpath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties parentEnv;
	public static Properties childEnv;
	public static Properties orprop;
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	public static void init() throws Exception
	{
	    fis=new FileInputStream(projectpath+"//data.properties");
	    p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectpath + "//or.properties");
		orprop=new Properties();
		orprop.load(fis);
		
		fis=new FileInputStream(projectpath + "//environment.properties");
		parentEnv =new Properties();
		parentEnv.load(fis);
		String e = parentEnv.getProperty("env");
		System.out.println(e);
		
		fis=new FileInputStream(projectpath + "//" + e + ".properties");
		childEnv=new Properties();
		childEnv.load(fis);
		String url=childEnv.getProperty("amazonurl");
		System.out.println(url);
		
		fis=new FileInputStream(projectpath + "//log4j.properties");
		PropertyConfigurator.configure(fis);
		
	   report=ExtentManager.getInstance();
	}	
	
	public static void launchBrowser(String browser)
	{
		if(p.getProperty(browser).equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",projectpath+"//drivers//chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "false");
			
			ChromeOptions option=new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\sasir\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
			option.addArguments("--disable-notifications");
			driver=new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",projectpath+"//drivers//geckodriver.exe");
			
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile = p.getProfile("mayfirefoxpath");
			 profile.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions option=new FirefoxOptions();
			option.setProfile(profile);
			
			driver=new FirefoxDriver(option);	
	}
		driver.manage().window().maximize();
	}
	
	public static void navigate(String url)
	{
		//driver.get(childEnv.getProperty(url));
		driver.navigate().to(childEnv.getProperty(url));
		
	}
	

	public static WebElement getElement(String locatorkey) 
	{
		WebElement element=null;
		if(locatorkey.endsWith("_id"))
		{
			element=driver.findElement(By.id(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_name"))
		{
			element=driver.findElement(By.name(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_classname"))
		{
			element=driver.findElement(By.className(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_xpath"))
		{
			element=driver.findElement(By.xpath(orprop.getProperty(locatorkey)));
			
		}else if(locatorkey.endsWith("_css"))
		{
			element=driver.findElement(By.cssSelector(orprop.getProperty(locatorkey)));
			
		}else if(locatorkey.endsWith("_linktext"))
		{
			element=driver.findElement(By.linkText(orprop.getProperty(locatorkey)));
			
		}else if(locatorkey.endsWith("_partiallinktext"))
		{
			element=driver.findElement(By.partialLinkText(orprop.getProperty(locatorkey)));
			
		}
		return element;
	}
	public static void elementClick(String locator)
	{	
		getElement(locator).click();
		//driver.findElement(By.xpath(locator)).click();
	}

	
	public static void typeText(String locatorkey, String text) 
	{	
		getElement(locatorkey).sendKeys(text);
		//driver.findElement(By.id(locatorkey)).sendKeys(text);
	}

	public static void selectOption(String locatorkey, String option)
	{	
		getElement(locatorkey).sendKeys(option);
		//driver.findElement(By.id(locatorkey)).sendKeys(option);
    }
}
