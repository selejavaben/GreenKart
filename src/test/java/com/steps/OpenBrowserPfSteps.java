package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.NewTourPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class OpenBrowserPfSteps {
	
	WebDriver driver;
	NewTourPages pf;
	
	@Given("^User go to New Tours home page q$")
	public void user_go_to_New_Tours_home_page_q() throws Throwable {
		
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		driver.manage().window().maximize();
		pf = new NewTourPages(driver);
	    
	    
	}

	@Given("^User click on the user name field q$")
	public void user_click_on_the_user_name_field_q() throws Throwable {
		//driver.findElement(By.xpath("//*[@name= 'userName']")).click();
		pf.getUserName().click();
	    
	    
	}

	@When("^User type test username in username field q$")
	public void user_type_test_username_in_username_field_q() throws Throwable {
		//driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("Admin");
		pf.getUserName().sendKeys("Admin");
	    
	    
	}

	@When("^User click on the password field q$")
	public void user_click_on_the_password_field_q() throws Throwable {
		//driver.findElement(By.xpath("//*[@name= 'password']")).click();
		pf.getPassword().click();
	    
	    
	}

	@When("^User type test password in password field q$")
	public void user_type_test_password_in_password_field_q() throws Throwable {
		//driver.findElement(By.xpath("//*[@name= 'password']")).sendKeys("123456");
		pf.getPassword().sendKeys("123456");
	    
	    
	}

	@Then("^User click on the loging button q$")
	public void user_click_on_the_loging_button_q() throws Throwable {
		//driver.findElement(By.xpath("//*[@name= 'submit']")).click();
		pf.getSubmit().click();
	    
	    
	}

	@Then("^User verify the text \"([^\"]*)\" q$")
	public void user_verify_the_text_q(String arg1) throws Throwable {
		
		String expected = "Login Successfully";
		
		String actual = driver.findElement(By.xpath("//*[contains(text(), 'Login Successfully')]")).getText();
				
		Assert.assertTrue("the text does not match expected", actual.contains(expected));
	    
	    
	}


	

}
