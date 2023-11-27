package vtiger;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.ExcelUtils;
import CommonUtils.FileUtils1;
import CommonUtils.WebDriverUtils;
import pomVtiger.ContactPage;
import pomVtiger.HomePage;
import pomVtiger.LoginPage;

public class BaseClass {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		
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
		
		String OrgName = eutils.getDataFromExcelFile("Sheet1", 1, 0);
		String group = eutils.getDataFromExcelFile("Sheet1", 1, 1);
//		String industry = eutils.getDataFromExcelFile("Sheet1", 1, 2);
		String FirstName = eutils.getDataFromExcelFile("Sheet1", 1, 3);
		String LastName = eutils.getDataFromExcelFile("Sheet1", 4, 0);

		
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}else {
		      driver=new FirefoxDriver();
		}
		driver.get(URL);
		wUtils.maximize(driver);
		wUtils.implicitwait(driver);
		
		LoginPage lp = new LoginPage();
		PageFactory.initElements(driver, lp);
		lp.getUsernametf().sendKeys(USERNAME);
		lp.getPasswordtf().sendKeys(PASSWORD);
		lp.getLoginbtn().click();
		
		HomePage hp = new HomePage();
		PageFactory.initElements(driver, hp);
		hp.getContacttext().click();
		hp.getContactlink().click();
		
//		OrangenizationPage orgp =new OrangenizationPage();
//		PageFactory.initElements(driver, orgp);
//		orgp.getOrangenization().sendKeys(OrgName);
//		orgp.getAssignedBtn().click();
//		
//		wUtils.handleDropDown(orgp.getAssigned(), group);
//      orgp.getSavebtn().click();
//        
//      wUtils.action(driver, orgp.getImagebtn());
        
		
		ContactPage cont = new ContactPage();
		PageFactory.initElements(driver, cont);
		cont.getFirstName().sendKeys(FirstName);
		cont.getLastnametf().sendKeys(LastName);
		
		cont.getAssignedBtn().click();
		wUtils.handleDropDown(cont.getAssignedDropDown(), group);
		
		cont.getContactPlusbtn().click();
		
		//control move to child Window
		wUtils.windows(driver);

	    cont.getContactsearchbtn().sendKeys(OrgName);
		cont.getSearchbtn().click();
	    cont.getContacttext().click();
	    Thread.sleep(2000);
		 
	    //control move to parent window
		wUtils.windows(driver);
		 
        wUtils.scrolling(driver);
        wUtils.screenShot(driver);
          
        //cont.getChoosetf().click();
         wUtils.action(driver,cont.getChoosetf());
          
  		 Runtime.getRuntime().exec("C:\\Users\\yoges\\OneDrive\\Desktop\\p1.exe");
  		

		 cont.getSaveBtn().click();
         cont.getImagebtn().click();
         cont.getSignOutbtn().click();
		
		
	}

}
