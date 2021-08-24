package testNGClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.DriverFactory;

public class AccountTab extends DriverFactory {

	@BeforeTest
	public void driver() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@BeforeTest
	public void login() {
		driver.findElement(By.xpath(prop.getProperty("userBtn"))).sendKeys(prop.getProperty("user"));
		driver.findElement(By.xpath(prop.getProperty("passBtn"))).sendKeys(prop.getProperty("pass"));
		driver.findElement(By.xpath(prop.getProperty("loginBtn"))).click();
	}

	/*@Test(priority = 2)
	public void parte2() throws InterruptedException {
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

	@Test(priority=5)
	public void parte5() throws InterruptedException {
		onlyNavigateToAccount();
		arrow();
		changeOptions();
		verifyChange();
	}
	*/
	@Test (priority=6)
	public void parte6() throws InterruptedException {
		onlyNavigateToAccount();
		arrow();
		changeEmployees();
		savesErrorMsg();
	}

	// Parte 2

	public void navigate() throws InterruptedException {

		WebElement iconwaflebtn = driver.findElement(By.xpath(prop.getProperty("iconWafleBtn")));
		wait.until(ExpectedConditions.visibilityOf(iconwaflebtn));
		iconwaflebtn.click();

		WebElement iconWafleServiceBtn = driver.findElement(By.xpath(prop.getProperty("iconWafleServiceBtn")));// Changing
		wait.until(ExpectedConditions.visibilityOf(iconWafleServiceBtn));
		iconWafleServiceBtn.click();

		WebElement account = driver.findElement(By.xpath("//one-app-nav-bar-item-root[3]"));
		wait.until(ExpectedConditions.visibilityOf(account));
		account.click();

		WebElement newBtn = driver.findElement(By.xpath(prop.getProperty("newBtn")));
		wait.until(ExpectedConditions.visibilityOf(newBtn));
		newBtn.click();

	}

	// @Test(priority = 2)
	public void fillInputAccountInfo() {

		String AccountInfoLbl[] = { "Account Name", "Account Number", "Account Site", "Annual Revenue", "Phone", "Fax",
				"Website", "Ticker Symbol", "Employees", "SIC Code", };
		String CompleteAccount[] = { "Subcuenta de Gaston", "7149", "www.Gaston.com", "25000", "098356081", "20291232",
				"ww.google.com", "Sarasa", "2500", "2000", };
		for (int i = 0; i < AccountInfoLbl.length; i++) {

			WebElement input = driver.findElement(By
					.xpath("//label[text()='" + AccountInfoLbl[i] + "']//parent::lightning-input//descendant::input"));
			input.sendKeys(CompleteAccount[i]);
		}
	}

	// @Test(priority = 3)
	public void fillComboAccountInfo() throws InterruptedException {

		String AccountInfoCombo[] = { "Type", "Industry", "Rating", "Ownership" };
		String SelectAccountOption[] = { "//lightning-base-combobox-item [7]", "//lightning-base-combobox-item [10]",
				"//lightning-base-combobox-item [3]",
				"(//force-record-layout-item) [12]//lightning-base-combobox-item [2]" };

		for (int i = 0; i < AccountInfoCombo.length; i++) {

			WebElement input = driver.findElement(By.xpath(
					"//label[text()='" + AccountInfoCombo[i] + "']//parent::lightning-combobox//descendant::input"));
			input.click();
			// Thread.sleep(1000L);
			WebElement selected = driver.findElement(By.xpath(SelectAccountOption[i]));
			selected.click();
		}
	}

