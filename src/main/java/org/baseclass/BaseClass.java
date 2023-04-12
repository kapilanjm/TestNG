package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static WebDriver driver;
	
	public static WebDriver lanuchChromeBro() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	public static WebDriver browserLanuch(String bname) {
		if (bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if (bname.equalsIgnoreCase("firebox")) {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();	
		}
		else if (bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		}
		return driver;	
	}
	
	public static void browserLaunch2(String bname) {
		switch(bname) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
			break;
		default:
			System.out.println("Invalid Browser");
		}

	}
	
	public static void refresh() {
		driver.navigate().refresh();
	}
	
	public static void switchToUrl() {
		String windowHandle = driver.getWindowHandle();
		
	}
	
	public static void swithToNewUrl() {
//		String windowHandle = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String allPage : windowHandles) {
//			if(!windowHandle.equals(allPage)) {
			driver.switchTo().window(allPage);
//			}
		
		}
	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
		 driver.manage().window().maximize();
	}
	 
	public static void time(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	
	}
	public static void pageScreenshot(String a) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File screenshotAs = tk.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\ADMIN\\eclipse-workspace\\org.mvn.base.three\\Screenshot\\"+a+".png");
		FileUtils.copyFile(screenshotAs, dest);
	}
	
	
	public static void screenshot(WebElement e,String a) throws IOException {
		
//		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = e.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\ADMIN\\eclipse-workspace\\org.mvn.base.three\\Screenshot\\"+a+".png");
		FileUtils.copyFile(src, dest);
	}
	
	public static String readExcel(String file,String sh,int r,int c) throws IOException {
		File f=new File("C:\\Users\\ADMIN\\eclipse-workspace\\TheLoginFunctionality\\src\\test\\resources\\Excel\\"+file+".xlsx");
		FileInputStream fd=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fd);
		Sheet sheet = wb.getSheet(sh);
		Row row = sheet.getRow(r);
		Cell cell = row.getCell(c);
		int cellType = cell.getCellType();
		String value=null;
		
		if(cellType==1) {
			 value = cell.getStringCellValue();
			
		}else {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date Dcv = cell.getDateCellValue();
				SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
				value = sdf.format(Dcv);
			}else {
				double Ncv = cell.getNumericCellValue();
				long cv=(long)Ncv;
				value = String.valueOf(cv);
			}
		}
		return value;	
	}
	
	public static void setDriver(WebDriver driver) {
		BaseClass.driver = driver;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void jsTrue(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);	
	} 
	
	public static void jsFalse(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", e);

	}
	public static void roEnter() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void roDown() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	public static void roPageDown() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	public static void roPageUp() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
	}
	public static Alert alertOk() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;
	}
	public static Alert alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return alert;
	}
	public static void moveToElements(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
	}
	public static void clickTarget(WebElement e) {
		Actions a=new Actions(driver);
		a.click(e).perform();
	}
	public static void selectByIndex(WebElement e,int a) {
		Select s=new Select(e);
		s.selectByIndex(a);
	}
	public static void deselectIndex(WebElement e,int a) {
		Select s=new Select(e);
		s.selectByIndex(a);	
	}
	
	public static void sendKeys(WebElement e,String value){
		e.sendKeys(value);
	}
	
	public static void clicks(WebElement e){
		e.click();
	}
	
	public static String urlCurrrent() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		
	}
	
	public static String title() {
		String title = driver.getTitle();
		return title;	
	}
	
	public static String text(WebElement e) {
		String text = e.getText();
		return text;
	}
	
	public static String valueAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;	
	}
	public static String innerText(WebElement e) {
		String attribute = e.getAttribute("innerText");
		return attribute;
		
	}	
	
	public static void quit() {
		driver.quit();
	}
	

}
