package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.ContactsPage;
import com.ap.ui.pages.HomePage;

public class ContactTest extends TestBase {

	ContactsPage contactsPage;
	HomePage homePage;
	
	public ContactTest() {
		super();
	}
	
@BeforeMethod
public void setUpdriver(){
	initialization();
	contactsPage  = new ContactsPage();
	homePage = new HomePage();
	
}
@Test
public void testContact(){//sending the data to the application
	homePage.clickOnContactLink();
	contactsPage = contactsPage.fillContactForm("Customer service", "Random@test.com", "Testing", "This is for test purpose");
	contactsPage.submitMessage();
	String successMsg = contactsPage.getMessage();
	Assert.assertEquals(successMsg, "Your message has been successfully sent to our team.");
}

@AfterMethod
public void teardown(){
	driver.close();
}

}
