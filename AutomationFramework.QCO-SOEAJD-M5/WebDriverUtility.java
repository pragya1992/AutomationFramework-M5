package genericUtility;


import java.io.File;
import java.util.Set;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * this class consist of all genric method related to webdriver actions
	 * @author Lenovo
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	public void waitforPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	}
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method handle dropdown by
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);

	}
	public void handleDropdown(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(null);
	}
	public void handleDropdown(String text,WebElement element) {
		Select sel=new Select(element);
		sel.selectByVisibleText(null);

		public void mouseHoverAction(WebDriver driver,WebElement element) 
		{
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();

		}
		
		
		public void doubleclickAction(WebDriver driver,WebElement element) {
			Actions act=new Actions(driver);
			act.doubleClick(element).perform();

		}
		/**
		 * 
		 * @param driver
		 * @param element
		 */
		public void rightclickAction(WebDriver driver,WebElement element) {
			Actions act=new Actions(driver);
			act.contextClick(element).perform();

		}
		/**
		 * 
		 * @param driver
		 * @param srcEle
		 * @param targetEle
		 */
		public void draganddropAction(WebDriver driver,WebElement srcEle,WebElement targetEle) {
			Actions act=new Actions(driver);
			act.dragAndDrop(srcEle,targetEle).perform();

		}
		/**
		 * 
		 * @param driver
		 * @param element
		 */
		public void clickAndHoldAction(WebDriver driver,WebElement element) {
			Actions act=new Actions(driver);
			act.clickAndHold(element).perform();

		}//500units
		public void scrollDownAction(WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("Window.scrollBy(0,500)","");
		}
	}
	public void scrollUpAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,-500)","");

	}

	public void scrollRightAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(500,0)","");
	}

	public void scrollLeftAction(WebDriver driver) {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(-500,0)","");

	}
	public void acceptAlert(WebDriver driver) {

		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}
	public String getAlertText(WebDriver driver) {

		String text=driver.switchTo().alert().getText();

		return text;
	}
	public void switchToFrame(WebDriver driver,int index) {

		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameOrID) {

		driver.switchTo().frame(nameOrID);
	}
	public void switchToFrame(WebDriver driver,WebElement element) {

		driver.switchTo().frame(element);
	}
	public void switchToWindow(WebDriver driver,String partialWindowTitle) {
		
		//capture all the window IDS
		Set<String> allWindowIDs = driver.getWindowHandles();//main,child,child,child
		
		//Navigate through each window ID
		for (String windowID:allWindowIDs) {
			
			//switch to each window and capture the title
			String actTitle = driver.switchTo().window(windowID).getTitle();
			
			//compare the actual title with expectedpartial window title
			if(actTitle.contains(partialWindowTitle)) {
				
				break;
			}

		}
	}
public String captureScreenshot(WebDriver driver,String screenShotName) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);//this path we can not use so copy
	
	File dst=new File(".\\ScreenShots\\"+screenShotName+".png");
	Files.copy(src, dst);
	return dst.getAbsolutePath();
	//complete path of screenshot-extent reports
	
}





}







