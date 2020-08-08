package com.launch;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends BaseTest
{
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		
		if(extent ==null)
		{
			extent =new ExtentReports(projectpath + "//HTMLReports//report1.html");
			extent.loadConfig(new File(projectpath + "//extentreport.xml"));
			extent.addSystemInfo("Selenium Language", "3.141.59").addSystemInfo("environment",parentEnv.getProperty("env"));
		}
	   
		return extent;
		
	}
}
