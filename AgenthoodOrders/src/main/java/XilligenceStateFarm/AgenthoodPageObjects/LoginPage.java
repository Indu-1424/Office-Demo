package XilligenceStateFarm.AgenthoodPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import XilligenceStateFarm.AgenthoodAbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	WebDriver driver;
	
	@FindBy(id="Email")
	WebElement loginEmail;
	
	@FindBy(id="Password")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loadURL() {
		driver.get("https://qa.agenthoodprogramenrollment.com/Account/SignIn");
	}

	public AgentListPage loginApplication(String email,String password,String navigation) {
		loginEmail.sendKeys(email);
		loginPassword.sendKeys(password);
		loginButton.click();
		sideNavigationAsStateFarmAgents(navigation);
		AgentListPage agentListPage= new AgentListPage(driver);
		return agentListPage;
	}

}
