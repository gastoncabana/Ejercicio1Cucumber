package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.DriverFactory;

public class MainPage extends DriverFactory {

	public WebDriver driver;

	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	private WebElement iconWaffleBtn;

	@FindBy(xpath = "//div[@class='al-menu-dropdown-list']/ one-app-launcher-menu-item[1]")
	private WebElement iconWaffleBtnService;


	//one-app-nav-bar-item-root[4]
	public MainPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getIconWaffle() {
		return iconWaffleBtn;
	}
	
	public WebElement geticonWaffleBtnService() {
		return iconWaffleBtnService;
	}
	


	
}
