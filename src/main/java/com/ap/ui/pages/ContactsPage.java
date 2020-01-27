package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ap.ui.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(id = "id_contact")
	WebElement headingDropdown;
	
	@FindBy(xpath ="//input[@id='email']")
	WebElement emailInput;
	
	@FindBy(id ="id_order")
	WebElement OrderReference;
	
	@FindBy(id ="message")
	WebElement messageTextbox;
	
	@FindBy(id ="submitMessage")
	WebElement submitMessageButton;
	
	@FindBy(css ="[class='alert alert-success']")
	WebElement successMsg;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		/**
		 * This keyword can be used to refer to any member of the current object 
		 * from within an instance Method or a constructor
		 */
	}
	
	public ContactsPage fillContactForm(String heading, String email, String reference, String message){
		Select select = new Select(headingDropdown);
				select.selectByVisibleText(heading);
		emailInput.sendKeys(email);
		OrderReference.sendKeys(reference);
		messageTextbox.sendKeys(message);
		return this;
	}
	
	public void submitMessage(){
		submitMessageButton.click();
	}
	
	public String getMessage(){
		return successMsg.getText();
	}
}
