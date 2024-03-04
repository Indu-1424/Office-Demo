package XilligenceStateFarm.AgenthoodPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import XilligenceStateFarm.AgenthoodAbstractComponents.AbstractComponents;

public class VendorSelectionPage extends AbstractComponents{
	
	WebDriver driver;
	
	public VendorSelectionPage (WebDriver driver) {
	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//i[contains(@class,'fa-arrow')]/parent::a")
	List<WebElement> EnrollmentOptionsAndBackToIntroduction;
	
	@FindBy(xpath="(//i[@class='fa-solid fa-arrow-right'])[2]")
	WebElement forwardArrowOnEnrollmentButton;
	
	
	public void enrollmentThroughDACVendor(String BeginEnrollmentButton,String continueEnrollment) {
		
		WebElement actionButtonOnDACVendorSection=EnrollmentOptionsAndBackToIntroduction.stream().filter(but->(but.getText().equalsIgnoreCase(BeginEnrollmentButton))||(but.getText().equalsIgnoreCase(continueEnrollment))).findFirst().orElse(null);
		scrollWindowFunction();
		waitForElementToBeClickable(forwardArrowOnEnrollmentButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionButtonOnDACVendorSection.click();
		
	}
	
	// List<WebElement> navigationButtons=driver.findElements(By.xpath("//i[contains(@class,'fa-arrow')]/parent::a"));

	//WebElement actionButtonOnIntroduction=navigationButtons.stream().filter(but->(but.getText().equalsIgnoreCase(BeginEnrollmentButton))||(but.getText().equalsIgnoreCase(continueEnrollment))).findFirst().orElse(null);
	
}
