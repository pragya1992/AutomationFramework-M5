package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public ExcelFileUtility eUtil = new ExcelFileUtility();//Make it Public
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriver driver=null;
	
	public static WebDriver sdriver;//for try cath 
	
	@BeforeSuite(alwaysRun=true)//(groups=SmokeSuite)
	public void bsConfig()
	{
		System.out.println("====DB Connection Successful==");
		
	}
	//@Parameters("browser")//for crossBrowsertesting usually done by devops team
	//@BeforeTest// for Distribute execution
	@BeforeClass(alwaysRun=true)
	public void bcConfig(String BROWSRE) throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("Chrome"))// true f
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Firefox")) // t f
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("Edge"))// f
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("invalid Browser name");
		}
		sdriver=driver;

		wUtil.maximizeWindow(driver);
		
		wUtil.waitforPageLoad(driver);
		driver.get(URL);

	}
@BeforeMethod(alwaysRun=true)
public void bmConfig() throws IOException
{
	String USERNAME=pUtil.readDataFromPropertyFile("username");
	String PASSWORD=pUtil.readDataFromPropertyFile("password");
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME,PASSWORD);
	System.out.println("===Login Successful===");
	
}
@AfterMethod(alwaysRun=true)
public void amConfig()
{
	HomePage hp=new HomePage(driver);
	hp.logoutOfApp(driver);
	System.out.println("===Logout SucessFul===");
	
}
//@AfterTest
@AfterClass(alwaysRun=true)
public void acConfig()
{
	driver.quit();
	System.out.println("==Browser close Sucess full==");
	
}
@AfterSuite(alwaysRun=true)
public void asConfig()
{
	
	System.out.println("==DB close Sucess full==");
	
}

}
