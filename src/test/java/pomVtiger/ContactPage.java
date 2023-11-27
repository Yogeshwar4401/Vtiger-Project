package pomVtiger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage {
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	public WebElement getFirstName() {
		return firstName;
	}

	@FindBy(name = "lastname")
	private WebElement lastnametf;

	public WebElement getLastnametf() {
		return lastnametf;
	}
	
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement AssignedBtn;

	public WebElement getAssignedBtn() {
		return AssignedBtn;
	}
	
    @FindBy(name="assigned_group_id")
    private WebElement AssignedDropDown;

	public WebElement getAssignedDropDown() {
		return AssignedDropDown;
	}
    
	 @FindBy(xpath = "//input[@class='crmButton small save']")
	    private WebElement SaveBtn;

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Imagebtn;

	public WebElement getImagebtn() {
		return Imagebtn;
	}
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOutbtn;

	public WebElement getSignOutbtn() {
		return SignOutbtn;
	}
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement contactPlusbtn;

	public WebElement getContactPlusbtn() {
		return contactPlusbtn;
	}
	
	@FindBy(name="search_text")
	private WebElement contactsearchbtf;

	public WebElement getContactsearchbtn() {
		return contactsearchbtf;
	}
	
	@FindBy(name="search")
	private WebElement searchbtn;

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	@FindBy(xpath="//a[text()='Jspider']")
	private WebElement contacttext;


	public WebElement getContacttext() {
		return contacttext;
	}

	@FindBy(name="imagename")
	private WebElement choosetf;

	public WebElement getChoosetf() {
		return choosetf;
	}
    
}
