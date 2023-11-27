package CommonUtils;


import java.io.IOException;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class BaseClassMain {

	public static WebDriver sdriver;


	public WebDriver driver;	

	
	  FileUtils1 futils = new FileUtils1();
	  WebDriverUtils wUtils = new WebDriverUtils();
	  ExcelUtils eutils = new ExcelUtils();
	  JavaUtils jutils = new JavaUtils();
	 
		@BeforeSuite
		public void BSconfig()throws IOException {
			//System.out.println("connect to data base");
			Reporter.log("**connect to data base**",true);
		}
		
//		@Parameters("BROWSER")
//		@BeforeTest
		@BeforeClass
		public void BCconfig() throws IOException{ 
		String BROWSER = futils.GetDataFromPropertyFile("browser");
		String URL = futils.GetDataFromPropertyFile("url");
		
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
			sdriver= driver;
        }
		
	    @BeforeMethod
	    public void BMconfig() throws IOException 
	    {
	        String USERNAME = futils.GetDataFromPropertyFile("username");
	        String PASSWORD = futils.GetDataFromPropertyFile("password");
	   
		//login to application
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
	    }
	    
//	    @Parameters("BROWSER")
//	    @AfterTest
		 @AfterMethod
		 public void AMconfig() {

	     WebElement mouse = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	     wUtils.action(driver, mouse);
	     driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	         
		    }
		
		@AfterClass
		public void ACconfig(){
		driver.quit();
		
			}

		@AfterSuite
		public void ASconfig()throws IOException {
			Reporter.log("Disconnect to data base",true);
		   }
}
