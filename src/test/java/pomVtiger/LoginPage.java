package pomVtiger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(name="user_name")
	private WebElement usernametf;
	
	@FindBy(name ="user_password")
	private WebElement passwordtf;
	
	@FindBy(id="submitButton")
	private WebElement Loginbtn;

	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}

}
