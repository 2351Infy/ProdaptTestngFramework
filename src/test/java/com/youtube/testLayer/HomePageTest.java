package com.youtube.testLayer;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.youtube.base.TestBase;
import com.youtube.pages.HomePage;
import com.youtube.util.TestUtil;

public class HomePageTest extends TestBase {
	
	ExtentReports extent;
	

	//HomePage homePage= new HomePage();
	HomePage homePage;
	TestUtil testUtil=new TestUtil();



	public HomePageTest() {
	super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser

	@BeforeMethod 
	public void setUp() throws MalformedURLException { 
	initialization(); 
	homePage= new HomePage(); 
	}
	
	//Test scenario is to enter the value in search text box and click on the search button.
		@Test(priority=1, enabled=false)
		public void LoginTest() throws InterruptedException, IOException{
		Thread.sleep(3000);
		homePage.Login("learning2021newtown", "Local@123");
		Thread.sleep(2000);
		}


	//Test scenario is to enter the value in search text box and click on the search button.
	@Test(priority=1, enabled=false)
	public void searchVideo() throws InterruptedException, IOException{
	Thread.sleep(3000);
	homePage.sendvalueToSearchTextBox("Java Selenium");
	Thread.sleep(60);
	TestUtil.takeScreenshotAtEndOfTest();
	homePage.EnterSearchButton();
	TestUtil.takeScreenshotAtEndOfTest();

	}
	
	//Test to Playback the searched video
	@Test(priority=2,enabled=true)
	public void playbackVideoTest() throws InterruptedException, IOException {
		LoginTest();
		searchVideo();
		homePage.Playback();
		Thread.sleep(6000);
	}
	
	
	//Test to upload a video
	@Test(priority=2,enabled=false)
	public void UploadVideoTest() throws Exception {
	LoginTest();
	homePage.uploadVideoLink();

	Thread.sleep(5000);
	}


	@AfterMethod
	public void tearDown(){
	//extent.flush();
	driver.quit();
	}


}
