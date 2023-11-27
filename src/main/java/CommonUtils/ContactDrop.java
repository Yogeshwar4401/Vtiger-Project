package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactDrop {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		final WebDriver driver;	
	    FileUtils1 utils = new FileUtils1();
	    ExcelUtils eutils = new ExcelUtils();
	    WebDriverUtils wUtils = new WebDriverUtils();
	    
	  //To read Data from properties file File
	    
		String BROWSER = utils.GetDataFromPropertyFile("browser");
		String URL = utils.GetDataFromPropertyFile("url");
		String USERNAME = utils.GetDataFromPropertyFile("username");
		String PASSWORD= utils.GetDataFromPropertyFile("password");
		
		//To read Data from Excel File
		
		String LastName = eutils.getDataFromExcelFile("Sheet1", 4, 0);
		String group = eutils.getDataFromExcelFile("Sheet1", 4, 1);

		
		if(BROWSER.equalsIgnoreCase("chrome")) {
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

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
				
		 Set<String> s = driver.getWindowHandles();

		// To control Transfer from Parent to child
		 for (String allids : s) {
	        String allurl = driver.switchTo().window(allids).getCurrentUrl();
	        System.out.println(allurl);
			}
		driver.findElement(By.name("search_text")).sendKeys("Jspider");
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//a[text()='Jspider']")).click();
		Thread.sleep(2000);

		//To Tranfer from child to parent
		Set<String> y = driver.getWindowHandles();
		 for (String allids : y) {
		       String allurl = driver.switchTo().window(allids).getCurrentUrl();
		       System.out.println(allurl);
		       	
		       String parentUrl ="http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing\r\n";
			  
		       if (allurl.contains(parentUrl)) {
				break;
			}
		 
		 }
		
		//To take the Screenshot of webpage
			TakesScreenshot ts =(TakesScreenshot)driver;
			File tempfile = ts.getScreenshotAs(OutputType.FILE);
			File destinationfile = new File("./images/vtiger.jpg");
			FileUtils.copyFile(tempfile, destinationfile);
			
			Thread.sleep(2000);
		   driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	        
	        WebElement mouse = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        wUtils.action(driver, mouse);
	        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	        
		 

	}

}
