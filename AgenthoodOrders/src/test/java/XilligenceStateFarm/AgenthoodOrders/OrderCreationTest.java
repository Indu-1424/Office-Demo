package XilligenceStateFarm.AgenthoodOrders;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import XilligenceStateFarm.AgenthoodAbstractTestComponents.BaseTest;
import XilligenceStateFarm.AgenthoodPageObjects.AgentDetailsPage;
import XilligenceStateFarm.AgenthoodPageObjects.AgentListPage;
import XilligenceStateFarm.AgenthoodPageObjects.AgentProgramDashboardPage;
import XilligenceStateFarm.AgenthoodPageObjects.LoginPage;
import XilligenceStateFarm.AgenthoodPageObjects.VendorSelectionPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderCreationTest extends BaseTest{

	
	
		
		String email= "inair@dacgroup.com";
		String password="Sunil@1984";
		
		String navigation="State Farm Agents";
		String agentCode="35-6365";
		String expectedDashboardHeader="Program Dashboard";
		String programName="Digital Content Program";
		String BeginEnrollmentButton="Begin Enrollment";
		String continueEnrollment="Continue DAC Enrollment";
		
		
		String agentAssistLink="https://qa.agenthoodprogramenrollment.com/Agents/Impersonate/98d7656c-41ab-4dd8-813f-bcf51442225b";
	
		@Test
		public void orderCreation() throws IOException {
		
			
			AgentListPage agentListPage=loginPage.loginApplication(email, password, navigation);
			agentListPage.SearchForAgentUsingAgentCode(agentCode);
			
			AgentDetailsPage agentDetails=agentListPage.selectSearchedAgent();
			AgentProgramDashboardPage agentProgramDashboardPage =agentDetails.agentAssistButtonSelection();
		
			VendorSelectionPage vendorSelectionPage=agentProgramDashboardPage.programSelectedToEnroll(programName);
			
			vendorSelectionPage.enrollmentThroughDACVendor(BeginEnrollmentButton, continueEnrollment);
			
		
		}
	
	

}
