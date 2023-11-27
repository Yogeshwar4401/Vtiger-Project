package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils {

	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
    
	public void implicitwait(WebDriver driver)
	{
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		

	}
	
	public void handleDropDown(WebElement elementname, String Data)
	{       
		Select s = new Select(elementname);
        s.selectByVisibleText(Data);
     }
	
	public void handleDropDown(WebElement elementname, int indexnumber)
	{	       
		Select s = new Select(elementname);
        s.selectByIndex(indexnumber);
     }
	
	public void action(WebDriver driver , WebElement elementname)
	{	       
		Actions a = new Actions(driver);
		a.click(elementname);
		a.perform();
     }
	
	public void movtEle(WebDriver driver , WebElement elementname )
	{
		Actions a= new Actions(driver);
		a.moveToElement(elementname);
		a.perform();
	}
	
	public void doubleClick(WebDriver driver , WebElement elementname)
	{
		Actions a = new Actions(driver);
		a.doubleClick(elementname);
		a.perform();
	}
	
	public void rightClick(WebDriver driver , WebElement elementname)
	{
		Actions a = new Actions(driver);
		a.contextClick(elementname);
		a.perform();
	}
	
	public void scrolling(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,900)");
	}
	
	
	
	public void screenShot(WebDriver driver  ) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("./images/vtiger" + random() +".jpg");
		FileUtils.copyFile(tempfile, destinationfile);

		Random r = new Random();
		r.nextInt(100);
	}
	
	public int random()
	{
		Random r = new Random();
		return r.nextInt(100);
	}
	
	
	
	public void windows(WebDriver driver)
	{
		 Set<String> s = driver.getWindowHandles();
		 System.out.println(s);
		 
	        for (String st : s) {
	        String allurl = driver.switchTo().window(st).getCurrentUrl();
	        System.out.println(allurl);
			}
	}
	
	
	
	
//	public void switchWindows(WebDriver driver )
//	{
//		 Set<String> s = driver.getWindowHandles();
//		 System.out.println(s);
//		 
//	        for (String st : s) {
//	        String allurl = driver.switchTo().window(st).getCurrentUrl();
//	        System.out.println(allurl);
//	        
//	        String childurl="";
//	        if (allurl.contains(childurl)) {
//				break;
//			}
//			}
//
//	}
	
	
}