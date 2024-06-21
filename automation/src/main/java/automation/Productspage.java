package automation;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponent.abstractComponent;

public class Productspage extends abstractComponent{

	WebDriver driver;
	//Initialization
		public Productspage(WebDriver driver) {
			// TODO Auto-generated method stub
			super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);

		}
		
		//Page factory 
		
		//ProductsPage
		@FindBy(xpath="//div[@id='inventory_filter_container']//div")
		WebElement titleText;
		@FindBy(xpath="//select[@class='product_sort_container']")
		WebElement dropdown;
		//all items title
		@FindBys(@FindBy(xpath="//div[@class='inventory_item_name']"))
		List<WebElement> allListTitle;
		//Add to cart cta 
		@FindBy(xpath="//button[@class='btn_primary btn_inventory']")
		WebElement addtocartButton;
		//Remove button cta
		@FindBys(@FindBy(xpath="//button[@class='btn_secondary btn_inventory']"))
		List<WebElement>removecta;
		//cartcount
		@FindBy(xpath="//span[@class='fa-layers-counter shopping_cart_badge']")
		WebElement cartCount;
		//carticon
		@FindBy(xpath="//a[@href='./cart.html']")
		WebElement cartIcon;
		
		
		
		
		public Cartpage Cartpage;
		
		
		
		//Product Page
		public boolean getTitle() throws InterruptedException {
			Thread.sleep(5000);
			
			Assert.assertEquals("Products", titleText.getText());
			return true;
		}

		public void clickonDropdown() {
			dropdown.click();
			Select sel = new Select(dropdown);
			sel.selectByValue("hilo");
			
		}
		//list title
		
		
		public void getListTitle() {
			
			
			Iterator<WebElement> itr = allListTitle.iterator();
			while(itr.hasNext()==true) {
			    itr.next().getText().contains("Sauce Labs Bike Light");
			    addtocartButton.click();
			}
			
			//return allListTitle;
			
		}
		
		
	//Verify number of items in cart to number of Remove cta in products page

		public boolean countOfRemoveButton() {
			
			Assert.assertEquals(2, removecta.size());
			//return removecta();
			
			return true;
		}

	//cart count
		public void verifyCartCount() {
			System.out.println("Cart icon count is "+ cartCount.getText());
		}
	//Navigate to cart page
		public Cartpage clickOnCartIcon()  throws InterruptedException {
			Thread.sleep(5000);
			cartIcon.click();
			return Cartpage;
			
		}
		
		

}
