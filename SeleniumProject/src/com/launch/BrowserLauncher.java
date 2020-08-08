package com.launch;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLauncher 
{

	public static void main(String[] args)
	{
		//i am not using setproerty method, i already set the environment variable properties
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sasir\\Desktop\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sasir\\Desktop\\selenium\\geckodriver.exe");
		FirefoxDriver driver1=new FirefoxDriver();
		driver1.get("https://www.bestbuy.com");
		
		//webdriver.ie.driver
		
		//webdriver.edge.driver
		

	}

}
