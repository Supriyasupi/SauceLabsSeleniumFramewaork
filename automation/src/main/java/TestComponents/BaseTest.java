package TestComponents;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import automation.Cartpage;
import automation.Checkoutpage;
import automation.Finishpage;
import automation.Homepage;
import automation.Overviewpage;
import automation.Productspage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Homepage HomePage;
	public Productspage ProductsPage;
	public Cartpage CartPage;
	public Checkoutpage CheckoutPage;
	public Overviewpage OverviewPage;
	public Finishpage FinishPage;
	
	public static FileReader fr;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		
		//FileInputStream fis = new FileInputStream(System.getProperty(("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties"));
		//prop.load(fis);
		FileReader fr = new FileReader("C:\\Users\\supri\\eclipse\\WebsiteTesting\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fr);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			//Firefox
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		}
	
	public Homepage launchWeb() throws IOException, InterruptedException {
		driver = initializeDriver();
		HomePage = new Homepage(driver);
		HomePage.url();
		HomePage.clickLogin();
		ProductsPage = new Productspage(driver);
		CartPage = new Cartpage(driver);
		CheckoutPage = new Checkoutpage(driver);
		OverviewPage = new Overviewpage(driver);
		FinishPage = new Finishpage(driver);
		return HomePage;
	}
	
	
}
