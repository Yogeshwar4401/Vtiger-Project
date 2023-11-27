package CommonUtils;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.asynchttpclient.ws.WebSocketUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SceenShot {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
	
	      driver.findElement(By.name("user_name")).sendKeys("admin");
          driver.findElement(By.name("user_password")).sendKeys("admin");
          driver.findElement(By.id("submitButton")).click();
          driver.findElement(By.xpath("//a[text()='Contacts']")).click();
          Thread.sleep(2000);
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
 		 TakesScreenshot ts =  (TakesScreenshot) driver;
 		 
 		 driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
 	        
 	     WebElement mouse = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 	        
 	     driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
 	        
   

	}

}
