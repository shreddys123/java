
package com.launch;
import com.relevantcodes.extentreports.LogStatus;

public class TC_006 extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		
		
		init();
		test=report.startTest("TC_006");
		test.log(LogStatus.INFO, "Initializating the properties & configaration files...");
		
		launchBrowser("chromebrowser");
		test.log(LogStatus.PASS, "Open the browser.." + p.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		test.log(LogStatus.PASS, "Navigate to the url.." + childEnv.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		test.log(LogStatus.PASS, "Selected the option Books by using the locator.." + orprop.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtext_id","Harry potter");
		test.log(LogStatus.PASS, "Entered the Harry potter by using the locator.." + orprop.getProperty("amazonsearchtext_id"));
		
		elementClick("amazonsearchbotton_xpath");
		test.log(LogStatus.PASS,"Clicked on the search button by using the locator.." + orprop.getProperty("amazonsearchbotton_xpath"));
		
		report.endTest(test);
		report.flush();
			
	}

			
	}	


