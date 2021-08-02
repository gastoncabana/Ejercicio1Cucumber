package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.DriverFactory;

public class AccountPage extends DriverFactory {

	WebDriver driver;

	// REPLACES
	// REPLACE LBL INPUT FIELD
	private static final String lblField = "//label[text()='$name']//parent::lightning-input//descendant::input";
	// REPLACE LBL COMBO FIELD
	private static final String comboField = "//label[text()='$name']//parent::lightning-combobox//descendant::input";
	// REPLACE LBL TEXT AREA FIELD
	private static final String textAreaField = "//label[text()='$name']//parent::lightning-textarea//descendant::textarea";

	// ACCOUNT
	// ACCOUNT INFORMATION LABELS
	private static  String AccountInfoLbl[] = { "Account Name", "Account Number", "Account Site", "Annual Revenue",
			"Phone", "Fax", "Website", "Ticker Symbol", "Employees", "SIC Code", };
	private static  String CompleteAccount[] = { "Subcuenta de Gaston2", "7149", "www.Gaston.com", "25000",
			"098356081", "20291232", "ww.google.com", "Sarasa", "2500", "2000", };
	// ACCOUNT
	// ACCOUNT INFORMATION COMBOS
	private static  String AccountInfoCombo[] = { "Type", "Industry", "Rating", "Ownership" };
	private static  String[] SelectAccountOption = { "//lightning-base-combobox-item [7]",
			"//lightning-base-combobox-item [10]",
			"//lightning-base-combobox-item [3]",
			"(//force-record-layout-item) [12]//lightning-base-combobox-item [2]" };

	// ACCOUNT
	// ADDRESS INFORMATION TEXT AREA
	private static  String AddressTextAreaName[] = { "Billing Street", "Shipping Street","Description" };
	private static  String AddresTextAreaComplete[] = { "25 De Agosto", "30 de Agosto","New Description" };

	// ACCOUNT
	// ADDRESS INFORMATION LABELS
	private static  String AddressInfoLbl[] = { "Billing City", "Billing State/Province",
			"Billing Zip/Postal Code", "Billing Country", "Shipping City", "Shipping State/Province",
			"Shipping Zip/Postal Code", "Shipping Country" };

	private static  String completeAddressInfoLbl[] = { "Maldonado", "Maldonado", "20000", "Uruguay", "Maldonado",
			"Maldonado", "20000", "Uruguay" };

	//ACCOUNT
	//ADDRESS ADITIONAL INFORMATION LABELS
	private static  String AdditionalInfoLbl[] = { "Number of Locations", "SLA Serial Number"};
	private static  String completeAdditionalLbl[] = { "2", "1029231123"};
	//ACCOUNT
	//ADDRES ADITIONAL INFORMATION COMBOS
	private static  String AdditionalInfoCombo[] = { "Customer Priority","Active","SLA", "Upsell Opportunity"};
	private static  String SelectAdditionalOption[] = { "(//force-record-layout-item) [19] //lightning-base-combobox-item[2]",
			"(//force-record-layout-item) [25] //lightning-base-combobox-item[2]",
			"(//force-record-layout-item) [20] //lightning-base-combobox-item[2]",
			"(//force-record-layout-item) [24] //lightning-base-combobox-item[2]" };
	
	private static  String changeCombos[] = { "Type", "Rating"};
	private static  String changeCombosOptions[] = { "//lightning-base-combobox-item [5]",
			"//lightning-base-combobox-item [2]"};
	
	
	private static  String changeLastCombos[] = { "Upsell Opportunity"};
	private static  String changeLastCombosOptions[] = {"(//force-record-layout-item) [24] //lightning-base-combobox-item[3]"};
	
	@FindBy(xpath = "//button[@name='SaveEdit']")
	private WebElement saveBtn;

	@FindBy(xpath  = "//div[@class='container']")
	private WebElement container;
	
	@FindBy(xpath="//a[@title='Edit']")
	private WebElement edit;
	
	@FindBy(xpath="//a[@role='button']/span/span[1]")
	private WebElement arrow;
	
	@FindBy(xpath="//div[@class='slds-form-element__help']")
		private WebElement errorMsg;
	
	
	public AccountPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getlblName(String lblName) {
		WebElement ret = driver.findElement(By.xpath(lblField.replace("$name", lblName)));
		return ret;
	}

	public WebElement getcomboName(String comboName) {
		WebElement ret = driver.findElement(By.xpath(comboField.replace("$name", comboName)));
		return ret;
	}

	public WebElement getTextAreaName(String textAreaName) {
		WebElement ret = driver.findElement(By.xpath(textAreaField.replace("$name", textAreaName)));
		return ret;
	}

	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getContainer() {
		return container;
	}
	public WebElement getEdit() {
		return edit;
	}
	
	public WebElement getArrow() {
		return arrow;
	}
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	
	public String[] getAccountInfoLblNames() {
		return AccountInfoLbl;
	}

	public String[] getAccountInfoLblNamesComplete() {
		return CompleteAccount;
	}

	public String[] getAccountInfoComboNames() {
		return AccountInfoCombo;
	}

	public String[] getAccountInfoComboNamesOption() {
		return SelectAccountOption;
	}

	public String[] getAddressTextAreaName() {
		return AddressTextAreaName;
	}

	public String[] getAddresTextAreaComplete() {
		return AddresTextAreaComplete;
	}

	public String[] getAddressInfoLblNames() {
		return AddressInfoLbl;
	}

	public String[] getAddressInfoLblComplete() {
		return completeAddressInfoLbl;
	}

	public String[] getAditionalAddressInfoLblNames() {
		return AdditionalInfoLbl;
	}
	
	public String[] getAditionalAddressInfoLblComplete(){
		return completeAdditionalLbl;
	}
	
	public String[] getAditionalAddresInfoComboNames() {
		return AdditionalInfoCombo;
	}
	public String[] getAditionalAddresInfoComboNamesOptions() {
		return SelectAdditionalOption;
	}
	
	public String[] getChangeCombos() {
		return changeCombos;
	}
	public String[] getChangeCombosOptions () {
		return changeCombosOptions;
	}
	public String[] getChangeLastCombos() {
		return changeLastCombos;
	}
	public String[] getChangeLastCombosOptions () {
		return changeLastCombosOptions;
	}
	
}
