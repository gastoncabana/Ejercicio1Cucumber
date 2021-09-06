package testNGClasses;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.NavPage;
import resources.DriverFactory;

public class ServiceTab extends DriverFactory {

	@BeforeMethod
	public void driver() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@BeforeMethod
	public void login() {
		LoginPage lp = new LoginPage(driver);
		lp.salesforce();
		lp.login();

	}


	@Test(priority = 1)
	public void parte1() throws Throwable {

		flatIcon();
		service();
		navigate();
	
	}
	

	public void flatIcon() throws Throwable {
		MainPage mp = new MainPage(driver);
		wait.until(ExpectedConditions.visibilityOf(mp.getIconWaffle()));
		mp.getIconWaffle().click();

	}
	

	public void service() throws Throwable {
		MainPage mp = new MainPage(driver);
		wait.until(ExpectedConditions.visibilityOf(mp.geticonWaffleBtnService()));
		mp.geticonWaffleBtnService().click();
	}
	

	public void navigate() throws InterruptedException {
		NavPage np = new NavPage(driver);
		int i = np.getTab().size();

		for (int x = 0; x < i; x++) {

			np.getTab().get(x).click();
			Thread.sleep(3000L);
			String pageTitle = driver.getTitle();

			if (!pageTitle.contains("Home") && !pageTitle.contains("Reports") && !pageTitle.contains("Dashboards")) {
				np.getNewBtn().click();
				wait.until(ExpectedConditions.visibilityOf(np.getcancelBtn()));
				np.getcancelBtn().click();
			}

			if (pageTitle.contains("Reports") || pageTitle.contains("Dashboard")) {
				np.getnewReportBtn().click();

				if (pageTitle.contains("Reports")) {
					driver.switchTo().frame(np.getIframe("Report Builder"));
				} else {
					driver.switchTo().frame(np.getIframe("dashboard"));
				}
				wait.until(ExpectedConditions.visibilityOf(np.getiframeCancelButton()));
				np.getiframeCancelButton().click();
				driver.switchTo().defaultContent();
			}

		}
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

	
}
