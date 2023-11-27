package vtiger;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtils.BaseClassMain;
import CommonUtils.ExcelUtils;
import CommonUtils.JavaUtils;
import CommonUtils.WebDriverUtils;

public class Oragnization extends BaseClassMain{

	@Test
	public void Organizations() throws IOException, InterruptedException{	
		 	
		   
//		  FileUtils1 utils = new FileUtils1();
		  WebDriverUtils wUtils = new WebDriverUtils();
		  ExcelUtils eutils = new ExcelUtils();
		  JavaUtils jutils = new JavaUtils();
		 
			
		    //To read Data from Excel File
			
			String OrgName = eutils.getDataFromExcelFile("Sheet1", 1, 0);
            //String group = eutils.getDataFromExcelFile("Sheet1", 1, 1);
			String industry = eutils.getDataFromExcelFile("Sheet1", 1, 2);
			
			
			 
			 driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
			 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	           
	          driver.findElement(By.name("accountname")).sendKeys(OrgName+jutils.getRandomnumber());
	          driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	          Thread.sleep(2000);
	          WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
	       // wUtils.handleDropDown(dropdown, group);
	          wUtils.handleDropDown(dropdown, 2);
	          
	         WebElement industryDropDown = driver.findElement(By.name("industry"));
	         wUtils.handleDropDown(industryDropDown, industry);
	         
	         WebElement box = driver.findElement(By.name("notify_owner"));
	         wUtils.action(driver, box);
             driver.findElement(By.xpath("//input[@name='button']")).click();
	         Thread.sleep(2000);

	        	      
	}

}
