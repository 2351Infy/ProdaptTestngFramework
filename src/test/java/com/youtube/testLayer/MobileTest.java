package com.youtube.testLayer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.youtube.base.TestBase;
import com.youtube.pages.HomePage;
import com.youtube.pages.MobilePages;
import com.youtube.util.TestUtil;

public class MobileTest extends TestBase  {

	ExtentReports extent;
    MobilePages mobilePages;
	TestUtil testUtil=new TestUtil();


	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser


	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		mobilePages= new MobilePages(); 
	}

	@Test(priority=1,enabled=false)
	public void searchVideo() throws Exception {
		mobilePages.serachAndPlaybackVideobyName("Java Selenium");

	}
	
	@Test(priority=1,enabled=true)
	public void uploadVideo() {
    mobilePages.UploadAVideo();
	}

	@AfterMethod
	public void TearDown() {
		System.out.println("Stop driver");
		MobilePages.driver.quit();
		System.out.println("Stop appium service");	
	}
}

