package vtiger;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.ExcelUtils;
import CommonUtils.FileUtils1;
import CommonUtils.WebDriverUtils;

public class Opportunities {

	public static void main(String[] args) throws IOException {
	    final WebDriver driver;
	    
	    FileUtils1 utils = new FileUtils1();
		WebDriverUtils wUtils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		  
		 //To read data From Properties file
		  
		String BROWSER = utils.GetDataFromPropertyFile("browser");
		String URL = utils.GetDataFromPropertyFile("url");
		String USERNAME = utils.GetDataFromPropertyFile("username");
		String PASSWORD= utils.GetDataFromPropertyFile("password");
		
	 //To read Data from Excel File
		
		String OppName = eutils.getDataFromExcelFile("Sheet1", 7, 0);
		String groupdata = eutils.getDataFromExcelFile("Sheet1", 4, 1);
		String sales = eutils.getDataFromExcelFile("Sheet1", 7, 1);
		String OrgName = eutils.getDataFromExcelFile("Sheet1", 1, 0);

		
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}else {
		      driver=new FirefoxDriver();
		}
		
		wUtils.maximize(driver);
		wUtils.implicitwait(driver);
		
	     driver.get(URL);
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 
		 driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		 driver.findElement(By.xpath("//img[@title='Create Opportunity...']") ).click();
		 
		// Opportunity Name
		 driver.findElement(By.name("potentialname")).sendKeys(OppName);
		 
		//Assigned To
		 driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();		 
		 WebElement group = driver.findElement(By.name("assigned_group_id"));
		 wUtils.handleDropDown(group, groupdata);
		 
		// Sales Stage
		 WebElement salesStage = driver.findElement(By.name("sales_stage"));
		 wUtils.handleDropDown(salesStage, sales);

		//Related To
		 driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		 Set<String> p1 = driver.getWindowHandles();
		 for (String st : p1) {
			driver.switchTo().window(st);
		}
		 driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(OrgName);
		 driver.findElement(By.xpath("//input[@name='search']")).click();
		 driver.findElement(By.xpath("//a[text()='Jspider']")).click();
		 
		 Set<String> y = driver.getWindowHandles();

		 for (String st : y) {
		         driver.switchTo().window(st);
		       
				}

		 driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		 WebElement img = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
         wUtils.movtEle(driver, img);
         driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
         

	}

}
