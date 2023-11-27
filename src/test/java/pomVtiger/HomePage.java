package pomVtiger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	//  Organization
	
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement orgnation;
	
	public WebElement getUsernametf() {
		return orgnation;
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement passwordtf;


	public WebElement getPasswordtf() {
		return passwordtf;
	}
	
	//   Contact
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contacttext;

	public WebElement getContacttext() {
		return contacttext;
	}
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement contactlink;

	public WebElement getContactlink() {
		return contactlink;
	}

	//Oppertunities
	
	@FindBy(xpath = "//a[text()='Opportunities']")
    private WebElement oppText;

	public WebElement getOppText() {
		return oppText;
	}
		
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
    private WebElement oppPlusbtn;

	public WebElement getOppPlusbtn() {
		return oppPlusbtn;
	}
	
	
    
	
	
	

	
}
