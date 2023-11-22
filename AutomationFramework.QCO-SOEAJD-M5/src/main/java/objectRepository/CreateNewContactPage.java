package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;//edit text
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	
	@FindBy(xpath="(//img[@title=\"Select\"])[1]")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement OrgSerchEdt;
	
	@FindBy(name="search")
	private WebElement OrgSerchBtn;
	
	//initialization
	 public CreateNewContactPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	//utilization
		 
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getOrgSerchEdt() {
		return OrgSerchEdt;
	}

	public WebElement getOrgSerchBtn() {
		return OrgSerchBtn;
	}
	
//Business Library
	/**
	 * This Method will create contact
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
	LastNameEdt.sendKeys(LASTNAME);
	SaveBtn.click();
	}
	//Overloading
	public void createNewContact(String LASTNAME,WebDriver driver,String ORGNAME) {
		LastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		OrgSerchBtn.sendKeys(ORGNAME);
		OrgSerchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver,"Contacts");
		SaveBtn.click();
		
		}
	
}
