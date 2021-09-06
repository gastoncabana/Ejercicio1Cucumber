package testNGClasses;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.ContactPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import resources.DriverFactory;

public class ContactTab extends DriverFactory {

	static Set<String> windows = null;

	static Iterator<String> it = null;

	static String parentId = "";

	static String childId = "";

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

	@Test
	public void parte4() throws Exception {
		clickWaffle();
		switchTab();
		clickService();
		fillInputContactInfo();
		selectAccountName();
		fillComboContactInfo();
		scrollDown();
		fillAddressInformationInputs();
		fillAdditionalAddressInformation();
		fillAdditionalAddressInformationCombo();
		create();
		returnHomePage();
		close();
		
	}

	// Methods
	public void clickWaffle() throws Exception {

		MainPage mp = new MainPage(driver);
		wait.until(ExpectedConditions.visibilityOf(mp.getIconWaffle()));
		mp.getIconWaffle().click();
		wait.until(ExpectedConditions.visibilityOf(mp.geticonWaffleBtnService()));
		mp.geticonWaffleBtnService().click();

	}

	public void clickService() throws InterruptedException {

		ContactPage cp = new ContactPage(driver);
		wait.until(ExpectedConditions.visibilityOf(cp.getContact()));
		cp.getContact().click();
		wait.until(ExpectedConditions.visibilityOf(cp.getnewBtn()));
		cp.getnewBtn().click();

	}

	public void switchTab() {

		WebElement ContactLink = driver.findElement(By.xpath("//*[@data-id='Contact']/a"));

		ContactLink.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

		windows = driver.getWindowHandles();

		it = windows.iterator();

		parentId = it.next();

		childId = it.next();

		driver.switchTo().window(childId);

	}

	public void fillInputContactInfo() {

		ContactPage cp = new ContactPage(driver);
		String[] lblNames = cp.getcontactInfoLbl();
		String[] lblNamesComplete = cp.getcontactInfoLblData();
		for (int i = 0; i < lblNames.length; i++) {
			WebElement input = cp.getlblName(lblNames[i]);
			input.sendKeys(lblNamesComplete[i]);
		}

		driver.findElement(By.xpath("//input[@name='Birthdate']")).sendKeys("12/11/1996");
	}

	public void fillComboContactInfo() throws InterruptedException {

		ContactPage cp = new ContactPage(driver);

		String[] comboNames = cp.getContactInfoCombo();
		String[] comboNamesOption = cp.getContactInfoComboOption();

		for (int i = 0; i < comboNames.length; i++) {
			WebElement input = cp.getComboName(comboNames[i]);
			input.click();
			WebElement selected = driver.findElement(By.xpath(comboNamesOption[i]));
			selected.click();

		}
	}

	public void selectAccountName() {
		ContactPage cp = new ContactPage(driver);
		cp.getAccountName().click();
		cp.getAccountNameOption().click();
	}

	public void scrollDown() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.actionBody').scrollTop=5000");
	}

	public void fillAddressInformationInputs() throws InterruptedException {
		ContactPage cp = new ContactPage(driver);

		// Fills textArea
		String[] textAreaName = cp.getAddressInfoTextArea();
		String[] textAreaComplete = cp.getAddresInfoTextAreaData();
		for (int i = 0; i < textAreaName.length; i++) {
			WebElement input = cp.getTextAreaName(textAreaName[i]);
			input.sendKeys(textAreaComplete[i]);
		}

		// Fill lbls

		String[] lblNames = cp.getAddressInfoLbl();
		String[] lblNamesComplete = cp.getAddressInfoLblData();
		for (int i = 0; i < lblNames.length; i++) {

			WebElement input = cp.getlblName(lblNames[i]);
			input.sendKeys(lblNamesComplete[i]);
		}
	}

	public void fillAdditionalAddressInformation() throws InterruptedException {
		ContactPage cp = new ContactPage(driver);

		String[] AdditionalInfoLbl = cp.getAdditionalInfoLbl();
		String[] completeAdditionalLbl = cp.getAdditionalInfoLblData();

		for (int i = 0; i < AdditionalInfoLbl.length; i++) {
			WebElement input = cp.getlblName(AdditionalInfoLbl[i]);
			input.sendKeys(completeAdditionalLbl[i]);

		}

		wait.until(ExpectedConditions.visibilityOf(cp.description));
		cp.description.sendKeys("New Description");
	}

	public void fillAdditionalAddressInformationCombo() throws InterruptedException {

		ContactPage cp = new ContactPage(driver);

		String[] comboNames = cp.getAdditionalInfoCombo();
		String[] comboNamesOption = cp.getAdditionalInfoComboOption();
		Thread.sleep(3000);
		for (int i = 0; i < comboNames.length; i++) {
			WebElement input = cp.getComboName(comboNames[i]);
			input.click();
			WebElement selected = driver.findElement(By.xpath(comboNamesOption[i]));
			selected.click();

		}
	}

	public  void returnHomePage() throws InterruptedException {
		Thread.sleep(1500);
		driver.switchTo().window(parentId);
		close();
	}

	public  void create() {
		AccountPage ap = new AccountPage(driver);
		ap.getSaveBtn().click();
	}

	
	public void close() {
		driver.close();
	}
}
