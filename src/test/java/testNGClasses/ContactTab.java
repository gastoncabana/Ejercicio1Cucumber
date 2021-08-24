package testNGClasses;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.DriverFactory;

public class ContactTab extends DriverFactory {

	static Set<String> windows = null;

	static Iterator<String> it = null;

	static String parentId = "";

	static String childId = "";

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
	}
	
	//Methods
	public  void clickWaffle() throws Exception {

		Thread.sleep(1500L);
		driver.findElement(By.xpath(prop.getProperty("iconWafleBtn"))).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath(prop.getProperty("iconWafleServiceBtn"))).click(); // Changing
		Thread.sleep(6000L);
	}

	public  void clickService() throws InterruptedException {

		driver.findElement(By.xpath("//one-app-nav-bar-item-root[4]")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath(prop.getProperty("newBtn"))).click();
		Thread.sleep(3000L);

	}

	public  void switchTab() {
	

		WebElement ContactLink = driver.findElement(By.xpath("//*[@data-id='Contact']/a"));

		ContactLink.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

		windows = driver.getWindowHandles();

		it = windows.iterator();

		parentId = it.next();

		childId = it.next();

		driver.switchTo().window(childId);

	}
	
	public  void fillInputContactInfo() {

		String contactInfoLbl[] = { "First Name", "Last Name", "Title", "Department", "Phone",
				"Home Phone", "Mobile", "Other Phone", "Fax","Email","Assistant","Asst. Phone" };
		String completeContact[] = { "Gaston", "Cabana", "Programmer", "IT", "098356081",
				"42244554", "098356081", "098356081", "212121","gahonus@gmail.com","N/A","N/A" };
		for (int i = 0; i < contactInfoLbl.length; i++) {

			WebElement input = driver.findElement(By
					.xpath("//label[text()='" + contactInfoLbl[i] + "']//parent::lightning-input//descendant::input"));
			input.sendKeys(completeContact[i]);
		}
		
		driver.findElement(By.xpath("//input[@name='Birthdate']")).sendKeys("12/11/1996");
	}

	public  void fillComboContactInfo() throws InterruptedException {

		String ContactInfoCombo[] = { "Salutation", "Lead Source"};
		String SelectContactOption[] = { "//lightning-base-combobox-item [2]", "(//force-record-layout-item)[15]//lightning-base-combobox-item [3]" };

		for (int i = 0; i < ContactInfoCombo.length; i++) {

			WebElement input = driver.findElement(By.xpath(
					"//label[text()='" + ContactInfoCombo[i] + "']//parent::lightning-combobox//descendant::input"));
			input.click();
			Thread.sleep(3000L);
			WebElement selected = driver.findElement(By.xpath(SelectContactOption[i]));
			selected.click();
		}
	}
	
	public  void selectAccountName() {
		driver.findElement(By.xpath("//label[text()='Account Name']//parent::lightning-grouped-combobox//descendant::div")).click();
		driver.findElement(By.xpath("(//force-record-layout-item)[5]//lightning-base-combobox-item [1]")).click();
	}
	
	public  void scrollDown() throws InterruptedException {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.actionBody').scrollTop=5000");
	}

	public  void fillAddressInformationInputs() throws InterruptedException {

		// Fills textarea
		String AddressInfoTextArea[] = { "Mailing Street", "Other Street" };
		String AddresTextAreaComplete[] = { "25 De Agosto", "30 de Agosto" };
		for (int i = 0; i < AddressInfoTextArea.length; i++) {

			WebElement input = driver.findElement(By.xpath("//label[text()='" + AddressInfoTextArea[i]
					+ "']//parent::lightning-textarea//descendant::textarea"));

			input.sendKeys(AddresTextAreaComplete[i]);

		}

		// Fills Lbl
		String AddressInfoLbl[] = { "Mailing City", "Mailing State/Province", "Mailing Zip/Postal Code",
				"Mailing Country", "Other City", "Other State/Province", "Other Zip/Postal Code",
				"Other Country" };
		String completeAddress[] = { "Maldonado", "Maldonado", "20000", "Uruguay", "Maldonado", "Maldonado", "20000",
				"Uruguay" };
		for (int i = 0; i < AddressInfoLbl.length; i++) {

			WebElement input = driver.findElement(By
					.xpath("//label[text()='" + AddressInfoLbl[i] + "']//parent::lightning-input//descendant::input"));
			input.sendKeys(completeAddress[i]);

		}
	}

	public  void fillAdditionalAddressInformation() throws InterruptedException {

		//Fill lbl
		String AdditionalInfoLbl[] = { "Languages"};
		String completeAdditionalLbl[] = { "English"};
		for (int i = 0; i < AdditionalInfoLbl.length; i++) {

			WebElement input = driver.findElement(By.xpath(
					"//label[text()='" + AdditionalInfoLbl[i] + "']//parent::lightning-input//descendant::input"));
			input.sendKeys(completeAdditionalLbl[i]);

		}
		
		String description = "//label[text()='Description']//parent::lightning-textarea//descendant::textarea";
		driver.findElement(By.xpath(description)).sendKeys("New Description");
	}
	
	public  void fillAdditionalAddressInformationCombo() throws InterruptedException {

		
		String AdditionalInfoCombo[] = { "Level"};
		String SelectAdditionalOption[] = { "(//force-record-layout-item) [20] //lightning-base-combobox-item[2]",};

		for (int i = 0; i < AdditionalInfoCombo.length; i++) {

			WebElement input = driver.findElement(By.xpath(
					"//label[text()='"+AdditionalInfoCombo[i]+"']//parent::lightning-combobox//descendant::input"));
			input.click();
			WebElement selected = driver.findElement(By.xpath(SelectAdditionalOption[i]));
			selected.click();

		}
	}

	public static void returnHomePage() throws InterruptedException {
		Thread.sleep(1500);
		driver.switchTo().window(parentId);
	}
	public static void create() {
		String save = "//button[@name='SaveEdit']";
		driver.findElement(By.xpath(save)).click();
	}
	
	
	@AfterClass
	public void close() {
		driver.close();
	}
}
