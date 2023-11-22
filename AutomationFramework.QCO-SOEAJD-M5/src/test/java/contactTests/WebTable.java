package contactTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
@Test
	public  void verifyTable() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/");
		List<WebElement> allheaders = driver.findElements(By.xpath("//table[@id=\"customers\"]//th"));
		System.out.println(allheaders.size());
		
		Assert.assertEquals(allheaders.size(),5,"Column count is not satisfying");
		
		boolean Status=false;
		for(WebElement ele:allheaders)
		{
			 String value = ele.getText();
			 System.out.println(value);
			 if(value.contains("Tools")) {
				Status=true;
				break;
				 }
			}
		 Assert.assertTrue(Status,"Not contail this table in DB");
		 System.out.println("===================================================");
		 
		 List<WebElement> noofRows = driver.findElements(By.xpath("//table[@id=\"customers\"]//tr"));
System.out.println("noofRows");
Assert.assertEquals(noofRows,7,"No of rows are matching");

System.out.println("================================");
List<WebElement> data = driver.findElements(By.xpath("//table[@id=\"customers\"]//td"));
boolean dataStatus=false;
for(WebElement ele:data)
{
	 String value = ele.getText();
	 System.out.println(value);
	 if(value.contains("ola")) {
		Status=true;
		break;
		 }
	}
 Assert.assertTrue(Status,"Not contain ");
	}

}
