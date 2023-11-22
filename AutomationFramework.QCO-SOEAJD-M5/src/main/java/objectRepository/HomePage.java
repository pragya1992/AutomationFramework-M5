package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	
	@FindBy(linkText="Products")
	private WebElement productLnk;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorimg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getAdministratorimg() {
		return administratorimg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	//Business library
	public void clickOnOrgLNK() 
	{
		organizationLnk.click();
	}
	
	public void clickOncontactLnk(WebDriver driver) 
	{
		contactLnk.click();
	}
	
	

	public void logoutOfApp(WebDriver driver) {
		mouseHoverAction(driver,administratorimg);
		signoutLnk.click();
		
		
	}

	
	

}
