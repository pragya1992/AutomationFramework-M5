package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v113.browser.Browser;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Scenario1WithDDTAndGU {
	public static void main(String[] args) throws IOException {
		
		//Creat obj of utility
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil= new PropertyFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		WebDriver driver=null;
		
		//STEP:1 Read all the required data
		/*Comman Data*/
		String BROWSER =pUtil.readDataFromPropertyFile("browser");
		
		
		
		
		
		
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommaData.properties");
		Properties p=new Properties();	
		p.load(fisp);
		String URL=p.getProperty("url");	
		String BROWSER=p.getProperty("browser");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		/*Test Data*/
FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\New XLSX Worksheet.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		
	String LASTNAME= wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
	
	WebDriver driver=null;
	
	//Lunch the browser -polyMorphism -Run Tmie-Driver
	if(Browser.equalsIgnoreCase("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}else if(Browser.equalsIgnoreCase("Firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new ChromeDriver();
		
	}else if(Browser.equalsIgnoreCase("Edge"))
	{
		WebDriverManager.Edgedriver().setup();
		driver=new ChromeDriver();
		
	}else("Invalid Browser");
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		wUtil.maximizeWindow(driver);
		wUtil.waitforPageLoad(driver);
		driver.get("url");
		
		
		//Step 2:Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				//Step 3:Navigate to Contact link
				driver.findElement(By.xpath("//a[.='Contacts']")).click();
				
				//Step 4:click on creatcontactlook up Image
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				
				//Step 5:create contact with mandatory fields
				driver.findElement(By.name("lastname")).sendKeys("Jain");
				
				//Step 6:save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 7: validate
				String contactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();//dont take text()=jaintake class
				System.out.println(contactHeader);
				if(contactHeader.contains("Jain"))
				{
					System.out.println(contactHeader);
					System.out.println("pass");
					
				}
				else
				{
					System.out.println("Fail");
				}
				//Step 8:Signout
				
				WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseOverAction(ele);
				//Actions a=new Actions(driver);
				//a.moveToElement(ele).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Logout Scccessfully");

	}

}



