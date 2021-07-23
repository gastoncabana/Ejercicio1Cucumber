package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import resources.base;
//rahulonlinetutor@gmail.com
public class LoginPage extends base{

	
	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

	public void salesforce() {
		String link = prop.getProperty("url");
		driver.get(link);
	}
	
	public void login() {
	
		driver.findElement(By.xpath(prop.getProperty("userBtn"))).sendKeys(prop.getProperty("user"));
		driver.findElement(By.xpath(prop.getProperty("passBtn"))).sendKeys(prop.getProperty("pass"));
		driver.findElement(By.xpath(prop.getProperty("loginBtn"))).click();
	}

	
	
	
	
}
