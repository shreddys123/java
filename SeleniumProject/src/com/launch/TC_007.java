package com.launch;

import com.relevantcodes.extentreports.LogStatus;

public class TC_007 extends BaseTest
{
	

	public static void main(String[] args) throws Exception
	{
		init();
		test=report.startTest("TC_007");
		test.log(LogStatus.INFO, "Initializating the properties & configaration files...");
		
		launchBrowser("chromebrowser");
		test.log(LogStatus.PASS, "Open the browser.." + p.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		test.log(LogStatus.PASS, "Navigate to the url.." + childEnv.getProperty("amazonurl"));

	}

}
