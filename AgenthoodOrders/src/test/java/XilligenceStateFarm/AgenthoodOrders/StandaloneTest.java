package XilligenceStateFarm.AgenthoodOrders;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	
	public static void main(String[] args) {
		
		String navigation="State Farm Agents";
		String agentCode="35-6365";
		String expectedDashboardHeader="Program Dashboard";
		String programName="Digital Content Program";
		String BeginEnrollmentButton="Begin Enrollment";
		String continueEnrollment="Continue DAC Enrollment";
		//String socialMediaSelect="Facebook";
		
		
		String agentAssistLink="https://qa.agenthoodprogramenrollment.com/Agents/Impersonate/98d7656c-41ab-4dd8-813f-bcf51442225b";
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().deleteCookieNamed("https://qa.agenthoodprogramenrollment.com");
		
		driver.get("https://qa.agenthoodprogramenrollment.com/Account/SignIn");
		driver.findElement(By.id("Email")).sendKeys("inair@dacgroup.com");
		driver.findElement(By.id("Password")).sendKeys("Sunil@1984");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> navigationList=driver.findElements(By.xpath("//a[@data-bs-toggle='tooltip']"));
		WebElement navigationNeeded=navigationList.stream().filter(navItem->navItem.getAttribute("data-bs-title").equalsIgnoreCase(navigation)).findFirst().orElse(null);
		navigationNeeded.click();
	 	//navigationList.stream().forEach(nav->System.out.println(nav.getAttribute("data-bs-title")));	
	
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[contains(@class,'text-nowrap')]//td")));
		
		//List<WebElement> agentList=driver.findElements(By.xpath("//table//td[1]"));
		
		driver.findElement(By.id("SearchCriteria_TextValue1")).sendKeys(agentCode);
		driver.findElement(By.xpath("//button[@name='IsPost']")).click();
		driver.findElement(By.xpath("//tbody//a")).click();
		
		List<WebElement>agentToolbar=driver.findElements(By.xpath("//div[@id='main-toolbar']//li"));
		//agentToolbar.stream().filter(tool->tool.findElement(By.linkText("https://qa.agenthoodprogramenrollment.com/Agents/Impersonate/98d7656c-41ab-4dd8-813f-bcf51442225b")).click());
		
			try {
				 agentToolbar.forEach(too->too.findElement(By.xpath("//div[@id='main-toolbar']//li/a")).click());
			 }catch(Exception e){
				e.printStackTrace() ;
			 }
		 
			
		 String actualDashboardHeader=driver.findElement(By.xpath("//h1[@class='content-title']")).getText();
		 System.out.println(actualDashboardHeader);
		 Assert.assertEquals(actualDashboardHeader,expectedDashboardHeader );
		 
		 List<WebElement>programList =driver.findElements(By.xpath("//div[@class='card available-program-card']"));
		 WebElement programSelection=programList.stream().filter(pro->pro.findElement(By.xpath("//h3[@class='card-title']")).getText().equalsIgnoreCase(programName)).findFirst().orElse(null);
		 
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,500)");
			 
			
			 try { 
				 Thread.sleep(1000); 
			} catch (InterruptedException e) {
			 
				e.printStackTrace();
			 }
			 
		 //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//i[@class='fa-regular fa-arrow-right']"))));
		 //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='fa-regular fa-arrow-right']")));
		
		programSelection.findElement(By.xpath("//div[@class='call-to-action']")).click();
		
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container enrollment-content']")));
	
	
		 List<WebElement> navigationButtons=driver.findElements(By.xpath("//i[contains(@class,'fa-arrow')]/parent::a"));
		 //navigationButtons.forEach(but->System.out.print(but.getText()));
		 WebElement actionButtonOnIntroduction=navigationButtons.stream().filter(but->(but.getText().equalsIgnoreCase(BeginEnrollmentButton))||(but.getText().equalsIgnoreCase(continueEnrollment))).findFirst().orElse(null);
		 js.executeScript("window.scrollBy(0,500)");
		 try { 
			 Thread.sleep(1000); 
		} catch (InterruptedException e) {
		 
			e.printStackTrace();
		 }
		
		 actionButtonOnIntroduction.click();
		 
			
			
			  js.executeScript("window.scrollBy(0,500)");
			  
			  
			 WebElement selectButton=driver.findElement(By.xpath(
			 "//button[@type='button'and@data-value='Base']"));
			  if(!selectButton.isSelected()) {
				   try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(@class,'package-selection')]"))));
				  selectButton.click();
				 }
			 
			  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			  WebElement ContinueButton=driver.findElement(By.xpath("//a[contains(@class,'continue-button')]"));
			  //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'continue-button')]"))); //
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'continue-button')]")));
			  try {
				  Thread.sleep(1000);
			  }
			  catch (InterruptedException e) {
			  
			  e.printStackTrace();
			  }
			  ContinueButton.click();
			  
			  try {
				  Thread.sleep(1000);
			  }
			  catch (InterruptedException e) {
			  
			  e.printStackTrace();
			  }
			  
			 
			  js.executeScript("window.scrollBy(0,200)");
			  List<WebElement>socialMediaPlatforms=driver.findElements(By.xpath("//div/input[@type='checkbox']"));
			  //socialMediaPlatforms.stream().filter(smp->smp.getText().equalsIgnoreCase()).findFirst().orElse(null);
			 
			  for (WebElement socialMedia : socialMediaPlatforms) {
				  
				  socialMedia.click();
							
			}
			
			  js.executeScript("window.scrollBy(0,200)");
			  
			  //Actions act=new Actions(driver); 
			  WebElement continueButtonOnSocialMedia =driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
			  wait.until(ExpectedConditions.elementToBeClickable(continueButtonOnSocialMedia));
			  //act.moveToElement(continueButtonOnSocialMedia).click();
			 //js.executeScript("document.getElementById('{continueButtonOnSocialMedia}').click()");
			  try {
				  Thread.sleep(1000);
			  }
			  catch (InterruptedException e) {
			  
			  e.printStackTrace();
			  }
			  continueButtonOnSocialMedia.click();
			 
			  String actualPageInfo="Payment Information";
			  String pageInfo=driver.findElement(By.xpath("//h2[contains(text(),'Payment Information')]")).getText();
			 Assert.assertEquals(pageInfo, actualPageInfo);
			 System.out.println(pageInfo);
			  js.executeScript("window.scrollBy(0,500)");
			  
			  //List<WebElement>paymentOptionList=driver.findElements(By.xpath("//div[contains(@class,'payment-options')]/div"));
			 //WebElement paymentOption=paymentOptionList.stream().filter(p->p.findElement(By.xpath("//input[@value='Monthly']/following-sibling::label")).getText().equalsIgnoreCase("6 Monthly Payments")).findFirst().orElse(null);
			 //paymentOption.click();
			  //driver.findElement(By.xpath("//div[contains(@class,'form-check')]/input[@value='Monthly']")).click();
	
			 //js.executeScript("window.scrollBy(0,200)");
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 driver.findElement(By.xpath("//button[@data-bs-target='#add-payment-method-modal']")).click();
			 String iFrameName="__privateStripeFrame0826";
			 Boolean defaultPayment=driver.findElement(By.xpath("//input[@id='payment-method-type-card']")).isSelected();
			Assert.assertTrue(defaultPayment);
			 System.out.println(defaultPayment);
			 driver.switchTo().frame("__privateStripeFrame0826");
			
			 driver.findElement(By.xpath("//span[@class='CardField-number CardField-child']//input")).sendKeys("4242424242424242");
			 
	
	}
	
	

}
