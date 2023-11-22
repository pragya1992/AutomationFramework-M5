package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateMultipleContact_Using_DataProvider extends BaseClass {
	

	@Test(dataProvider = "getData")
	public void createMultipleContact(String LASTNAME) throws IOException, InterruptedException {
		
		//String Lastname to get the data

		

		// Step 4: Navigate to Contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLNK();

		// Step 5: Click on create contact look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImage();

		// Step 6: create new Contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);

		// Step 7: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactheader = cip.getContactHeader();
		
		//validation with Hard Assert
		Assert.assertTrue(contactheader.contains(LASTNAME));
		
			System.out.println(contactheader);
		
		

		
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleDataFromExcel("CreateMultipleContacts");
	}
}


