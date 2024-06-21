package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class Cartpage extends abstractComponent{
	WebDriver driver;
	public Cartpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//cartpage
	//Page factory 
			@FindBy(xpath="//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/button")
			WebElement remove;
			//continue shopping cta
			@FindBy(xpath="//a[@class='btn_secondary']")
			WebElement continueShoppingBtn;
			//checkout button
			@FindBy(xpath="//div[@class='cart_footer']//a[2]")
			WebElement checkoutCta;
			By checkoutctaappeared = By.xpath("//div[@class='cart_footer']//a[2]");
	//cartpage
	          
			public Productspage Productspage;
			public Checkoutpage Checkoutpage;
			
			
			public void removeItem() throws InterruptedException {
				
				Thread.sleep(8000);
				//waitForElementToAppear(displayRemove);
				remove.click();
				
				//Actions a = new Actions(driver);
				
				//a.moveToElement(remove).click().build().perform();
				
			}


	public void continueshopping() {
		// TODO Auto-generated method stub
		continueShoppingBtn.click();
	}
	public Checkoutpage clickOnCheckout()  throws InterruptedException {
		// TODO Auto-generated method stub
		waitForElementToAppear(checkoutctaappeared);
		checkoutCta.click();
		return Checkoutpage;
		
	}
	
	
	
}
