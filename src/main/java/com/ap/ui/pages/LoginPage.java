package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class LoginPage extends TestBase{

	
	//PageFactory
	@FindBy(id = "email")
	WebElement username;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(xpath = "//*[@id='SubmitLogin']/span")
	WebElement submitButton;
	
	@FindBy(xpath ="//img[@class='logo img-responsive']")
	WebElement apLogo;
	
public LoginPage(){
	PageFactory.initElements(driver, this);
}
	


public String verifypageTitle(){
	return driver.getTitle();
}
public boolean validateAPImage(){
	return apLogo.isDisplayed();
}
public HomePage login(String uname, String pass){
	username.sendKeys(uname);
	password.sendKeys(pass);
	submitButton.click();
	
	return new HomePage();
	
}

}
