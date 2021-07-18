package com.youtube.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.youtube.pages.MobilePages;
import com.youtube.util.TestUtil;
import com.youtube.util.WebEventListener;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/youtube"
					+ "/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@SuppressWarnings("deprecation")
	public static void initialization() throws MalformedURLException{
		String browserName = prop.getProperty("browser");
		ChromeOptions options=new ChromeOptions();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		

		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/win/chromedriver.exe");
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new ChromeDriver(cap);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			e_driver = new EventFiringWebDriver(driver);
			// created object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		}
		else if(browserName.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", "./drivers/win/geckodriver.exe");
			driver = new FirefoxDriver(); 
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

			
			e_driver = new EventFiringWebDriver(driver);
			// created object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		}
		
		else if(browserName.equals("headless")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/win/chromedriver.exe");
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			options.setHeadless(true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
			driver.get(prop.getProperty("url"));
			e_driver = new EventFiringWebDriver(driver);
			// created object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
		}
		else if(browserName.equals("MobileApp")) {
		 DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "Abhishek M31");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("udid", "RZ8N50B1XCM");
			capabilities.setCapability("automationName", "uiautomator2");
			capabilities.setCapability("appPackage", "com.google.android.youtube");
			capabilities.setCapability("appActivity", "com.google.android.youtube.UrlActivity");
			
			URL url=new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(url, capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		}
	}
	
	public void verifyPlayTimeOfVideo() throws InterruptedException {
		//String returnValue = (String)driver.execute_script('return player.getPlayerState()');
				JavascriptExecutor js = (JavascriptExecutor) driver;
				//Declare and set the start time		
		        long start_time = System.currentTimeMillis();			
		                 
		        //Call executeAsyncScript() method to wait for 5 seconds		
		        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");			
		        		
		       //Get the difference (currentTime - startTime)  of times.		
		       System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));		
				Thread.sleep(6000);
	}
	
	public void verifymobileVideoPlay() throws InterruptedException {
		 long startTime = 0,stopTime = 0,elapsedTime = 0;
		 startTime = System.currentTimeMillis();
		 Thread.sleep(5000);
		 stopTime = System.currentTimeMillis();
		 elapsedTime = stopTime - startTime;
		 elapsedTime/=1000;
		 System.out.println(elapsedTime);
		
	}
}
	
