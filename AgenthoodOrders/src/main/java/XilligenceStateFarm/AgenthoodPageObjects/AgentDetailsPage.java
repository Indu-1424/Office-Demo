package XilligenceStateFarm.AgenthoodPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import XilligenceStateFarm.AgenthoodAbstractComponents.AbstractComponents;

public class AgentDetailsPage extends AbstractComponents {
	
	public WebDriver driver;
	
	public AgentDetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='main-toolbar']//li")
	List<WebElement>agentPageToolBarItems; 
	
		
	By agentPageAgentAssistButton=By.xpath("//div[@id='main-toolbar']//li/a");
	
	
	public List<WebElement> agentDetailsPageToolbarList() {
		
		return agentPageToolBarItems;
	}
	
	public AgentProgramDashboardPage agentAssistButtonSelection() {
		try {
			agentPageToolBarItems.forEach(too->too.findElement(agentPageAgentAssistButton).click());
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return new AgentProgramDashboardPage(driver);
		
	}
	
	

}
