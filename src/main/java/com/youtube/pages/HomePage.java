package com.youtube.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.youtube.base.TestBase;

public class HomePage extends TestBase {

	WebDriverWait wait = new WebDriverWait(driver, 5);
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	//=============================================Element Identifiers============================================//

	@FindBy(xpath = "(//yt-icon[@class='style-scope ytd-button-renderer'])[3]")
	WebElement SignInButton;

	@FindBy(xpath = "//div[text()='Use another account']")
	WebElement useOtherAccountLink;

	@FindBy(xpath = "//input[@type='email']")
	WebElement usernameTextBox;

	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement NextButton;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordTextBox;

	@FindBy(id = "search")
	WebElement searchBox;

	@FindBy(id = "search-icon-legacy")
	WebElement searchButton;
	
	
    //Upload Video Elements
	
	@FindBy(xpath = "//yt-icon[@class='style-scope ytd-topbar-menu-button-renderer']")
	WebElement videoIcon;

	@FindBy(xpath = "//yt-formatted-string[text()='Upload video']")
	WebElement uploadVideo;

	@FindBy(className="opened']")
	WebElement CreateChannelLink;

	@FindBy(xpath="//yt-formatted-string[text()='Upload video']")
	WebElement UploadVideoButton;

	@FindBy(xpath="//div[text()='Continue']")
	WebElement ContinueButton;

	@FindBy(xpath="//div[text()='Select files']")
	WebElement selectFileButton;

	@FindBy(xpath="//div[@id='speed-line']/following-sibling::div[1]']")
	WebElement DragandDrop;
	
	@FindBy(xpath="//div[text()='Next']")
	WebElement ImageNextButton;

	@FindBy(id="offRadio")
	WebElement FirstRadioButton;
	
	@FindBy(xpath="//div[text()='Save']")
	WebElement ImageSaveButton;
	
	//Playback Elements
	@FindBy(xpath="//a[@href='/watch?v=WzuJANOPLyQ&t=148s']")
	WebElement TutorialLink;
	
	@FindBy(xpath="//*[@aria-label='Play (k)']")
	WebElement PauseIcon;
	
	
	//============================Methods==========================================//

	//Login You Tube
	public void Login(String username,String password) throws InterruptedException{
		SignInButton.click();
		//useOtherAccountLink.click();
		usernameTextBox.sendKeys(username);
		NextButton.click();
		wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
		//Thread.sleep(4000);
		passwordTextBox.sendKeys(password);
		NextButton.click();
		Thread.sleep(8000);
	}


	//Enter the value in Search text box
	public String sendvalueToSearchTextBox(String element){
		searchBox.click();
		searchBox.sendKeys(element);
		return element;
	}

	public void EnterSearchButton() {
		searchButton.click();
	}

	public void uploadVideoLink() throws Exception {
		videoIcon.click();
		uploadVideo.click();
		Thread.sleep(3000);
		selectFileButton.click();
		Thread.sleep(3000);
		//CreateChannelLink.click();
		//UploadVideoButton.click();
		Runtime.getRuntime().exec(prop.getProperty("AutoItpath"));
		Thread.sleep(3000);
		ImageNextButton.click();
		FirstRadioButton.click();
		ImageNextButton.click();
		ImageNextButton.click();
		ImageNextButton.click();
		ImageSaveButton.click();
		Thread.sleep(3000);
	}
	
	public void Playback() throws InterruptedException {
		
		driver.get(prop.getProperty("TutorialPath"));
		driver.getTitle();
		verifyPlayTimeOfVideo();
		
		
		
	}
}