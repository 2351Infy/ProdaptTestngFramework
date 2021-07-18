package com.walletHub.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sun.glass.ui.Robot;

public class Test01 {

	public static WebDriver driver;
	public static Properties prop;


	@SuppressWarnings("deprecation")
	@Test
	public static void initialization() throws InterruptedException{

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/"
					+ "/com/walletHub/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String browserName = prop.getProperty("browser");

		ChromeOptions options=new ChromeOptions();
		//DesiredCapabilities cap = DesiredCapabilities.;

		ChromeDriver driver;
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/win/chromedriver.exe");
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new ChromeDriver(options);

			//driver.get(prop.getProperty("url"));
			driver.get("https://wallethub.com/profile/test_insurance_company/");

			driver.manage().window().maximize();
			WebElement review=driver.findElement(By.xpath("//span[contains(text(),'Reviews')]/ancestor::a[(@class='nav-link semi-bold-font-weight')]"));
			Thread.sleep(4000);
			review.click();
			List<WebElement> stars=driver.findElements(By.cssSelector("#reviews-section > div.review-stat-box > div.rv.review-action.ng-enter-element > review-star > div > svg"));
			System.out.println(stars);


			WebElement fourthStar=driver.findElement(By.cssSelector("#reviews-section > div.review-stat-box > div.rv.review-action.ng-enter-element > review-star > div > svg:nth-child(4)"));
			for(WebElement e:stars) {
			

				Actions act = new Actions(driver);
				act.moveToElement(e).clickAndHold().build().perform();

				//Perform Mouse Hover

				if ((new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElements(e))).size()<4) {
					System.out.println("Previous Stars are highlighted");
					if(e.equals(fourthStar)) {
						e.click();
					}
				}
				else {
					System.out.println("Last Star is not highlighted");
				}
			}
			Select select=new Select(driver.findElement(By.className("dropdown-placeholder mob")));
			select.selectByVisibleText("Health Insurance");
			driver.findElement(By.className("textarea wrev-user-input validate")).sendKeys("Knowing that millions of people around the world would be watching in person and on television and expecting great things from him — at least one more gold medal for America, if not another world record — during this, his fourth and surely his last appearance in the World Olympics, and realizing that his legs could no longer carry him down the runway with the same blazing speed and confidence in making a huge, eye-popping leap that they were capable of a few years ago when he set world records in the 100-meter dash and in the 400-meter relay and won a silver medal in the long jump, the renowned sprinter and track-and-field personality Carl Lewis, who had known pressure from fans and media before but never, even as a professional runner, this kind of pressure, made only a few appearances in races during the few months before the Summer Olympics in Atlanta, Georgia, partly because he was afraid of raising expectations even higher and he did not want to be distracted by interviews and adoring fans who would follow him into stores and restaurants demanding autographs and photo-opportunities, but mostly because he wanted to conserve his energies and concentrate, like a martial arts expert, on the job at hand: winning his favorite competition, the long jump, and bringing home another Gold Medal for the United StatesKnowing that millions of people around the world would be watching in person and on television and expecting great things from website — at least one more 4 stars, if not another 5stars — during this, the fourth and surely the last appearance in this review section.");
			
			driver.findElement(By.xpath(".//div[text()='Submit']")).click();
			driver.quit();
		}}}

