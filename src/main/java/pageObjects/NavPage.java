package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;

import resources.DriverFactory;

public class NavPage extends DriverFactory {

	public WebDriver driver;

	
	private static final String iFramePath = "//iframe[@title='$number']";

	
	
	@FindBy(xpath = "//a[@title='New']")
	private WebElement newBtn;

	@FindBy(xpath = "//button[@name='CancelEdit' or @title='Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//div[@title='New Report' or @title='New Dashboard']")
	private WebElement newReportBtn;
	
	
	@FindBy(xpath = "//iframe[@title='Report Builder']")
	private WebElement iframeReport;
	
	@FindBy(xpath = "//iframe[@title='dashboard']")
	private WebElement iframeDashboard;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement iframeCancelButton;

	@FindBy(xpath="//one-app-nav-bar-item-root")
	private static List<WebElement> tabs;
	
	
	@FindBy(xpath="//one-app-nav-bar-item-root[3]")
	private WebElement accounts;
	
	@FindBy(xpath="//one-app-nav-bar-item-root[4]")
	private WebElement contactBtn;
	
	public NavPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getNewBtn() {
		return newBtn;
	}

	public WebElement getcancelBtn() {
		return cancelBtn;
	}
	
	public WebElement getnewReportBtn() {
		return newReportBtn;
	}
	
	public WebElement getiframeReport() {
		return iframeReport;
	}
	public WebElement getiframeDashboard() {
		return iframeDashboard;
	}
	
	public WebElement getiframeCancelButton() {
		return iframeCancelButton;
	}
	
	public WebElement getAccounts() {
		return accounts;
	}
	
	public WebElement getContacts() {
		return contactBtn;
	}
	public List<WebElement> getTab(){
		return tabs;
	}
	
	public WebElement getIframe(String args) {
		WebElement tab = driver.findElement(By.xpath(iFramePath.replace("$number",args)));
		return tab;
	}
	

}
