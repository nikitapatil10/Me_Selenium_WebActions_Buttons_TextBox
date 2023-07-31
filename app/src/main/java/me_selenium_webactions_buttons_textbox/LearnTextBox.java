package me_selenium_webactions_buttons_textbox;

import java.util.List;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTextBox {

	RemoteWebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 * 
	 */
	public RemoteWebDriver startBrowser() throws MalformedURLException {
		// Code to Launch Browser using Zalenium in Crio workspace
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Maximize and Implicit Wait for things to initailize
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	/**
	 * use this method to open the url of an application
	 */
	public void openURL(String browserURL) throws InterruptedException {
		System.out.println("opening website --->" + browserURL);
		driver.get(browserURL);
		Thread.sleep(5000);
	}

	/**
	 * use this method to check button isDisplayed or not
	 * 
	 */
	public boolean checkElementIsDisplayed(WebElement webElement) {
		boolean isDisplay = false;

		// TODO : Check whether text box is isDisplayed or not.
		isDisplay = webElement.isDisplayed();
		return isDisplay;
	}

	/**
	 * use this method to enter text in text box and text area
	 */
	public void enterText(WebElement webElement,String text) {
		// TODO : Enter the text into text box
		webElement.sendKeys(text);
	}
	
	/**
	 * use this method to retrieve/read the default(placeholder)
	 * from textbox/textarea
	 */
	
	public String getPlaceHolderText(WebElement webElement) {
		String defaultText = null;
		
		// TODO : retrieve/read the placeholder value
		defaultText = webElement.getText();
		return defaultText;
	}
	
	/**
	 * use this method to check button isEnabled or not
	 */
	public boolean checkElementIsEnabled(WebElement webElement) {
		boolean isEnable = false;
		
		// TODO : check whether textbox is isEnabled or not.
		isEnable = webElement.isEnabled();
		return isEnable;
	}

	/**
	 * use this method to get the height and width of element
	 */
	public void getSizeOfElement(WebElement webElement) {
		int height = 0;
		int width = 0; 
		
		// TODO : get the size of button
		height = webElement.getSize().getHeight();
		width = webElement.getSize().getWidth();
		System.out.println("height is : " +height);
		System.out.println("width is : " +width);

	}

	public void getTotalWebElement(List<WebElement> webElements) {
		int totalCount = 0;
		// TODO : count the total number of text box;
		totalCount = webElements.size();
		System.out.println("total number of text box are : " +totalCount);
		
	}
	
	/**
	 * use this method to close the current window of browser
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser window");
		driver.close();
	}

	public void run() throws InterruptedException, MalformedURLException {
		

		// Step - 1 : Call the method startBrowser
		RemoteWebDriver driver = this.startBrowser();

		// Step - 2 : Call the method openURL
		this.openURL("https://web-locators-static-site-qa.vercel.app/Edit");

		WebElement txtEnteryourName;
		
		/**
		 * Step - 3 : 
		 * TODO : Locate the text box "Enter your name" and assign it to txtEnteryourName
		 * TODO : Call the method checkElementIsDisplayed
		 * TODO : Print the response
		 */
		txtEnteryourName = driver.findElement(By.xpath("//div[@class='Edit_section1']/input"));
		System.out.println(checkElementIsDisplayed(txtEnteryourName));

		/**
		 * Step - 4 : 
		 * TODO : Enter /Type your name in the "Enter your name" textbox.
		 */
		txtEnteryourName.sendKeys("Nikita");
		/**
		 * Step - 5 : 
		 * TODO : Retrieve/read and print the placeholder value of "Your nationality" textbox
		 */
		System.out.println(driver.findElement(By.xpath("//div[@class='Edit_section3']/input")).getAttribute("placeholder"));

		WebElement txtWeightBefore;
		
		/**
		 * Step - 6 and Step - 7 : 
		 * TODO : Locate the text box "My weight before starting the wellness program(in kgs)" and assign it to txtWeightBefore
		 * TODO : Call the method checkElementIsEnabled
		 * TODO : Handle the exception using try-catch block
		 */
		txtWeightBefore = driver.findElement(By.xpath("//input[@class='Edit_textField placeholders42']"));
		try{
			checkElementIsDisplayed(txtWeightBefore);
		
		}
		catch(Exception IO)
		{
			System.out.println("The textbox is not displayed");
		}
		/**
		 *  Step - 8 : 
		 *  TODO : Call the method getSizeOfElement 
		 *  
		 */
		getSizeOfElement(txtWeightBefore);
	
		List<WebElement> totalTextBox;
		
		/**
		 * Step - 9 : 
		 * TODO : Locate the all text box and assign it to totalTextBox.
		 * TODO : Call method getTotalWebElement
		 * 
		 */
		totalTextBox = driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 css-iol86l']/div/input"));
		getTotalWebElement(totalTextBox);
		
		// Call the method closeBrowserg
		this.closeBrowser();
	}
}
