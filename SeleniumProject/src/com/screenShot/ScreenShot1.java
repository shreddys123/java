package com.screenShot;

import java.io.File;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot1 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sasir\\Desktop\\selenium\\chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		 List<WebElement> links = driver.findElements(By.linkText("Rajinikanth"));
		 System.out.println(links.size());
		 
		 if(links.size()==0)
		 {
			 File srcScreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileHandler.copy(srcScreen,new File("C:\\Users\\sasir\\Desktop\\abc1.jpeg"));
		 }
			 
		 
	}

}
