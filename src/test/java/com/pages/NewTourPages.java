package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewTourPages {

	public NewTourPages(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//*[@name= 'userName']")
	private static WebElement userName;
	
	@FindBy(how = How.XPATH, using = "//*[@name= 'password']")
	private static WebElement password;
	
	@FindBy(how = How.XPATH, using = "//*[@name= 'submit']")
	private static WebElement submit;
	
	
	
	public WebElement getUserName() {
		return userName;
		
	}
	public void setUserName(WebElement userName) {
		NewTourPages.userName = userName;
	}
	public  WebElement getPassword() {
		return password;
	}
	public  void setPassword(WebElement password) {
		NewTourPages.password = password;
	}
	public  WebElement getSubmit() {
		return submit;
	}
	public void setSubmit(WebElement submit) {
		NewTourPages.submit = submit;
	}
	
	
	
	
	
	

}
