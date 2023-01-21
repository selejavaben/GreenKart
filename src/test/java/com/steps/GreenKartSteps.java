package com.steps;



import java.time.Duration;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class GreenKartSteps {
	WebDriver driver;
	
	int secondPrice;
	int thirdPrice;
	int totalPrice;
	
	
	ArrayList <Integer> priceList = new ArrayList <Integer>();
	
	
	@Given("^User go to Green Kart home page$")
	public void user_go_to_Green_Kart_home_page() throws Throwable {
		
		driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		
	    
	    
	}

	@Given("^User verify the page title$")
	public void user_verify_the_page_title() throws Throwable {
		
		String expected = "GreenKart - veg and fruits kart";
		String actual = driver.getTitle();
		Assert.assertTrue("the title does not match ", actual.contains(expected));
	    
	    
	}

	@When("^User capture all items from the page$")
	public void user_capture_all_items_from_the_page() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		List <WebElement> items = driver.findElements(By.xpath("//p[@class='product-price']"));
		
	    
	    
	    for(WebElement element : items ) {
	    	
	    	String price =element.getText();
	    	
	    	int priceInt = Integer.parseInt(price);
	    	
	    	priceList.add(priceInt);
	    	
	    	
	    	//System.out.println(items.get(i).getText().trim());
	    	
	    	//priceList.add(Integer.parseInt(items.get(i).getText().trim()));
	    	
	    	
	    	
	    }
	    
	    
	    
	}

	@When("^Print sorted prices in decending order$")
	public void print_sorted_prices_in_decending_order() throws Throwable {
		
		Collections.sort(priceList, Collections.reverseOrder());
		System.out.println(priceList);    
	}

	@When("^Add second plus third item in the cart$")//
	public void add_second_plus_third_item_in_the_cart() throws Throwable {
		
		secondPrice = priceList.get(1);
		thirdPrice = priceList.get(2);
		totalPrice = secondPrice + thirdPrice;
		driver.findElement(By.xpath("//p[contains(text(),'"+secondPrice+"')]/following-sibling::div[2]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'"+thirdPrice+"')]/following-sibling::div[2]")).click();
		
		
	}

	@Then("^User go to cart page$")
	public void user_go_to_cart_page() throws Throwable {
		
		driver.findElement(By.xpath("//*[@alt ='Cart' ]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	    
	}

	@Then("^User verify the total price$")
	public void user_verify_the_total_price() throws Throwable {
		
		//secondPrice = priceList.get(1);
		//thirdPrice = priceList.get(2);
		Integer totalPriceEx = secondPrice + thirdPrice;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='totAmt']")));
		String totalPriceString = driver.findElement(By.xpath("//*[@class='totAmt']")).getText();
		
		  Integer totalPriceInte = Integer.parseInt(totalPriceString);
		  System.out.println(totalPriceString+ " "+totalPriceInte);
		 
		Assert.assertTrue("the total price does not match ", totalPriceInte.equals(totalPriceEx));
	    
	}

	@Then("^User go to next page to select country \"([^\"]*)\"$") 
	public void user_go_to_next_page_to_select_country(String arg1) throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Place Order')]")));
		driver.findElement(By.xpath("//*[contains(text(), 'Place Order')]")).click();
		driver.findElement(By.xpath("//*[@style='width: 200px;']")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'United States')]")).click();
		driver.findElement(By.xpath("//*[@type='checkbox']")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'Proceed')]")).click();
		   
	    
	}

	@Then("^User verify successfully shiped items \"([^\"]*)\"$")
	public void user_verify_successfully_shiped_items(String arg1) throws Throwable {
		
		String expected = arg1;
		
		String actual = driver.findElement(By.xpath("//*[contains(text(),'Thank you, your order has been placed successfully')]")).getText();
				
		Assert.assertTrue("the text does not match expected", actual.contains(expected));
	    
	    
	}


}
