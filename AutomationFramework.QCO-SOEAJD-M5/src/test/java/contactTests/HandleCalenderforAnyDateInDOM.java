package contactTests;

import java.sql.Date;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCalenderforAnyDateInDOM {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date d=new Date();
		String dateNow=d.toString();
		System.out.println(dateNow);
		String[]dArr=d.toString().split(" ");
		String currentDate=dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];
		System.out.println(currentDate);
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions a = new Actions(driver);
		//String month="December 2023";String day="1";
		
		
		
		
		//driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]")).click();
		a.moveByOffset(100, 100).click().perform();
		a.moveByOffset(500, 500).click().perform();
		driver.findElement(By.xpath("//i[@class=\"wewidgeticon we_close\"]")).click();
		a.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//label[@for=\"departure\"]")).click();
		
		
		for(;;)
		{
			try
			{
			driver.findElement(By.xpath("//div[@aria-label=\'"+currentDate+"']")).click();
			break;
			}
			catch(Exception e)
			{

				driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]")).click();
			}
		}
		
		/*WebElement value = driver.findElement(By.xpath("//div[text()='November']/span[.=2023]"));
		boolean status=false;
		if(value.equals(month)) 
		{
			status=true;
		value.click();
			
		}
		else {
			driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]"));
		}*/

	}

}
