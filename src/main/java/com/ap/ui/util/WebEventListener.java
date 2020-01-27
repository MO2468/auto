package com.ap.ui.util;
import java.io.IOException;

/*
 * WE have created this class- WebDriverEventListener in order to implement interface is to override 
 * all the methods and define certain helpful log actions which would be displayed/logged as the app under
 * test is being executed. these methods will be invoked by itself automatically when certain actions are performed.
 * Ex: click, submit, screenshot, findBy etc  
  */
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.ui.base.TestBase;

public  class WebEventListener extends TestBase implements WebDriverEventListener {


public void beforeNavigateTo(String url, WebDriver driver) {
System.out.println("Before navigating to: '" + url + "'");
}

public void afterNavigateTo(String url, WebDriver driver) {
System.out.println("Navigated to:'" + url + "'");
}

public void beforeChangeValueOf(WebElement element, WebDriver driver) {
System.out.println("Value of the:" + element.toString() + " before any changes made");
}

public void afterChangeValueOf(WebElement element, WebDriver driver) {
System.out.println("Element value changed to: " + element.toString());
}

public void beforeClickOn(WebElement element, WebDriver driver) {
System.out.println("Trying to click on: " + element.toString());
}

public void afterClickOn(WebElement element, WebDriver driver) {
System.out.println("Clicked on: " + element.toString());
}

public void beforeNavigateBack(WebDriver driver) {
System.out.println("Navigating back to previous page");
}

public void afterNavigateBack(WebDriver driver) {
System.out.println("Navigated back to previous page");
}

public void beforeNavigateForward(WebDriver driver) {
System.out.println("Navigating forward to next page");
}

public void afterNavigateForward(WebDriver driver) {
System.out.println("Navigated forward to next page");
}

public void onException(Throwable error, WebDriver driver) {
System.out.println("Exception occured: " + error);
try {
TestUtil.takeScreenshotAtEndOftest();
} catch (IOException e) {
e.printStackTrace();
}
}

public void beforeFindBy(By by, WebElement element, WebDriver driver) {
System.out.println("Trying to find Element By : " + by.toString());
}

public void afterFindBy(By by, WebElement element, WebDriver driver) {
System.out.println("Found Element By : " + by.toString());
}

/*
* non overridden methods of WebListener class
*/
public void beforeScript(String script, WebDriver driver) {
}

public void afterScript(String script, WebDriver driver) {
}

public void beforeAlertAccept(WebDriver driver) {
// TODO Auto-generated method stub

}

public void afterAlertAccept(WebDriver driver) {
// TODO Auto-generated method stub

}

public void afterAlertDismiss(WebDriver driver) {
// TODO Auto-generated method stub

}

public void beforeAlertDismiss(WebDriver driver) {
// TODO Auto-generated method stub

}

public void beforeNavigateRefresh(WebDriver driver) {
// TODO Auto-generated method stub

}

public void afterNavigateRefresh(WebDriver driver) {
// TODO Auto-generated method stub

}

public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
// TODO Auto-generated method stub

}

public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
// TODO Auto-generated method stub

}

public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
// TODO Auto-generated method stub

}

public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
// TODO Auto-generated method stub

}

public void afterSwitchToWindow(String arg0, WebDriver arg1) {
// TODO Auto-generated method stub

}

public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
// TODO Auto-generated method stub

}

public void beforeGetText(WebElement arg0, WebDriver arg1) {
// TODO Auto-generated method stub

}

public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
// TODO Auto-generated method stub

}

}
	
	/*public void beforeNavigate(String url, WebDriver driver){
		System.out.println("Before navigate to: '"+ url +"'");
	}
	public void afterNavigate(String url, WebDriver driver){
		System.out.println("Navigate to: '"+ url +"'");
	}
	
	public void beforeChangeValueof(WebElement element, WebDriver driver){
		System.out.println("Value of: "+ element.toString() +" before making any change");
	}
	public void afterChangeValueof(WebElement element, WebDriver driver){
		System.out.println("Element Value changed to: "+ element.toString());
	}
	
	public void beforeClickingOn(WebElement element, WebDriver driver) {
		System.out.println("Attempting to click on: " + element.toString());
		
	}
	public void afterClickingOn(WebElement element, WebDriver driver) {
		System.out.println("Successfully clicked on: " + element.toString());
		
	}
		
	public void beforeNavigatingback(WebDriver driver) {
		System.out.println("Attempting Navigating back to previous page");
		
	}
	public void afterNavigatingback(WebDriver driver) {
		System.out.println("Successfully Navigating to current page");
	
	}
		
	public void beforeNavigatingforward(WebDriver driver) {
			System.out.println("Attempting Navigating forward to next page");
			
		}
	public void afterNavigatingforward(WebDriver driver) {
			System.out.println("Successfully Navigating forward to next page");
		
		}
	
	public void dueToException(Throwable error, WebDriver driver){
			System.out.println("Exception occured: "+ error);
		try {
			TestUtil.takeScreenshotAtEndOftest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	
	public void beforeFindBy(By by,WebElement element,  WebDriver driver) {
		System.out.println("Attempting to find the element: "+ by.toString());
		
	}
	public void afterFindBy(By by,WebElement element, WebDriver driver) {
		System.out.println("Successfully found the element: "+by.toString());
	
	}

	//THESE ARE NON-OVERRIDDEN METHODS OF THE WEBLISTENER CLASS	
	//all of these are never used more than once, that's why they are not over-ridden
	public void beforeScript(String script,WebDriver driver ){
		
	}
	public void afterScript(String script,WebDriver driver ){
		
	}
	
		
	public void beforeAcceptingAlert(WebDriver driver ){
		
	}
	public void afterAcceptingAlert(WebDriver driver ){
		
	}

	public void beforeDismissingAlert(WebDriver driver ){
		
	}
	public void afterDismissingAlert(WebDriver driver ){
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		
	}
	public void afterNavigateRefresh(WebDriver driver) {
		
	}

	public void beforeChangeValueof(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
	}
	public void afterChangeValueof(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
	}

	public <X> void beforeGetScreenshotsAs(OutputType<X> arg0){
		
	}
	public <X> void afterGetScreenshotsAs(OutputType<X> arg0, X arg1){
		
	}
	
	public void beforeGetText(WebElement arg0, WebDriver arg1){
		
	}
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2){
		
	}

	public void beforeSwitchToWindow(String arg0,WebDriver arg1 ){
		
	}
	public void afterSwitchToWindow(String arg0,WebDriver arg1 ){
		
	}
	public void afterAlertDismiss(WebDriver driver){
		
	}
	public void afterAlertAccept(WebDriver driver){
		
	}
	}
*/
	

