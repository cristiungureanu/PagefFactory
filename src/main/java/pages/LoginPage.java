package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class LoginPage extends SeleniumWrappers{

	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="ul input[id='log']")
	public WebElement usernameField;
	// SAU
	
	//public By usernameField = By.cssSelector("ul input[id='log']");  // punerea intr o variabila
	//WebElement element = driver.findElement(usernameField);
	
	@FindBy(css= "ul input[id='password']" )
	public WebElement passwordField;
	//public By passwordField = By.cssSelector("ul input[id='password']");
	
	@FindBy(css= "ul input[class='submit_button']" )
	public WebElement submitButton;
	//public By submitButton = By.cssSelector("ul input[class='submit_button']");
	
	@FindBy(css= "div[class*='sc_infobox_style_error']" )
	public WebElement loginErrorMessage;
	
	@FindBy(css= "div[class*='sc_infobox_style_success']" )
	public WebElement loginSuccessMessage;
	//public By loginSuccessMessage = By.cssSelector("div[class*='sc_infobox_style_success']");
	
	@FindBy(css= "li[class='menu_user_logout']" )
	public WebElement logoutButton;
	
	@FindBy(css= "div[class*='sc_infobox_style_success']" )
	public WebElement closePopUpButton;
	
	public void closeLoginPopUp() {
		//closePopUpButton.click();
		click(closePopUpButton);
	}
	
	public void loginInApp(String username, String password) {
		
		sendKeys(usernameField, username);
		sendKeys(passwordField, password);
		click(submitButton);

	}
	
	public void logoutFromApp() {
		
		click(logoutButton);
	}
	
	
	public boolean loginSuccessMessageIsDisplayed() {
		
		return loginSuccessMessage.isDisplayed(); // isDisplayed intoarce valoarea booleana - true sau false
	}
	
	public boolean loginErrorMessageIsDisplayed() {
		
		return loginErrorMessage.isDisplayed(); 
	}
	
	public boolean loginMessageIsDisplayed(WebElement element) {
		
		return element.isDisplayed();
	}
}
