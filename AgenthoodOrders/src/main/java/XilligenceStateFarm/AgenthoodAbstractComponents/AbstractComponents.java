package XilligenceStateFarm.AgenthoodAbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//Parameterized Construtor 
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//PageFactory Design for locating element
	@FindBy(xpath="//a[@data-bs-toggle='tooltip']")
	List<WebElement>navigationList;
	
	
	
	//Method gives the List of Navigation menu items
	public List<WebElement> sideNavigationItems() {
		return navigationList;
	}
	
	//method used to navigate to Navigation menu 
	public void sideNavigationAsStateFarmAgents(String navigation) {
		List<WebElement>navigationList=sideNavigationItems();
		WebElement navigationNeeded=navigationList.stream().filter(navItem->navItem.getAttribute("data-bs-title").equalsIgnoreCase(navigation)).findFirst().orElse(null);
		navigationNeeded.click();
	}
	
	public void scrollWindowFunction() {
		
		JavascriptExecutor javaScriptExecutor=(JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("window.scrollBy(0,500)");
				
	}
	
	public void waitForElementToBeClickable(WebElement findBy) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//i[@class='fa-regular fa-arrow-right']"))));
}
