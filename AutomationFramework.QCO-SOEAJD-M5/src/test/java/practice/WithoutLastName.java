package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WithoutLastName {

	public static void main(String[] args) {
  

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		String t1 = driver.getTitle();
		System.out.println(t1);
		
		if (t1.contains("Home")) {
			System.out.println("pass");}
			else {
				System.out.println("fail");
			}
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
			
			driver.findElement(By.name("lastname"));
			
			driver.findElement(By.name("button")).click();
			//alert should display
			Alert alert=driver.switchTo().alert();
			
			System.out.println(alert.getText());
			String msg = alert.getText();
			
			
			Assert.assertTrue(msg.contains("Last Name cannot be empty"));
			System.out.println("Pass");
			
			//Assert.assertequals
			
			/*if(driver.switchTo().alert().equals("Last Name cannot be empty")) {
				System.out.println("Pass");
			}else {
				System.out.println("Fail");
			}
			
			driver.switchTo().alert().accept();
			
			
	driver.findElement(By.name("lastname")).sendKeys("jain");
			
			driver.findElement(By.name("button")).click();*/
			

	}

}
