package vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.ExcelUtils;
import CommonUtils.FileUtils1;
import CommonUtils.WebDriverUtils;

public class Leads {

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
	      
	      //To read Data From Excel File
	      
	      String LastName = eutils.getDataFromExcelFile("Sheet1", 4, 0);
		  String cName = eutils.getDataFromExcelFile("Sheet1", 1, 0);
		  
			
		  
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
		
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.name("company")).sendKeys(cName);
		
		WebElement lSource = driver.findElement(By.name("leadsource"));
		wUtils.handleDropDown(lSource, 4);
		
		WebElement inst = driver.findElement(By.name("industry"));
		wUtils.handleDropDown(inst, 9);

	}

	
}
