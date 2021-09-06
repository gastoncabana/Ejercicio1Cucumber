package testNGClasses;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.NavPage;
import resources.DriverFactory;

public class AccountTab extends DriverFactory {

	@BeforeMethod
	public void driver() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@BeforeMethod
	public void login() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.salesforce();
		lp.login();
		clickWaffle();

	}

	@Test(priority = 2)
	public void parte2() throws Exception {

		navigate();
		fillInputAccountInfo();
		fillComboAccountInfo();
		scrollDown();
		fillAddressInformationInputs();
		fillAdditionalAddressInformation();
		fillAdditionalAddressInformationCombo();
		selectCalendar();
		create();
	}

	@Test(priority = 3)
	public void parte3() throws InterruptedException {
		navigate();
		check();
	}

	@Test(priority = 5)
	public void parte5() throws InterruptedException {
		onlyNavigateToAccount();
		arrow();
		changeOptions();
		verifyChange();
	}

	 @Test (priority=6)
	public void parte6() throws InterruptedException {
		onlyNavigateToAccount();
		arrow();
		changeEmployees();
		savesErrorMsg();
	}

	// Parte 2

	public void navigate() throws InterruptedException {

		// Va a acounts y hace click en new
		NavPage np = new NavPage(driver);
		np.getAccounts().click();
		np.getNewBtn().click();

	}

	public void clickWaffle() throws Exception {

		MainPage mp = new MainPage(driver);
		wait.until(ExpectedConditions.visibilityOf(mp.getIconWaffle()));
		mp.getIconWaffle().click();
		wait.until(ExpectedConditions.visibilityOf(mp.geticonWaffleBtnService()));
		mp.geticonWaffleBtnService().click();

	}

	public void fillInputAccountInfo() {
		AccountPage ap = new AccountPage(driver);

		String[] lblNames = ap.getAccountInfoLblNames();
		String[] lblNamesComplete = ap.getAccountInfoLblNamesComplete();
		for (int i = 0; i < lblNames.length; i++) {
			WebElement input = ap.getlblName(lblNames[i]);
			input.sendKeys(lblNamesComplete[i]);
		}

	}

	public void fillComboAccountInfo() throws InterruptedException {
		AccountPage ap = new AccountPage(driver);

		String[] comboNames = ap.getAccountInfoComboNames();
		String[] comboNamesOption = ap.getAccountInfoComboNamesOption();

		for (int i = 0; i < comboNames.length; i++) {
			WebElement input = ap.getcomboName(comboNames[i]);
			input.click();
			WebElement selected = driver.findElement(By.xpath(comboNamesOption[i]));
			selected.click();

		}

	}

	public void scrollDown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.actionBody').scrollTop=5000");
	}

	public static void fillAddressInformationInputs() throws InterruptedException {

		AccountPage ap = new AccountPage(driver);
		String[] textAreaName = ap.getAddressTextAreaName();
		String[] textAreaComplete = ap.getAddresTextAreaComplete();
		for (int i = 0; i < textAreaName.length; i++) {
			WebElement input = ap.getTextAreaName(textAreaName[i]);
			input.sendKeys(textAreaComplete[i]);
		}

		// Fills Lbl
		String[] lblNames = ap.getAddressInfoLblNames();
		String[] lblNamesComplete = ap.getAccountInfoLblNamesComplete();
		for (int i = 0; i < lblNames.length; i++) {

			WebElement input = ap.getlblName(lblNames[i]);
			input.sendKeys(lblNamesComplete[i]);
		}
	}

	public void fillAdditionalAddressInformation() throws InterruptedException {

		// Fill lbl
		AccountPage ap = new AccountPage(driver);
		String[] lblNames = ap.getAditionalAddressInfoLblNames();
		String[] lblNamesComplete = ap.getAditionalAddressInfoLblComplete();

		for (int i = 0; i < lblNames.length; i++) {
			WebElement input = ap.getlblName(lblNames[i]);
			input.sendKeys(lblNamesComplete[i]);
		}

	}

	public void fillAdditionalAddressInformationCombo() throws InterruptedException {
		AccountPage ap = new AccountPage(driver);

		// Fill Additional Info combos

		String[] comboNames = ap.getAditionalAddresInfoComboNames();
		String[] comboNamesOption = ap.getAditionalAddresInfoComboNamesOptions();
		for (int i = 0; i < comboNames.length; i++) {
			WebElement input = ap.getcomboName(comboNames[i]);
			input.click();
			WebElement selected = driver.findElement(By.xpath(comboNamesOption[i]));
			selected.click();

		}

	}

	public void selectCalendar() {

		String calendar = "//input[@name='SLAExpirationDate__c']";
		driver.findElement(By.xpath(calendar)).click();
		String calendarDays = "//span[@class='slds-day']"; // Path to each days TD from table shown in calendar
		List<WebElement> days = driver.findElements(By.xpath(calendarDays)); // Collect days available to click on
		days.get(30).click();
	}

	public void create() {
		AccountPage ap = new AccountPage(driver);
		ap.getSaveBtn().click();
	}

	// Parte 3

	public static void check() throws InterruptedException {

		AccountPage ap = new AccountPage(driver);

		// Find required field and sends empty keys
		String[] accountName = ap.getAccountInfoLblNames();
		WebElement input = ap.getlblName(accountName[0]);
		input.sendKeys("");
		// Clicks save btn
		ap.getSaveBtn().click();

		wait.until(ExpectedConditions.visibilityOf(ap.getContainer()));
		// Thread.sleep(3000);
		if (ap.getContainer().isDisplayed()) {
			Assert.assertTrue(false, "Faltan datos en Account Name");

		} else {
			Assert.assertTrue(true, "El error no aparece");
		}

	}

	// Parte 5

	public void onlyNavigateToAccount() throws InterruptedException {
		NavPage np = new NavPage(driver);
		np.getAccounts().click();

	}

	public void arrow() throws InterruptedException {
		AccountPage ap = new AccountPage(driver);

		ap.getArrow().click();
		ap.getEdit().click();

	}

	public void changeOptions() throws InterruptedException {

		AccountPage ap = new AccountPage(driver);

		String[] comboNames = ap.getChangeCombos();
		String[] comboNamesOption = ap.getChangeCombosOptions();

		for (int i = 0; i < comboNames.length; i++) {
			WebElement input = ap.getcomboName(comboNames[i]);
			input.click();
			WebElement selected = driver.findElement(By.xpath(comboNamesOption[i]));
			selected.click();

		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.actionBody').scrollTop=5000");

		Thread.sleep(3000);

		String[] comboLastNames = ap.getChangeLastCombos();
		String[] comboLastNamesOption = ap.getChangeLastCombosOptions();

		for (int i = 0; i < comboLastNames.length; i++) {
			WebElement input = ap.getcomboName(comboLastNames[i]);
			input.click();
			WebElement selected = driver.findElement(By.xpath(comboLastNamesOption[i]));
			selected.click();

		}
		Thread.sleep(1000);
		ap.getSaveBtn().click();

	}

	public void verifyChange() {
		AccountPage ap = new AccountPage(driver);
		// Opciones del objeto
		String typeOption = ap.getAccountInfoComboNamesOption()[0];
		String ratingOption = ap.getAccountInfoComboNamesOption()[2];
		String upsellOportunityOption = ap.getAditionalAddresInfoComboNamesOptions()[3];

		// Opciones luego de haberlas cambiado

		String typeOptionChanged = ap.getChangeCombosOptions()[0];
		String ratingOptionChanged = ap.getChangeCombosOptions()[1];
		String upsellOportunityOptionChanged = ap.getChangeLastCombosOptions()[0];

		Assert.assertNotEquals(ratingOption, ratingOptionChanged);
		Assert.assertNotEquals(upsellOportunityOption, upsellOportunityOptionChanged);

		if (typeOption != typeOptionChanged) {
			Assert.assertTrue(true);
			System.out.println("Opcion type modificada");
		} else {
			Assert.assertTrue(false);
		}

		if (ratingOption != ratingOptionChanged) {
			Assert.assertTrue(true);
			System.out.println("Opcion rating modificada");
		} else {
			Assert.assertTrue(false);
		}

		if (upsellOportunityOption != upsellOportunityOptionChanged) {
			Assert.assertTrue(true);
			System.out.println("Opcion upsell modificada");
		} else {
			Assert.assertTrue(false);
		}
	}

	// Parte 6

	public void changeEmployees() throws InterruptedException {
		AccountPage ap = new AccountPage(driver);
		WebElement input = ap.getlblName("Employees");
		input.clear();

		input.sendKeys("1431655766.");
		Thread.sleep(3000);

	}

	public void savesErrorMsg() throws InterruptedException {

		AccountPage ap = new AccountPage(driver);
		ap.getSaveBtn().click();

		String errorMsg = ap.getErrorMsg().getText();
		String expectedErrorMsg = "Employees: value outside of valid range on numeric field: 1431655766";

		Assert.assertEquals(errorMsg, expectedErrorMsg);
		
	
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
