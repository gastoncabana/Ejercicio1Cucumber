package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.NavPage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefinition extends base {

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
		mp.waffleIcon();

	}

	@And("^Select service$")
	public void select_service() throws Throwable {
	MainPage mp = new MainPage(driver);
	mp.clickService();
	}

	@Then("^Navigates between all the tabs, click new button and cancel$")
	public void navigates_between_all_the_tabs_click_new_button_and_cancel() throws Throwable {
		NavPage np = new NavPage(driver);
		np.navigateBetweenTabs();
	}

	@And("^Close the Browser$")
	public void close_the_browser() throws Throwable {
		NavPage np = new NavPage(driver);
		np.closeDriver();
	}
}