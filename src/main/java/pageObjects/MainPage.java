package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class MainPage extends base{

public WebDriver driver;

	
	public MainPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	public void waffleIcon() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("iconWafleBtn"))));
		driver.findElement(By.xpath(prop.getProperty("iconWafleBtn"))).click();
	
	}
	
	public void clickService()  {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("iconWafleServiceBtn"))));
		driver.findElement(By.xpath(prop.getProperty("iconWafleServiceBtn"))).click(); // Changing
		
	}
}
