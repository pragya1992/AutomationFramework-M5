package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario2withTemplates {

	public static void main(String[] args) {
		ExcelFileUtility eUtile=new ExcelFileUtility();
		JavaUtility jUtile=new JavaUtility();
		PropertyFileUtility pUtile=new PropertyFileUtility();
		WebDriverUtility wUtile=new WebDriverUtility();
		
		String BROWSER=pUtile.readDataFromPropertyFile("browser");
		String URL=pUtile.readDataFromPropertyFile("url");
		String USERNAME=pUtile.readDataFromPropertyFile("username");
		String PASSWORD=pUtile.readDataFromPropertyFile("password");
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		
		JavaUtility jUtil = new JavaUtility();
		

		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
		
		String t1 = driver.getTitle();
		System.out.println(t1);
		
		if (t1.contains("Home")) {
			System.out.println("pass");}
			else {
				System.out.println("fail");
			}
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
			
			driver.findElement(By.name("lastname")).sendKeys("jain");
			
			driver.findElement(By.name("button")).click();
			
			driver.navigate().back();
			String mainWindow = driver.getWindowHandle();
			
			driver.findElement(By.xpath("//img[@alt='Select']")).click();
			
			String ct=driver.getWindowHandle();
			System.out.println(ct);
			
			driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
			
			driver.findElement(By.name("search")).click();
			
			driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
			
	//driver.findElement(By.name("search")).click();
			driver.switchTo().window(mainWindow);
			
			
			
			

				
		}
		
		
		
		
		

	}




	}

}
