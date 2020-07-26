package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver cdriver;
	public LoginPage lp;
	
	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver");
		System.setProperty("webdriver.chrome.driver", "/Users/indu/Automation/ChromeDriver/chromedriver");
		cdriver = new ChromeDriver();
		
		lp = new LoginPage(cdriver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		cdriver.get(url);
		cdriver.manage().window().maximize();
	    
	}

	@And("User enters Email {string} and Password {string}")
	public void user_enters_Email_and_Password(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
	    
	}

	@And("Click on Login")
	public void click_on_Login() throws InterruptedException {
		lp.clickLogin();
		Thread.sleep(3000);
	   
	}

	@Then("Page Title Display {string}")
	public void page_Title_Display(String title) throws InterruptedException {
		if(cdriver.getPageSource().contains("Login was unsuccessful")) {
			cdriver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, cdriver.getTitle());
			
		}
		Thread.sleep(3000);
	
	}

	@When("user click on Logout link")
	public void user_click_on_Logout_link() throws InterruptedException {
		
		lp.clickLogout();
		Thread.sleep(3000);
	
	}

	@And("close Browser")
	public void close_Browser() {
		cdriver.quit();
	
	}




}
