package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;



public class Finishpage extends abstractComponent{
	WebDriver driver;
	public Finishpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stubthis.driver = driver;
		PageFactory.initElements(driver, this);
	}
//Page Factory
	@FindBy(xpath="//h2[@class='complete-header']")
	WebElement message;
	public Overviewpage Overviewpage;



public void verifyMessage() {
	System.out.println(message.getText());
}
}