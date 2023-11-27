package vtiger;

import java.io.File;


import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClassMain;
import CommonUtils.ExcelUtils;
import CommonUtils.ListenerImplimentation;
import CommonUtils.WebDriverUtils;

@Listeners(ListenerImplimentation.class)
public class Contact extends BaseClassMain {

	@Test(groups="somkesuite")	
	public void Contacts() throws InterruptedException, IOException {
	
	    ExcelUtils eutils = new ExcelUtils();
	    WebDriverUtils wUtils = new WebDriverUtils();	
		
		//To read Data from Excel File
		
		String FirstName = eutils.getDataFromExcelFile("Sheet1", 1, 3);
		String LastName = eutils.getDataFromExcelFile("Sheet1", 4, 0);
		String group = eutils.getDataFromExcelFile("Sheet1", 4, 1);

		
		// click on contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//click on contact + image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			      
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		//to click on group radio button
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		//drop down WebElement
        WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
        
        wUtils.handleDropDown(dropdown, group);
        
        driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
		 Set<String> s = driver.getWindowHandles();
		 System.out.println(s);
	     for (String st : s) {
	     driver.switchTo().window(st);
			}
		driver.findElement(By.name("search_text")).sendKeys("Jspider");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='Jspider']")).click();
		
		 Set<String> y = driver.getWindowHandles();

		 for (String st : y) {
		         driver.switchTo().window(st);
		       
				}

		
		Thread.sleep(2000);
		
		//To take the Screenshot of webpage
		TakesScreenshot ts =(TakesScreenshot)driver;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("./images/vtiger.jpg");
		FileUtils.copyFile(tempfile, destinationfile);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,900)");
		
//		WebElement choosefile = driver.findElement(By.name("imagename"));
//		wUtils.action(driver, choosefile);
//		
//		Runtime.getRuntime().exec("C:\\Users\\yoges\\OneDrive\\Desktop\\p1.exe");
//						   
         driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
        
        
       

	}

}
