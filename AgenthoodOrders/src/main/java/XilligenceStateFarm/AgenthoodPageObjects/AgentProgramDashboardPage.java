package XilligenceStateFarm.AgenthoodPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import XilligenceStateFarm.AgenthoodAbstractComponents.AbstractComponents;

public class AgentProgramDashboardPage extends AbstractComponents{
	
	public WebDriver driver;
	
	public AgentProgramDashboardPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='card available-program-card']")
	WebElement DashboardHeaderText;
	
	@FindBy(xpath="//div[@class='card available-program-card']")
	List<WebElement> availableProgramList; 
	
	@FindBy(xpath="//div[@class='call-to-action']")
	WebElement enrollmentButtonToBeClickable;
	
	
	By requiredProgramForEnrollment=By.xpath("//h3[@class='card-title']");
	By enrollmentButton=By.xpath("//div[@class='call-to-action']");
	
	public List<WebElement> availableProgramsToEnroll() {
		return availableProgramList;
	}
	
	public VendorSelectionPage programSelectedToEnroll(String programName) {
		WebElement selectDCPProgram=availableProgramsToEnroll().stream().filter(pro->pro.findElement(requiredProgramForEnrollment).getText().equalsIgnoreCase(programName)).findFirst().orElse(null);
		scrollWindowFunction();
		waitForElementToBeClickable(enrollmentButtonToBeClickable);
		selectDCPProgram.findElement(enrollmentButton).click();
		return new VendorSelectionPage( driver);
	}
			
	
	//String actualDashboardHeader=driver.findElement(By.xpath("//h1[@class='content-title']")).getText();
	// System.out.println(actualDashboardHeader);
	 //Assert.assertEquals(actualDashboardHeader,expectedDashboardHeader );
	 
	 //List<WebElement>programList =driver.findElements(By.xpath("//div[@class='card available-program-card']"));
	 //WebElement programSelection=programList.stream().filter(pro->pro.findElement(By.xpath("//h3[@class='card-title']")).getText().equalsIgnoreCase(programName)).findFirst().orElse(null);
	 // programSelection.findElement(By.xpath("//div[@class='call-to-action']")).click();

}
