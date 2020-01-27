package com.ap.ui.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListener;
public class TestBase {
//setting up Property value::
	public static WebDriver driver;
	public static Properties propt;
	public static EventFiringWebDriver en_driver;//initiate the webdriver
	public static WebEventListener eventListener;
	
//sends the event thats takes place in the extent reporter
	/**EventFiringWebDriver is a class and is used to wrap your webdriver around to throw events 
	 * and WebDriverEventListner is an interface which you have to implement to catch the webdriver events.
	 
	 *WORKING WITH A CONSTRUCTION- THAT (PUBLIC TESTBASE(){} IS WORKING WITH THE BLUEPRINT OF THE PUBLIC 
	 *CLASS TESTBASE{...} BY USING THE OBJECT propt= new Properties  then i'm telling the script to 
	 *get the data from the file in the package by using the fileinputstream and then, use the object from the class INITIATED BY THE CONSTRUCTOR, AND use a built in method
*AND CONNECT WITH THE OBJECT WHICH CAN DIRECT TO THE FILE IN THE PACKAGE*/	
	public TestBase(){
		try {
		propt = new Properties();
FileInputStream ipa = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/ap/ui/config/config.properties");
	//FileInputStream ipa = new FileInputStream(System.getProperty("C:\\Users\\MHasan\\Downloads\\Prosmart\\chromedriver.exe"));
		propt.load(ipa);//Reads a property list (key and element pairs) from the inputebyte stream.
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("No file found");
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
	public static void initialization(){//creating a method to open up a browser according to the config.property File
		String browserName = propt.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe"));
			driver  = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.chrome.driver", "location");
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "location");
			driver = new InternetExplorerDriver();
		}				
		/**deals with all the events instead of calling the driver, we call object
		 * this object is holding my events - pass,fail,skip/assert & verify
		 * CREATING AN OBJECT FOR ACTION THAT'S OCCURING AND SHARING WITH DRIVER*/
		en_driver = new EventFiringWebDriver(driver);		
		//to catch the events		
		//////CREATE OBJECT OF WEBLISTENER TO REGISTER WITH EventFiringWebDriver
		eventListener = new WebEventListener();
		/////EVENTS CAN BE CAPTURED 
		// object holding information, events(the passed, or failed).
				//event can be captured based on the method we create webeventlistener class
		en_driver.register(eventListener);
		////since we driver object is for browser en_driver is for event. we declaring with equal to each when they are exchanging the information.
		driver = en_driver;
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//testUtil class needs to have this data for this class to access
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load, TimeUnit.SECONDS);
		driver.get(propt.getProperty("url"));		
		}
}
