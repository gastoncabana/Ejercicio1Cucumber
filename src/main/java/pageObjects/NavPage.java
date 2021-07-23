package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import resources.base;

public class NavPage extends base {

	public WebDriver driver;

	public NavPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public void navigateBetweenTabs() throws InterruptedException{
		for (int i = 2; i < 8; i++) {
			driver.findElement(By.xpath("//one-app-nav-bar-item-root[" + i + "]")).click();
		

			if (i == 3 || i == 4) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("newBtn"))));
				driver.findElement(By.xpath(prop.getProperty("newBtn"))).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("cancel34Btn"))));
				driver.findElement(By.xpath(prop.getProperty("cancel34Btn"))).click();
			

			}

			if (i == 5) {
			
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("newBtn"))));
				//Thread.sleep(1500); //No funciona el explicit wait
				driver.findElement(By.xpath(prop.getProperty("newBtn"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("cancel5Btn"))));
				driver.findElement(By.xpath(prop.getProperty("cancel5Btn"))).click();
	


			}

			if (i == 6) {
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("newReportBtn"))));
				driver.findElement(By.xpath(prop.getProperty("newReportBtn"))).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("iframeReport"))));
				driver.switchTo().frame(driver.findElement(By.xpath(prop.getProperty("iframeReport"))));
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("iframeCancelButton"))));
				driver.findElement(By.xpath(prop.getProperty("iframeCancelButton"))).click();
				
				driver.switchTo().defaultContent();

			}
			if (i == 7) {
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("newDashboardBtn"))));
				driver.findElement(By.xpath(prop.getProperty("newDashboardBtn"))).click();
	
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("iframeDashboard"))));
				driver.switchTo().frame(driver.findElement(By.xpath(prop.getProperty("iframeDashboard")))); // fram
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("iframeCancelButton"))));
				driver.findElement(By.xpath(prop.getProperty("iframeCancelButton"))).click(); // Cancel click

				driver.switchTo().defaultContent(); // Getting out of frame

			}
		}
	}

	public void closeDriver() {
		driver.close();
	}
}
