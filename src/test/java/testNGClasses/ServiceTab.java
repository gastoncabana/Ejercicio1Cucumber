package testNGClasses;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.DriverFactory;

public class ServiceTab extends DriverFactory {

	@BeforeMethod
	public void driver() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	/*
	 * @Test (priority=2) public void ejecucion() { imprimir(crearPalabras());
	 * 
	 * }
	 */

	@Test(priority = 1)
	public void navigate() throws InterruptedException {

		driver.findElement(By.xpath(prop.getProperty("userBtn"))).sendKeys(prop.getProperty("user"));
		driver.findElement(By.xpath(prop.getProperty("passBtn"))).sendKeys(prop.getProperty("pass"));
		driver.findElement(By.xpath(prop.getProperty("loginBtn"))).click();

		// Click en boton arriba izquierda
		Thread.sleep(9000L);
		driver.findElement(By.xpath(prop.getProperty("iconWafleBtn"))).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath(prop.getProperty("iconWafleServiceBtn"))).click(); // Changing
		Thread.sleep(6000L);

		for (int i = 2; i < 8; i++) {
			driver.findElement(By.xpath("//one-app-nav-bar-item-root[" + i + "]")).click();
			Thread.sleep(3000L);

			if (i == 3 || i == 4) {
				driver.findElement(By.xpath(prop.getProperty("newBtn"))).click();
				Thread.sleep(3000L);
				driver.findElement(By.xpath(prop.getProperty("cancel34Btn"))).click();
				Thread.sleep(3000L);

			}

			if (i == 5) {

				driver.findElement(By.xpath(prop.getProperty("newBtn"))).click();
				Thread.sleep(3000L);
				driver.findElement(By.xpath(prop.getProperty("cancel5Btn"))).click();
				Thread.sleep(3000L);
			}

			if (i == 6) {

				driver.findElement(By.xpath(prop.getProperty("newReportBtn"))).click();
				Thread.sleep(8000L);
				driver.switchTo().frame(driver.findElement(By.xpath(prop.getProperty("iframeReport"))));
				Thread.sleep(3000L);
				driver.findElement(By.xpath(prop.getProperty("iframeCancelButton"))).click();
				Thread.sleep(3000L);
				driver.switchTo().defaultContent();
			}
			if (i == 7) {
				driver.findElement(By.xpath(prop.getProperty("newDashboardBtn"))).click();
				Thread.sleep(8000L);
				driver.switchTo().frame(driver.findElement(By.xpath(prop.getProperty("iframeDashboard")))); // fram
				Thread.sleep(3000L);
				driver.findElement(By.xpath(prop.getProperty("iframeCancelButton"))).click(); // Cancel click

				Thread.sleep(3000L);
				driver.switchTo().defaultContent(); // Getting out of frame
			}
		}
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	public ArrayList<String> crearPalabras() {

		ArrayList<String> ar = new ArrayList<String>();
		ar.add("pepe0");
		ar.add("pepe1");
		ar.add("pepe2");
		ar.add("pepe3");

		return ar;

	}

	public void imprimir(ArrayList<String> a) {

		for (int i = 0; i < a.size(); i++) {

			System.out.println(a.get(i));
		}

	}
}