	// @Test(priority = 4)
	public void scrollDown() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		// Thread.sleep(1000);
		js.executeScript("document.querySelector('.actionBody').scrollTop=5000");
	}

	// @Test(priority = 5)
	public static void fillAddressInformationInputs() throws InterruptedException {

		// Fills textarea
		String AddressInfoTextArea[] = { "Billing Street", "Shipping Street" };
		String AddresTextAreaComplete[] = { "25 De Agosto", "30 de Agosto" };
		for (int i = 0; i < AddressInfoTextArea.length; i++) {

			WebElement input = driver.findElement(By.xpath("//label[text()='" + AddressInfoTextArea[i]
					+ "']//parent::lightning-textarea//descendant::textarea"));

			input.sendKeys(AddresTextAreaComplete[i]);
			// Thread.sleep(1000l);
		}

		// Fills Lbl
		String AddressInfoLbl[] = { "Billing City", "Billing State/Province", "Billing Zip/Postal Code",
				"Billing Country", "Shipping City", "Shipping State/Province", "Shipping Zip/Postal Code",
				"Shipping Country" };
		String completeAddress[] = { "Maldonado", "Maldonado", "20000", "Uruguay", "Maldonado", "Maldonado", "20000",
				"Uruguay" };
		for (int i = 0; i < AddressInfoLbl.length; i++) {

			WebElement input = driver.findElement(By
					.xpath("//label[text()='" + AddressInfoLbl[i] + "']//parent::lightning-input//descendant::input"));
			input.sendKeys(completeAddress[i]);

			// Thread.sleep(1000L);
		}
	}

	// @Test(priority = 6)
	public void fillAdditionalAddressInformation() throws InterruptedException {

		// Fill lbl
		String AdditionalInfoLbl[] = { "Number of Locations", "SLA Serial Number", };
		String completeAdditionalLbl[] = { "2", "1029231123" };
		for (int i = 0; i < AdditionalInfoLbl.length; i++) {

			WebElement input = driver.findElement(By.xpath(
					"//label[text()='" + AdditionalInfoLbl[i] + "']//parent::lightning-input//descendant::input"));
			input.sendKeys(completeAdditionalLbl[i]);
			// Thread.sleep(1000L);
		}

		String description = "//label[text()='Description']//parent::lightning-textarea//descendant::textarea";
		driver.findElement(By.xpath(description)).sendKeys("New Description");
	}

	// @Test(priority = 7)
	public void fillAdditionalAddressInformationCombo() throws InterruptedException {

		String AdditionalInfoCombo[] = { "Customer Priority", "Active", "SLA", "Upsell Opportunity" };
		String SelectAdditionalOption[] = { "(//force-record-layout-item) [19] //lightning-base-combobox-item[2]",
				"(//force-record-layout-item) [25] //lightning-base-combobox-item[2]",
				"(//force-record-layout-item) [20] //lightning-base-combobox-item[2]",
				"(//force-record-layout-item) [24] //lightning-base-combobox-item[2]" };

		for (int i = 0; i < AdditionalInfoCombo.length; i++) {

			WebElement input = driver.findElement(By.xpath(
					"//label[text()='" + AdditionalInfoCombo[i] + "']//parent::lightning-combobox//descendant::input"));
			input.click();
			// Thread.sleep(1000);
			WebElement selected = driver.findElement(By.xpath(SelectAdditionalOption[i]));
			selected.click();

		}
	}

	// @Test(priority = 8)
	public void selectCalendar() {

		String calendar = "//input[@name='SLAExpirationDate__c']";
		driver.findElement(By.xpath(calendar)).click();
		String calendarDays = "//span[@class='slds-day']"; // Path to each days TD from table shown in calendar
		List<WebElement> days = driver.findElements(By.xpath(calendarDays)); // Collect days available to click on
		days.get(30).click();
	}

	// @Test(priority = 9)
	public void create() {
		String save = "//button[@name='SaveEdit']";
		driver.findElement(By.xpath(save)).click();
	}

	// Parte 3

	public static void check() throws InterruptedException {

		String accountName = "//label[text()='Account Name']//parent::lightning-input//descendant::input";
		driver.findElement(By.xpath(accountName)).sendKeys("");

		String save = "//button[@name='SaveEdit']";
		driver.findElement(By.xpath(save)).click();

		String container = "//div[@class='container']";
		Thread.sleep(1000);

		// SoftAssert softassert = new SoftAssert();

		if (driver.findElement(By.xpath(container)).isDisplayed()) {

			Assert.assertTrue(false, "Faltan datos en Account Name");

		} else {
			Assert.assertTrue(true, "El error no aparece");
		}

	}

	// Parte 5

	public void onlyNavigateToAccount() throws InterruptedException {

		WebElement iconwaflebtn = driver.findElement(By.xpath(prop.getProperty("iconWafleBtn")));
		wait.until(ExpectedConditions.visibilityOf(iconwaflebtn));
		iconwaflebtn.click();

		WebElement iconWafleServiceBtn = driver.findElement(By.xpath(prop.getProperty("iconWafleServiceBtn")));// Changing
		wait.until(ExpectedConditions.visibilityOf(iconWafleServiceBtn));
		iconWafleServiceBtn.click();

		WebElement account = driver.findElement(By.xpath("//one-app-nav-bar-item-root[3]"));
		wait.until(ExpectedConditions.visibilityOf(account));
		account.click();
	}

	public void arrow() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop.getProperty("iconWafleBtn")))));
		driver.findElement(By.xpath(prop.getProperty("iconWafleBtn"))).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop.getProperty("arrow")))));
		driver.findElement(By.xpath(prop.getProperty("arrow"))).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop.getProperty("edit")))));
		driver.findElement(By.xpath(prop.getProperty("edit"))).click();

	}

	public void changeOptions() {

		String comboNames[] = { "Type", "Rating" };
		String changeCombosOptions[] = { "//lightning-base-combobox-item [5]", "//lightning-base-combobox-item [2]" };

		for (int i = 0; i < comboNames.length; i++) {
			WebElement input = driver.findElement(
					By.xpath("//label[text()='" + comboNames[i] + "']//parent::lightning-combobox//descendant::input"));
			input.click();
			WebElement selected = driver.findElement(By.xpath(changeCombosOptions[i]));
			selected.click();

		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.actionBody').scrollTop=5000");

		String[] comboLastNames = { "Upsell Opportunity" };
		String comboLastNamesOption[] = { "(//force-record-layout-item) [24] //lightning-base-combobox-item[3]" };

		for (int i = 0; i < comboLastNames.length; i++) {
			WebElement input = driver.findElement(By.xpath(
					"//label[text()='" + comboLastNames[i] + "']//parent::lightning-combobox//descendant::input"));
			input.click();
			WebElement selected = driver.findElement(By.xpath(comboLastNamesOption[i]));
			selected.click();

		}

		driver.findElement(By.xpath(prop.getProperty("save"))).click();

	}

	public void verifyChange() {
		// Opciones del objeto
		String typeOption = "//lightning-base-combobox-item [7]";
		String ratingOption = "//lightning-base-combobox-item [3]";
		String upsellOportunityOption = "(//force-record-layout-item) [24] //lightning-base-combobox-item[2]";

		// Opciones luego de haberlas cambiado

		String typeOptionChanged = "//lightning-base-combobox-item [5]";
		String ratingOptionChanged = "//lightning-base-combobox-item [2]";
		String upsellOportunityOptionChanged = "(//force-record-layout-item) [24] //lightning-base-combobox-item[3]";

		Assert.assertNotEquals(typeOption, typeOptionChanged);
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
	
	
	//Parte 6
	
	public void changeEmployees()  {
		WebElement emp = driver.findElement(By.xpath(prop.getProperty("employees")));
		emp.clear();
		emp.sendKeys("1431655766.");
		
	}

	public void savesErrorMsg() throws InterruptedException {
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop.getProperty("save")))));
		driver.findElement(By.xpath(prop.getProperty("save"))).click();
		
	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop.getProperty("errorMsg")))));
		String errorMsg = driver.findElement(By.xpath(prop.getProperty("errorMsg"))).getText();
		
		String expectedErrorMsg = "Employees: value outside of valid range on numeric field: 1431655766";
		
		Assert.assertEquals(errorMsg, expectedErrorMsg);
	}
	@AfterClass
	public void close() {
		driver.close();
	}
}
