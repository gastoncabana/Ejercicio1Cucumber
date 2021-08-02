package stepDefinitions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.AccountPage;
import pageObjects.ContactPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.NavPage;
import resources.DriverFactory;

@RunWith(Cucumber.class)
public class stepDefinitions extends DriverFactory {

	Set<String> windows = null;

	Iterator<String> it = null;

	String parentId = "";

	String childId = "";

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@And("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.salesforce();

	}

	@When("^User enters username and password and logs in$")
	public void user_enters_username_and_password_and_logs_in() throws Throwable {

		LoginPage lp = new LoginPage(driver);
		lp.login();
	}

	@Then("^Click Flat Icon$")
	public void click_flat_icon() throws Throwable {
		MainPage mp = new MainPage(driver);
		wait.until(ExpectedConditions.visibilityOf(mp.getIconWaffle()));
		mp.getIconWaffle().click();

	}

	@And("^Select service$")
	public void select_service() throws Throwable {
		MainPage mp = new MainPage(driver);
		wait.until(ExpectedConditions.visibilityOf(mp.geticonWaffleBtnService()));
		mp.geticonWaffleBtnService().click();
	}

	@Given("^Navigates between all the tabs, click new button and cancel$")
	public void navigates_between_all_the_tabs_click_new_button_and_cancel() throws Throwable {
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

	// @After
	@Then("^Close the Browser$")
	public void close_the_browser() throws Throwable {

		driver.close();
	}

	// Parte 2
	@Given("^user  Navigates to accounts and click New$")
	public void user_navigates_to_accounts_and_click_new() throws Throwable {
		NavPage np = new NavPage(driver);
		np.getAccounts().click();
		np.getNewBtn().click();
	}

	@Then("^Fill inputs information$")
	public void fill_inputs_information() throws Throwable {
		AccountPage ap = new AccountPage(driver);

		String[] lblNames = ap.getAccountInfoLblNames();
		String[] lblNamesComplete = ap.getAccountInfoLblNamesComplete();
		for (int i = 0; i < lblNames.length; i++) {
			WebElement input = ap.getlblName(lblNames[i]);
			input.sendKeys(lblNamesComplete[i]);
		}
	}

	@And("^fill combos Information$")
	public void fill_combos_information() throws Throwable {
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

	@And("^scrolls Down$")
	public void scrolls_down() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.actionBody').scrollTop=5000");
	}

	@Then("^fill Addres information Inputs$")
	public void fill_addres_information_inputs() throws Throwable {

		// Fills textArea
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

	@And("^fill Additional Address Information Combo$")
	public void fill_additional_address_information_combo() throws Throwable {
		AccountPage ap = new AccountPage(driver);

		// Fill Additional info lbl
		String[] lblNames = ap.getAditionalAddressInfoLblNames();
		String[] lblNamesComplete = ap.getAditionalAddressInfoLblComplete();

		for (int i = 0; i < lblNames.length; i++) {
			WebElement input = ap.getlblName(lblNames[i]);
			input.sendKeys(lblNamesComplete[i]);
		}
		// Fill Additional Info combos

		String[] comboNames = ap.getAditionalAddresInfoComboNames();
		String[] comboNamesOption = ap.getAditionalAddresInfoComboNamesOptions();
		for (int i = 0; i < comboNames.length; i++) {
			WebElement input = ap.getcomboName(comboNames[i]);
			input.click();
			WebElement selected = driver.findElement(By.xpath(comboNamesOption[i]));
			selected.click();

		}
		// Fill Description Information text Area
		String[] textAreaName = ap.getAditionalAddressInfoLblComplete();
		String[] textAreaComplete = ap.getAditionalAddresInfoComboNamesOptions();
		for (int i = 2; i < textAreaName.length; i++) {
			WebElement input = ap.getTextAreaName(textAreaName[i]);
			input.sendKeys(textAreaComplete[i]);
		}

	}

	@And("^selects calendar day$")
	public void selects_calendar_day() throws Throwable {

		String calendar = "//input[@name='SLAExpirationDate__c']";
		driver.findElement(By.xpath(calendar)).click();
		String calendarDays = "//span[@class='slds-day']"; // Path to each days TD from table shown in calendar
		List<WebElement> days = driver.findElements(By.xpath(calendarDays)); // Collect days available to click on
		days.get(30).click();
	}

	@Then("^creates the Account Record$")
	public void creates_the_account_record() throws Throwable {

		AccountPage ap = new AccountPage(driver);
		ap.getSaveBtn().click();

	}

	// Parte 3

	@Then("^try to creates new Account record without filling required input$")
	public void try_to_creates_new_account_record_without_filling_required_input() throws Throwable {
		AccountPage ap = new AccountPage(driver);

		// Find required field and sends empty keys
		String[] accountName = ap.getAccountInfoLblNames();
		WebElement input = ap.getlblName(accountName[0]);
		input.sendKeys("");
		// Clicks save btn
		ap.getSaveBtn().click();

	}

	@And("^waits expected error$")
	public void waits_expected_error() throws Throwable {
		AccountPage ap = new AccountPage(driver);

		wait.until(ExpectedConditions.visibilityOf(ap.getContainer()));
		// Thread.sleep(3000);
		if (ap.getContainer().isDisplayed()) {
			Assert.assertTrue(false, "Faltan datos en Account Name");

		} else {
			Assert.assertTrue(true, "El error no aparece");
		}

	}
	@After
	@And("^Close the Browser after error$")
    public void close_the_browser_after_error() throws Throwable {
       driver.close();
    }
	// Parte 4

	@Given("^user open contacts in a new tab$")
	public void user_open_contacts_in_a_new_tab() throws Throwable {

		ContactPage cp = new ContactPage(driver);

		cp.contactLink();
		WebElement ContactLink = cp.contactLink();
		ContactLink.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

		// Si lo paso por el pageobj, se rompe

		// Abre otra pestania
		windows = driver.getWindowHandles();
		it = windows.iterator();

		parentId = it.next();
		childId = it.next();

		driver.switchTo().window(childId);

		// Click en new
		NavPage np = new NavPage(driver);
		np.getNewBtn().click();

	}

	@Then("^fill Contact inputs$")
	public void fill_contact_inputs() throws Throwable {

		ContactPage cp = new ContactPage(driver);
		String[] lblNames = cp.getcontactInfoLbl();
		String[] lblNamesComplete = cp.getcontactInfoLblData();
		for (int i = 0; i < lblNames.length; i++) {
			WebElement input = cp.getlblName(lblNames[i]);
			input.sendKeys(lblNamesComplete[i]);
		}
	}

	@And("^select Account Name$")
	public void select_account_name() throws Throwable {
		ContactPage cp = new ContactPage(driver);
		cp.getAccountName().click();
		cp.getAccountNameOption().click();

	}

	@Then("^fill  Contact combos$")
	public void fill_contact_combos() throws Throwable {

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

	@Then("^fill contact address information Inputs$")
	public void fill_contact_address_information_inputs() throws Throwable {

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

	@And("^fill additional contact address information$")
	public void fill_additional_contact_address_information() throws Throwable {

		ContactPage cp = new ContactPage(driver);

		String[] AdditionalInfoLbl = cp.getAdditionalInfoLbl();
		String[] completeAdditionalLbl = cp.getAdditionalInfoLblData();

		Thread.sleep(3000);
		for (int i = 0; i < AdditionalInfoLbl.length; i++) {
			WebElement input = cp.getlblName(AdditionalInfoLbl[i]);
			Thread.sleep(3000);
			input.sendKeys(completeAdditionalLbl[i]);

		}

		wait.until(ExpectedConditions.visibilityOf(cp.description));
		cp.description.sendKeys("New Description");

	}

	@And("^fill additional contact address information combo$")
	public void fill_additional_contact_address_information_combo() throws Throwable {

		ContactPage cp = new ContactPage(driver);

		String[] comboNames = cp.getAdditionalInfoCombo();
		String[] comboNamesOption = cp.getAdditionalInfoComboOption();
		Thread.sleep(3000);
		for (int i = 0; i < comboNames.length; i++) {
			WebElement input = cp.getComboName(comboNames[i]);
			input.click();
			Thread.sleep(3000);
			WebElement selected = driver.findElement(By.xpath(comboNamesOption[i]));
			selected.click();

		}
	}

	@Then("^creates the Contact Record$")
	public void creates_the_contact_record() throws Throwable {
		ContactPage cp = new ContactPage(driver);
		cp.getSaveBtn().click();
	}

	@And("^returns to Home page$")
	public void returns_to_home_page() throws Throwable {

		driver.switchTo().window(parentId);
	}

	// Parte 5

	@Given("^user  Navigates to accounts  clicks arrow and clicks edit$")
	public void user_navigates_to_accounts_clicks_arrow_and_clicks_edit() throws Throwable {

		// Go to accounts
		NavPage np = new NavPage(driver);
		np.getAccounts().click();

		// Click on arrow, then edit
		AccountPage ap = new AccountPage(driver);
		// Hay que hacer click en la flechita
		ap.getArrow().click();
		ap.getEdit().click();

	}

	@Then("^clicks on each  Option , change it and saves$")
    public void clicks_on_each_option_change_it_and_saves() throws Throwable {
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
		
		
		ap.getSaveBtn().click();

    }
	
		


	@And("^verify if options where changed$")
	public void verify_if_options_where_changed() throws Throwable {
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
		
		
		if(upsellOportunityOption != upsellOportunityOptionChanged) {
			Assert.assertTrue(true);
			System.out.println("Opcion upsell modificada");
		}else {
			Assert.assertTrue(false);
		}

	}

	// Parte 6

	@And("^change Employees value$")
	public void change_employees_value() throws Throwable {
		AccountPage ap = new AccountPage(driver);
		WebElement input = ap.getlblName("Employees");
		input.clear();

		input.sendKeys("1431655766.");
		Thread.sleep(3000);

	}

	@Then("^saves the change and saves error msg$")
	public void saves_the_change_and_saves_error_msg() throws Throwable {

		AccountPage ap = new AccountPage(driver);
		Thread.sleep(3000);
		ap.getSaveBtn().click();
		Thread.sleep(3000);

		String errorMsg = ap.getErrorMsg().getText();
		String expectedErrorMsg = "Employees: value outside of valid range on numeric field: 1431655766";

		Assert.assertEquals(errorMsg, expectedErrorMsg);

		/*
		 * System.out.println(errorMsg); System.out.println(expectedErrorMsg);
		 */
	}
	// Parte 7

	@And("^user inputs (.+) into Account Name Input, (.+) into Employees input, (.+) into Account Site input$")
	public void user_inputs_into_account_name_input_into_employees_input_into_account_site_input(String accountname,
			String employees, String accountsite) throws Throwable {
		AccountPage ap = new AccountPage(driver);

		String accountNameLbl = ap.getAccountInfoLblNames()[0];
		String accountSiteLbl = ap.getAccountInfoLblNames()[2];
		String employeesLbl = ap.getAccountInfoLblNames()[8];

		WebElement accountNameW = ap.getlblName(accountNameLbl);
		WebElement accountSiteLblW = ap.getlblName(accountSiteLbl);
		WebElement employeesLblW = ap.getlblName(employeesLbl);

		accountNameW.sendKeys(accountname);
		accountSiteLblW.sendKeys(accountsite);
		employeesLblW.sendKeys(employees);

		
		

	}

}