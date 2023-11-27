package pomVtiger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitiesPage {

	@FindBy(name ="potentialname")
	private WebElement OppTF;

	public WebElement getOppTF() {
		return OppTF;
	}
	
	@FindBy(xpath ="(//input[@name='assigntype'])[2]")
	private WebElement assignGroup;

	public WebElement getAssignGroup() {
		return assignGroup;
	}
	
	@FindBy(name ="assigned_group_id")
	private WebElement assignGroupData;

	public WebElement getAssignGroupData() {
		return assignGroupData;
	}
	
	@FindBy(name ="sales_stage")
	private WebElement saleaStages;

	public WebElement getSaleaStages() {
		return saleaStages;
	}
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement realtesToPlusBtn;

	public WebElement getRealtesToPlusBtn() {
		return realtesToPlusBtn;
	}
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement OrgTfS;

	public WebElement getOrgTfS() {
		return OrgTfS;
	}
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBtn;

	public WebElement getsearchBtn() {
		return searchBtn;
	}

	@FindBy(xpath = "//a[text()='Jspider']")
	private WebElement textOppData;

	public WebElement gettextOppData() {
		return textOppData;
	}
	
	 @FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
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

}
