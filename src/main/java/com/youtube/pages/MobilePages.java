package com.youtube.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;
import com.youtube.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;

public class MobilePages extends TestBase {
	

	WebDriverWait wait = new WebDriverWait(driver, 10);
	// Initializing the Page Objects:
	public MobilePages() {
		PageFactory.initElements(driver, this);
	}


	//=============================================Element Identifiers============================================//

	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Search\"]")
	WebElement SearchIcon;
	
	@FindBy(id = "com.google.android.youtube:id/search_edit_text")
	WebElement SearchTextField;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Selenium Java Tutorial For Beginners | Automation Testing Tutorial | Selenium WebDriver | Edureka - 49 minutes - Go to channel - edureka! - 196K views - 2 years ago - play video\"]")
	WebElement videoLink;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Create\"]/android.widget.ImageView\r\n" + 
			"")
	WebElement PlusIcon;
	
	@FindBy(xpath ="//android.view.ViewGroup[@content-desc=\"Upload a video\"]\r\n" + 
			"")
	WebElement UploadAVideo;
	
	@FindBy(id = "com.google.android.youtube:id/allow_access_button")
	WebElement AllowAccess;
	
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	WebElement AllowAccessPopUp;
	
	@FindBy(xpath = "//*[@text='While using the app'")
	WebElement WhileUsingApp;
	
	@FindBy(id = "com.google.android.youtube:id/thumb_image_view_parent")
	WebElement SelectFirstVideo;

	@FindBy(id = "com.google.android.youtube:id/shorts_trim_next_button")
	WebElement NextButton;
	
	@FindBy(id = "com.google.android.youtube:id/upload_menu_button")
	WebElement AddDetailsNextButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Upload\"]\r\n" + 
			"")
	WebElement SelectAudienceUploadButton;
	
	

	


	//=============================================Element Identifiers============================================//

	public void serachAndPlaybackVideobyName(String element) throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(SearchIcon));
		SearchIcon.click();
		wait.until(ExpectedConditions.visibilityOf(SearchTextField));
		SearchTextField.click();
		SearchTextField.sendKeys(element);
		((RemoteWebDriver) driver).executeScript("mobile: performEditorAction", ImmutableMap.of("action", "done"));
		wait.until(ExpectedConditions.visibilityOf(videoLink));
		videoLink.click();
		verifymobileVideoPlay();
		
	}
	public void UploadAVideo() {
		PlusIcon.click();
		UploadAVideo.click();
		AllowAccess.click();
		AllowAccessPopUp.click();
		wait.until(ExpectedConditions.alertIsPresent()); 
		Alert alert = driver.switchTo().alert(); alert.dismiss();
		//WhileUsingApp.click();
		SelectFirstVideo.click();
		NextButton.click();
		AddDetailsNextButton.click();
		SelectAudienceUploadButton.click();
		
	}
}
