package com.launch;

public class TC_003 extends BaseTest
{
	//private static final Logger log = Logger.getLogger(TC_003.class);
	public static void main(String[] args) throws Exception 
	{
		
		init();
		//log.info("Initializing the properties & configuration files...");
		
		launchBrowser("chromebrowser");
		//log.info("opened the browser :" + p.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		//log.info("Navigated to url :" + childEnv.getProperty("amazonurl"));
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver.manage().deleteAllCookies();
		
		driver.navigate().back();
		Thread.sleep(4000);
		
		driver.navigate().forward();
		Thread.sleep(4000);
		
		driver.navigate().refresh();
		Thread.sleep(4000);
		
	   String source = driver.getPageSource();
	   System.out.println(source);
		
		driver.close();
		
		driver.quit();

	}

		
	

}
