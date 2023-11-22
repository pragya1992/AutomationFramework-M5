package practice;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Switch_Frame {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement login = driver.findElement(By.xpath("//span[text()='Sign In']"));
		Actions a = new Actions(driver);
		a.moveToElement(login).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='login']")).click();
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//label[.='Please enter your mobile number or email']")).sendKeys("9074597171");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[.='continue'])[1]")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("inputValEnter")).sendKeys("phone");
		Thread.sleep(3000);
		driver.close();
		}


	}


