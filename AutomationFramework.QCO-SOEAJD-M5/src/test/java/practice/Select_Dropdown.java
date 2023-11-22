package practice;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//select dropdown= driver.findElements(By.xpath("//select[@aria-describedby=\"searchDropdownDescription\"]"));
		//driver.findElement(By.id("searchDropdownBox"));
		Select s = new Select(driver.findElement(By.xpath("//select[@aria-describedby=\"searchDropdownDescription\"]")));
		Thread.sleep(5000);
		s.selectByIndex(7);
		Thread.sleep(3000);
		s.selectByValue("search-alias=deals-intl-ship");
		Thread.sleep(3000);
		s.selectByVisibleText("Digital Music");
		Thread.sleep(3000);
		// s.deselectByIndex(1);
		// Thread.sleep(3000);
		// s.deselectByValue("199");
		// Thread.sleep(3000);
		// s.deselectByVisibleText("INR 300 - INR 399 ( 1 
		//) ");
		List<WebElement> optn = s.getAllSelectedOptions();
		System.out.println(optn.size());
		s.isMultiple();
		
		for(WebElement allopt:optn)
		{
		System.out.println(allopt.getText());
		}
		Thread.sleep(3000);
		driver.close();
		}


	}


