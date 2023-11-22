package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactLookUpImage;
	
	//initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
		
		
	}
	//Utilization
	public WebElement getCreateContactLookUpImage() {
		return CreateContactLookUpImage;
	}
//Business library
	public void clickOnCreateContactLookUpImage() {
		CreateContactLookUpImage.click();
	}
	
}
