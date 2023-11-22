package contactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactTest extends BaseClass {
	@Test
	
	public void CreateContactTest()
	{
	

	
		
		//Test Data

		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
	}
		
		//4. Navigate to contact link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactLink();
		
		//5.click on create contact look up image
		ContactPage cp=new ContactPage(driver);
		cp.clickOnCreateContactLookUpImage();
		
		//6.create new contact
		CreateNewContactPage cncp=new CreateNewContcatPage(driver);
		cncp.createNewContact(LASTNAME);
		
		//7.Validate
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactheader=cip.getContactHeader();
		Asser.asserTrue(contactheader.contains(LASTNAME));
			System.out.println(contactheader);
	
		
	}

	}


