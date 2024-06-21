package automation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


import AbstractComponent.abstractComponent;

public class Homepage extends abstractComponent{
	WebDriver driver;
	public Homepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//page factory
	@FindBy(id="user-name")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login-button")
	WebElement loginbutn;
	public Productspage Productspage;
	public Cartpage Cartpage;
	
	
	
	public void url(){
		driver.get("https://www.saucedemo.com/v1/");
		
	}
	
	public void enterUsername(String uname) {
		username.sendKeys(uname);
	}

	public void enterPassword(String pword) {
		// TODO Auto-generated method stub
		password.sendKeys(pword);
	}
	
	public Productspage clickLogin() throws InterruptedException {
		Thread.sleep(5000);
		loginbutn.click();
		return Productspage;
	}
	
	
	
	
}
