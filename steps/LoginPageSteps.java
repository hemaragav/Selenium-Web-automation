package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageSteps {

	ChromeDriver driver;

	@Given("Launch the browser and load the URL")
	public void launch_the_browser_and_load_the_url() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://login.salesforce.com/");

	}

	@When("Enter the username as {string}")
	public void enter_the_username_as(String string) {
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");

	}

	@When("Enter the password as {string}")
	public void enter_the_password_as(String string) {

		driver.findElement(By.id("password")).sendKeys("testleaf@2024");

	}

	@When("Click the LoginButton")
	public void click_the_login_button() {

		driver.findElement(By.id("Login")).click();

	}

	@Then("Verify its in HomePage")
	public void verify_its_in_home_page() {

		String title = driver.getTitle();
		Assert.assertEquals(title, "Home|Salesforce");

	}

	@Then("Click on toggle menu button from the left corner")
	public void click_on_toggle_menu_button_from_the_left_corner() {

		driver.findElement(By.cssSelector(".appLauncher.slds-context-bar__icon-action")).click();

	}

	@Then("Click view All and click Sales from App Launcher")
	public void click_view_all_and_click_sales_from_app_launcher() throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[.='View All']")).click();

		WebElement findElement = driver.findElement(By.xpath("//p[.='Sales']"));
		Actions act = new Actions(driver);
		act.moveToElement(findElement).perform();
		act.click().perform();

	}

	@Then("Click on Accounts tab")
	public void click_on_accounts_tab() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions
				.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Accounts']/following::a"))));
		element.click();
	}

	@Then("Click on New button")
	public void click_on_new_button() {

		driver.findElement(By.xpath("//div[.='New']")).click();

	}

	@Then("Enter your name as account name as {string}")
	public void enter_your_name_as_account_name_as(String string) {

		driver.findElement(By.name("Name")).sendKeys("Hema");
	}

	@Then("Select Ownership as Public")
	public void select_ownership_as_public() {

		driver.findElement(By.xpath("//button[@id='combobox-button-292']")).click();

		driver.findElement(By.xpath("//button[@value='Public']")).click();

	}

	@Then("Click Save")
	public void click_save() {

	}

	@Then("Verify Account name matches with Toast message")
	public void verify_account_name_matches_with_toast_message() {

		String text = driver.findElement(By.xpath("//div[contains(@class,'toastContent')]")).getText();
		Assert.assertEquals(text, "Account 'Hema' was created.");

		driver.close();

	}

}
