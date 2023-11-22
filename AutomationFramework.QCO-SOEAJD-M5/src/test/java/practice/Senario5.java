package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
//How to switch parent window to child window (if in child window we have maximize minimize options) with the help of getWindowhandle(to get id of parent window)and getWindowHandles(to get IDS of Except windows)
public class Senario5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		
		
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
				
				//Step 6:click on org lookup image
				driver.findElement(By.xpath("(//img[@style=\"cursor:hand;cursor:pointer\"])[1]")).click();
				
				//Step:7 capture the main /parent window id
				 String mainwindowID=driver.getWindowHandle();//for windowID
				 
				 System.out.println("All window ids:"+ mainwindowID);
				 
				 //Step:8 capture all the window ids-main and child
				 Set<String>allwindowIDs=driver.getWindowHandles();
				 
				 System.out.println("All window ids:"+ allwindowIDs);
				 
				 //Step:9 Compare and switch to child window
				 for(String winid : allwindowIDs) {
					 if(!winid.equals(mainwindowID)){
						 driver.switchTo().window(winid);
						 break;
						 
				// Step:10 serch for orginization
						 
						// driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("Ecw");
						 driver.findElement(By.name("search_text")).sendKeys("Ecw");
						 driver.findElement(By.name("search")).click();
						 driver.findElement(By.xpath("//a[@id='1']")).click();
						 
			// Step:11 switch control back to parent
						 
						 driver.switchTo().window(mainwindowID);
			// step:12 save
						 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						 
				//step:13 validate
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
							//Step 14:Signout
							
							WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
							Actions a=new Actions(driver);
							a.moveToElement(ele).perform();
							driver.findElement(By.linkText("Sign Out")).click();
							System.out.println("Logout Scccessfully");
					
						 
					 }
				 }

	}

}
