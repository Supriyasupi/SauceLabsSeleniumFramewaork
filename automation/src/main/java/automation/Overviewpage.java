package automation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class Overviewpage extends abstractComponent{
	WebDriver driver;
	public Overviewpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//PageFactory
	
	@FindBy(xpath="//div[@class='summary_total_label']")
	WebElement totalAmount;
	@FindBy(xpath="//div[@class='inventory_item_price']")
	WebElement itemPrice;
	@FindBy(xpath="//div[@class='summary_subtotal_label']")
	WebElement itemTotal;
	@FindBy(xpath="//a[@class='btn_action cart_button']")
	WebElement finishButton;
	
	public Checkoutpage Checkoutpage;
	public Overviewpage Overviewpage;
	public Finishpage Finishpage;
	
	public void getTotalAmount() {
		//Assert.assertEquals(itemPrice.getText(), itemTotal.getText());
		System.out.println("Total Amount is : " + totalAmount.getText());
		
		return;
	}
	
	public Finishpage finish(){
		finishButton.click();
		return Finishpage;
	}
	
}
