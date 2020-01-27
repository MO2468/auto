package com.ap.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ap.ui.base.TestBase;

public class TestUtil extends TestBase {

	public static long Page_Load = 10;
	public static long Implicit_Wait = 10;
	/**
	 * go to the xl file, then the wb, and sheet 
	 */
	public static String XL_SHEET_PATH = "path  of the xl sheet";
	static Workbook book;
	static Sheet sheet;
	
	static JavascriptExecutor js;
	
	public static Object[] getTestData(String sheetName){
		/**handling scenario for excel file, look for value in the file
		 * creating arrays
		 * create a method
		 * it will have string, if there's no value, don't execute them
		 */
		FileInputStream file = null;
		try {
			file = new FileInputStream(XL_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}//handle the errors for file and workbook
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		/**
		 * create method to go to and bring the data from there
		 * getting the last row number to find out how many rows, and column i have in the file
		 * putting everything in String
		 */
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for(int j = 0; j <sheet.getRow(0).getLastCellNum(); j++){
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}
		return data;
	}
	
	public static void takeScreenshotAtEndOftest() throws IOException{
		/**
		 * to take the screenshot, creating a object for the directory
		 * going back to project directory and saving the screenshot with the timestamp in the folder "/screenshot/"
		 * "user.dir" means the directory of the project of this class
		 */
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDirect = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDirect+"/screenshot/"+System.currentTimeMillis()+".png"));
	}
	
	/**
	 * JQueries, how should the script handles different situations
	 * it will handle them by using conditional statements
	 * Capturing the events- error message/title/status; we can see some response what's happening
	 * it will show all the logs in applogs in the maven project, which developers cn understand to find out the defects/events 
	 */
	public static void runTimeInfo(String messageType, String message) throws InterruptedException{
		/** the console log consists of javascript language, so to translate them we need to use some website
		 * that's why we wrote the website in the executeScript method
		 * */
		js = (JavascriptExecutor) driver;
		js.executeScript("if (!window.JQuery){"
			+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+"jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
					+"document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		/**
		 * the process that's happening in between, it takes time, for that we need wait statement
		 */
		Thread.sleep(2000);
	
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
			//
		
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(6000);
		
		js.executeScript("$ growl({ title: 'GET' , message: '/'})");
		//retrieving information^
		
		if (messageType.equals("error")) {
			js.executeScript("$growl.error({ title: 'ERROR' message: '" + message +"'});");			
		} else if (messageType.equals("info")){
			js.executeScript("$growl.error({ title: 'Notice', message: 'your notice message will appear here'})");
		}else if (messageType.equals("warning")){
			js.executeScript("$growl.error({ title: 'Warning!!', message: 'your notice message will appear here'})");
		}else
			System.out.println("show NO Error Message");
			Thread.sleep(6000);
		
	}
	
	}	

