package saucelabs.automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import TestComponents.BaseTest;
import automation.Homepage;
import automation.Productspage;

import automation.Cartpage;
import automation.Checkoutpage;
import automation.Overviewpage;
import automation.Finishpage;


@Test(priority=1)
public class HomepageTest extends BaseTest {
	public void Homepage() throws IOException, InterruptedException {	
		Homepage HomePage = launchWeb();
	    HomePage.url();
		System.out.println(driver.getCurrentUrl());
		HomePage.enterUsername("problem_user");
		HomePage.enterPassword("secret_sauce");
		 HomePage.clickLogin();
		 
        
	}
	
	@Test(priority=2)
	public void Productspage () throws IOException, InterruptedException {
		Productspage ProductsPage = new Productspage(driver);
	//Product Page
		
        System.out.println(driver.getCurrentUrl());
        ProductsPage.clickonDropdown();
        ProductsPage.getListTitle();
        ProductsPage.countOfRemoveButton();
        ProductsPage.verifyCartCount();
       //Navigate to cart page
        CartPage = ProductsPage.clickOnCartIcon();
	}
	
	
	
	@Test(priority=3)
	//Cartpage
	public void Cartpage() throws IOException, InterruptedException {
		Cartpage CartPage = new Cartpage(driver);
        
        
        //cartpage
        System.out.println(driver.getCurrentUrl());
        CartPage.removeItem();
        CartPage.continueshopping();
        
        System.out.println("Navigated back to " + driver.getCurrentUrl() + " Removing an item in cart page successfully");
        
        ProductsPage.verifyCartCount();
        //navigate to cart page
        ProductsPage.clickOnCartIcon();
        System.out.println("Navigated back to " + driver.getCurrentUrl() + " to checkout now");
       CheckoutPage = CartPage.clickOnCheckout();
        System.out.println("Navigated to Checkout page "+ driver.getCurrentUrl());
	}
	
	
	@Test(priority=4)
	
	public void Checkoutpage() throws IOException, InterruptedException {
		Checkoutpage CheckoutPage = new Checkoutpage(driver);
		Thread.sleep(5000);
		CheckoutPage.enterFirstName("Supriya");
		CheckoutPage.enterLastName("Shivanna");
		CheckoutPage.enterPostalCode("560073");
		CheckoutPage.clickOnSubmit();
	}
	
	@Test(priority=5)
	public void Overviewpage() throws IOException, InterruptedException {
		Overviewpage OverviewPage = new Overviewpage(driver);
		OverviewPage.getTotalAmount();
		OverviewPage.finish();
	}
	
	
	
	@Test(priority=6)
	public void Finishpage() throws IOException, InterruptedException{
		Finishpage FinishPage = new Finishpage(driver);
	 System.out.println("Navigated to Finish page "+ driver.getCurrentUrl());
		 FinishPage.verifyMessage();
		//Use TakesScreenshot method to capture screenshot
		 TakesScreenshot screenshot = (TakesScreenshot)driver;
		 //Saving the screenshot in desired location
		 File source = screenshot.getScreenshotAs(OutputType.FILE);
		 //Path to the location to save screenshot
		 FileUtils.copyFile(source, new File("./SeleniumScreenshots/Screen.png"));
		 System.out.println("Screenshot is captured");
		 driver.quit();
	    
	}
			}


