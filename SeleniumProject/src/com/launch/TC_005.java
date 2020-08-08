
package com.launch;

import org.apache.log4j.Logger;

public class TC_005 extends BaseTest
{
	private static final Logger log = Logger.getLogger(TC_005.class);

	public static void main(String[] args) throws Exception
	{
		
		
		init();
		log.info("Initializating the properties & configaration files...");
		
		launchBrowser("chromebrowser");
		log.info("Open the browser.." + p.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		log.info("Navigate to the url.." + childEnv.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		log.info("Selected the option Books by using the locator.." + orprop.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtext_id","Harry potter");
		log.info("Entered the Harry potter by using the locator.." + orprop.getProperty("amazonsearchtext_id"));
		
		elementClick("amazonsearchbotton_xpath");
		log.info("Clicked on the search button by using the locator.." + orprop.getProperty("amazonsearchbotton_xpath"));
		
		
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry poter");
		
		//driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
		
		
	}

			
	}	


