package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import resources.DriverFactory;
//rahulonlinetutor@gmail.com
public class LoginPage extends DriverFactory{

	
	public WebDriver driver;
	
	
    private String salesForcelink = "https://login.salesforce.com";
	
	@FindBy (xpath = "//input[@id='username']")
    private WebElement username;
	
	@FindBy (xpath = "//input[@id='password']")
    private WebElement password;
	
	@FindBy (xpath = "//input[@id='Login']")
    private WebElement loginBtn;

	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	public WebElement getUsername () {
        return username;
    }
	
	public WebElement getPassword () {
        return password;
    }
	
	public WebElement getLoginBtn() {
        return loginBtn;
    }


	public void salesforce() {
		
		driver.get(salesForcelink);
	}
	
	
	public void login() {
	
		username.sendKeys(prop.getProperty("user"));
		password.sendKeys(prop.getProperty("pass"));
		loginBtn.click();
	}

	
	
	
	
}
