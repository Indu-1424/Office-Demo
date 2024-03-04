package XilligenceStateFarm.AgenthoodPageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import XilligenceStateFarm.AgenthoodAbstractComponents.AbstractComponents;

public class AgentListPage extends AbstractComponents{

	WebDriver driver;
	public AgentListPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	By presenceOfElementLocated=By.xpath("//table[contains(@class,'text-nowrap')]//td");
	
	@FindBy(id="SearchCriteria_TextValue1")
	WebElement searchTextBox;
	
	@FindBy(xpath="//button[@name='IsPost']")
	WebElement searchButton;
	
	@FindBy(xpath="//tbody//a")
	WebElement agentAssociateID;
	
	
	
	public void SearchForAgentUsingAgentCode(String agentCode) {
		searchTextBox.sendKeys(agentCode);
		searchButton.click();
		
	}
	
	public AgentDetailsPage selectSearchedAgent() {
		agentAssociateID.click();
		
		return new AgentDetailsPage(driver);
	}
	
	//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[contains(@class,'text-nowrap')]//td")));
	

	//driver.findElement(By.id("SearchCriteria_TextValue1")).sendKeys(agentCode);
	//driver.findElement(By.xpath("//button[@name='IsPost']")).click();
	//driver.findElement(By.xpath("//tbody//a")).click();

}
