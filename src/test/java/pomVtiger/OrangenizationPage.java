package pomVtiger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangenizationPage {

	
	@FindBy(name="accountname")
	private WebElement orangenization;

	public WebElement getOrangenization() {
		return orangenization;
	}
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement AssignedBtn;

	public WebElement getAssignedBtn() {
		return AssignedBtn;
	}
	
	@FindBy(name="assigned_group_id")
	private WebElement AssignedDropDown;

	public WebElement getAssigned() {
		return AssignedDropDown;
	}

	@FindBy(xpath="//input[@name='button']")
	private WebElement Savebtn;

	public WebElement getSavebtn() {
		return Savebtn;
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

	
	
	
	
	
	
	
	
	
}
