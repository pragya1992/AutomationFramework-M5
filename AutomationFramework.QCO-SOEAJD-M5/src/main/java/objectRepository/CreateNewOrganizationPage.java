package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
@FindBy(name="accountname")
private WebElement OrgNameEdt;

@FindBy(name="industry")
private WebElement IndustryDropDown;

@FindBy(name="accounttype")
private WebElement typeDropDown;

@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
private WebElement SaveBtn;

public CreateNewOrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getOrgNameEdt() {
	return OrgNameEdt;
}

public WebElement getIndustryDropDown() {
	return IndustryDropDown;
}

public WebElement getTypeDropDown() {
	return typeDropDown;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}
//Business Library
public void CreateNewOrganizationPage(String ORGNAME) {
	OrgNameEdt.sendKeys(ORGNAME);
	SaveBtn.click();
	
}
public void CreateNewOrganizationPage(String ORGNAME,String INDUSTRYNAME) {
	OrgNameEdt.sendKeys(ORGNAME);
	handleDropdown(IndustryDropDown,INDUSTRYNAME);
	SaveBtn.click();
}
}
