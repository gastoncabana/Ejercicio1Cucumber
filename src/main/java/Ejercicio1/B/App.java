package Ejercicio1.B;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import resources.DriverFactory;

public class App extends DriverFactory {
	
	public WebDriver driver;
	
	public App(WebDriver driver) {
		
		this.driver=driver;
	}
	
	@Test
	public void Login() throws InterruptedException {
		
		
		
	}
	
	
	
}
