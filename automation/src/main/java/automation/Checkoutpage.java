package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class Checkoutpage extends abstractComponent{
	WebDriver driver;
	public Checkoutpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Page factory 
	@FindBy(xpath="//input[@id='first-name']")
	WebElement firstname;
	By waitForFirstName = By.xpath("//input[@id='first-name']");
	@FindBy(xpath="//input[@id='last-name']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement postalcode;
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	public Cartpage Cartpage;
	public Overviewpage Overviewpage;
	
	
	
	
	public void enterFirstName(String fname) throws InterruptedException {
		waitForElementToAppear(waitForFirstName);
		firstname.sendKeys(fname);
	}
	public void enterLastName(String lname) throws InterruptedException {
		
		lastname.sendKeys(lname);
	}
public void enterPostalCode(String pcode) throws InterruptedException {
		
		postalcode.sendKeys(pcode);
		
	}
public void clickOnSubmit() {
	submit.click();
}

}
