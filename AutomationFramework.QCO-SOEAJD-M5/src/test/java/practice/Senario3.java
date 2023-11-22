package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys("456");
		
		WebElement dropdown=driver.findElement(By.name("industry"));
		
		 
		Select s=new Select(dropdown);
		s.selectByIndex(4);
		s.isMultiple();
		s.getOptions();
		List<WebElement> option = s.getAllSelectedOptions();
		System.out.println(option);
		
		
		
		WebElement dropdown1=driver.findElement(By.name("accounttype"));
		Select s1=new Select(dropdown1);
		s1.selectByVisibleText("Customer");
		
		
		driver.findElement(By.name("emailoptout")).click();
		driver.findElement(By.name("assigntype")).click();
	}

}
