
package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
@FindBy(xpath="//span[@class=\"lvtHeaderText\"]")//creating new contact
private WebElement ContactHeaderText;

public ContactInfoPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getContactHeaderText() {
	return ContactHeaderText;
}
//Business Library
public String getContactHeader() {
return ContactHeaderText.getText();
}}
