package utils;


import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers {

	public WebDriver driver;
	
	public SeleniumWrappers(WebDriver driver) {
		
		this.driver = driver;
	}
	
	/**
	 * Custom sendKeys method/ Wraps selenium default SendKeys and enhance it
	 * with clear() method before sending the text
	 * @param locator --> used inside method to create a WebElement object
	 * @param value --> String value 
	 */
	
	
	public void sendKeys(WebElement element, String value) {
			
		//WebElement element = driver.findElement(locator);
		waitForElementToBeVisible(element);
		
		try {
			Log.info("called <clear> on element " + element.getAttribute("outerHTML"));
			element.clear();
			Log.info("Called <sendKeys> on element " + element.getAttribute("outerHTML"));
			element.sendKeys(value);
			
		}catch(Exception e) {
			Log.error("Element not found in method <SendKeys>]");
			Log.error(e.getMessage());
		}
		}
	
	public void click(WebElement element) {
		//WebElement element = driver.findElement(locator);
		Log.info("Called method <click()> on element " + element.getAttribute("outerHTML"));
		
		try {
			waitForElementToBeClickable(element);
			element.click();
		}catch(NoSuchElementException e) {
			
			Log.error("Element not found in method <click()> after 10 seconds");
			Log.error(e.getMessage());	
			
		}catch (StaleElementReferenceException e) {
			//element =  driver.findElement(locator);
			Log.error("Called <StaleElementReferenceException> on element " + element.getAttribute("outerHTML"));
			element.click();
		}
	}
	
	/**
	 * 
	 * 
	 * @param element
	 */
	public void waitForElementToBeClickable(WebElement element) {
			try {
				Log.info("Called <waitForElementToBeClickable>" + element.getAttribute("outerHTML"));
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			}catch(NoSuchElementException e){
				Log.error("Element not found in method <waitForElementToBeClickable> after 10 seconds");
				Log.error(e.getMessage());
			}
		}
	
	public void waitForElementToBeVisible(WebElement element) {
		try {
			Log.info("Called <waitForElementToBeVisible> on element " + element.getAttribute("outerHTML"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(NoSuchElementException e) {
			Log.error("Element not found in method <waitForElementToBeVisible> after 10 seconds");
			Log.error(e.getMessage());
		}
	}
	
	public void dragAndDrop (WebElement element, int x, int y) {
		
		//WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, x, y);
		
		
	}

	public void hoverElement(WebElement element) {	
		//WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();	
	}
	
	public String readUrl() {
		System.out.println("");
		return driver.getCurrentUrl();
	}
	
	
}
