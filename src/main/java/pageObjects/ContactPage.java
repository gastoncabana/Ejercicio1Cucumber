package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.DriverFactory;

public class ContactPage extends DriverFactory {

	WebDriver driver;

	//xpath to replace lbls
	private static final String lblField = "//label[text()='$name']//parent::lightning-input//descendant::input";

	//xpath to replace combos
	private static final String comboField = "//label[text()='$name']//parent::lightning-combobox//descendant::input";
	
	// REPLACE LBL TEXT AREA FIELD
	private static final String textAreaField = "//label[text()='$name']//parent::lightning-textarea//descendant::textarea";

	

	@FindBy(xpath = "//*[@data-id='Contact']/a")
	public WebElement ContactLink;
	
	@FindBy(xpath = "//label[text()='Account Name']//parent::lightning-grouped-combobox//descendant::div")
	public WebElement accountName;
	
	@FindBy(xpath = "(//force-record-layout-item)[5]//lightning-base-combobox-item [1]")
	public WebElement accountNameOption;
	
	
	@FindBy(xpath = "//label[text()='Description']//parent::lightning-textarea//descendant::textarea")
	public WebElement description;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	private WebElement saveBtn;
	
	// Contact Information Inputs
	private static String contactInfoLbl[] = { "First Name", "Last Name", "Title", "Department", "Phone", "Home Phone",
			"Mobile", "Other Phone", "Fax", "Email", "Assistant", "Asst. Phone" };
	// Contact Information Data
	private static String contactInfoLblData[] = { "Gaston", "Cabana", "Programmer", "IT", "098356081", "42244554",
			"098356081", "098356081", "212121", "gahonus@gmail.com", "N/A", "N/A" };

	//Contact information combos
	private static String ContactInfoCombo[] = { "Salutation", "Lead Source" };
	
	// Contact information options
	private static String SelectContactOption[] = { "//lightning-base-combobox-item [2]",
			"(//force-record-layout-item)[15]//lightning-base-combobox-item [3]" };
	
	
	//Contact address information labels
	private static String AddressInfoLbl[] = { "Mailing City", "Mailing State/Province", "Mailing Zip/Postal Code",
			"Mailing Country", "Other City", "Other State/Province", "Other Zip/Postal Code",
			"Other Country" };
	
	//Contact address lbl data
	private static String AddressInfoLblData[] = { "Maldonado", "Maldonado", "20000", "Uruguay", "Maldonado", "Maldonado", "20000",
			"Uruguay" };
	
	//Contact address information textarea
	private static String AddressInfoTextArea[] = { "Mailing Street", "Other Street" };
	
	//Contact address textarea data
	private static String AddresInfoTextAreaData[] = { "25 De Agosto", "30 de Agosto" };
	
	//Contact additional information label
	private static String AdditionalInfoLbl[] = { "Languages"};
	
	//Contact additional information data
	private static String AdditionalInfoLblData[] = { "English"};
	
	
	//Contact additional information combo
	private static String AdditionalInfoCombo[] = { "Level"};
	//Contact additional information combo option
	private static String SelectAdditionalOption[] = { "(//force-record-layout-item) [20] //lightning-base-combobox-item[2]",};

	public ContactPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement contactLink() {
		return ContactLink;
	}
	
	public WebElement getAccountName() {
		return accountName;
	}
	
	public WebElement getAccountNameOption() {
		return accountNameOption;
	}
	public WebElement getDescription() {
		return description;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	

	public WebElement getlblName(String lblName) {
		WebElement ret = driver.findElement(By.xpath(lblField.replace("$name", lblName)));
		return ret;
	}
	
	public WebElement getComboName(String comboName) {
		WebElement ret = driver.findElement(By.xpath(comboField.replace("$name", comboName)));
		return ret;
	}

	public WebElement getTextAreaName(String textAreaName) {
		WebElement ret = driver.findElement(By.xpath(textAreaField.replace("$name", textAreaName)));
		return ret;
	}
	public String[] getcontactInfoLbl() {
		return contactInfoLbl;
	}

	public String[] getcontactInfoLblData() {
		return contactInfoLblData;
	}
	
	public String[] getContactInfoCombo(){
		return ContactInfoCombo;
	}
	public String[] getContactInfoComboOption(){
		return SelectContactOption;
	}
	
	public String[] getAddressInfoTextArea() {
		return AddressInfoTextArea;
	}

	public String[] getAddresInfoTextAreaData() {
		return AddresInfoTextAreaData;
	}
	
	public String[] getAddressInfoLbl() {
		return AddressInfoLbl ;
	}
	public String[] getAddressInfoLblData() {
		return AddressInfoLblData ;
	}
	
	public String[] getAdditionalInfoLbl() {
		return AdditionalInfoLbl ;
	}
	public String[] getAdditionalInfoLblData() {
		return AdditionalInfoLblData ;
	}

	
	public String[] getAdditionalInfoCombo(){
		return AdditionalInfoCombo;
	}
	public String[] getAdditionalInfoComboOption(){
		return SelectAdditionalOption;
	}
	
	

}
