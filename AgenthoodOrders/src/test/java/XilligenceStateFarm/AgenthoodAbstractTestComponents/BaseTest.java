package XilligenceStateFarm.AgenthoodAbstractTestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import XilligenceStateFarm.AgenthoodPageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginPage;
	
	public WebDriver initializeDriver() throws IOException {
		//
		Properties properties=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//XilligenceStateFarm//AgenthoodResources//GlobalData.properties");
		properties.load(fis);
		
		String browserName=properties.getProperty("browser");
				
		if(browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
				
		}else if(browserName.contains("edge")) {
			//code to initialize edge driver
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
	@BeforeTest
	public LoginPage launchApplication() throws IOException {
		driver=initializeDriver();	
	    loginPage= new LoginPage(driver);
		loginPage.loadURL();
		
		return loginPage;
	}

}
