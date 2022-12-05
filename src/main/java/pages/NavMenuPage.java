package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumWrappers;

public class NavMenuPage extends SeleniumWrappers{

	
	public NavMenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "BOOKS")
	public WebElement shopLink;
	//public By shopLink = By.linkText("BOOKS");
	
	@FindBy(linkText = "Login")
	public WebElement loginLink;
	
	@FindBy(linkText = "CONTACTS")
	public WebElement contactLink;

	@FindBy(linkText = "SINGLE AUTHOR")
	public WebElement singleAuthor;
	
	@FindBy(linkText = "BLOG")
	public WebElement blog;
	
	@FindBy(linkText = "ABOUT")
	public WebElement aboutLink;
	
	@FindBy(linkText = "Post Formats")
	public WebElement postFormatsBlogLink;
	
	@FindBy(css = "button[class*='search_submit']")
	public WebElement searchIcon;
	
	@FindBy(css = "input[class*='search_field']")
	public WebElement searchField;

	@FindBy(xpath = "//div[@id='sc_tab_1456822345_1_17']/descendant::a[contains(@href,'garden')]")
	public WebElement product;
	
	
	public void navigateTo(WebElement element) {
		
		element.click();
		//sau
		//click(element);
	}
	
	
	public void searchBook(String value) {
		click(searchIcon);
		sendKeys(searchField, value);
		click(searchIcon);
	}
	
	public boolean isBookPictureDisplayed(String picture) {
		WebElement element =  driver.findElement(By.cssSelector("div[data-image*='"+picture+"']"));
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}
	
}
