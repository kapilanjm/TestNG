package org.booking.functionality;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.pom.page.*;
import org.testng.annotations.*;

public class Mynthra extends MynthraElements {
	MynthraElements m;
	Date a;
	@BeforeClass
	public void beforeClass() {
		browserLanuch("chrome");
		time(10);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		a=new Date();
		System.out.println("Start Time"+a);
	}
	
	@Parameters("Shirts")
	@Test(priority = 1)
	public void formalShirtsForMen(String shirt) throws InterruptedException {
		m=new MynthraElements();
		urlLaunch("https://www.myntra.com/");
		sendKeys(m.getSearchTB(), shirt);
		clicks(m.getSearchIcon());
		List<WebElement> productMeta = m.getProductMeta();
			WebElement product = productMeta.get(1);
			clicks(product );
		switchToUrl();
		swithToNewUrl();
		List<WebElement> sizes = m.getSizes();
			WebElement size = sizes.get(1);
			clicks(size);
		clicks(m.getAddToBag());
		clicks(m.getBag());
		switchToUrl();
		swithToNewUrl();
		jsFalse(m.getPlaceOrder());
		jsClick(m.getPlaceOrder());
		switchToUrl();
		swithToNewUrl();
		Thread.sleep(2000);
		
	}
	
	@Parameters("Pants")
	@Test(priority = 2)
	public void formalPantsForMen(String pants) throws InterruptedException {
		m=new MynthraElements();
		urlLaunch("https://www.myntra.com/");
		sendKeys(m.getSearchTB(), pants);
		clicks(m.getSearchIcon());
		List<WebElement> productMeta = m.getProductMeta();
			WebElement product = productMeta.get(1);
			clicks(product );
		switchToUrl();
		swithToNewUrl();
		List<WebElement> sizes = m.getSizes();
			WebElement size = sizes.get(1);
			clicks(size);
		clicks(m.getAddToBag());
		clicks(m.getBag());
		switchToUrl();
		swithToNewUrl();
		jsFalse(m.getPlaceOrder());
		jsClick(m.getPlaceOrder());
		switchToUrl();
		swithToNewUrl();
		Thread.sleep(2000);
		
	}
	
	@Parameters("Shoes")
	@Test(priority = 3)
	public void formalShoesForMen(String shoes) throws InterruptedException {
		m=new MynthraElements();
		urlLaunch("https://www.myntra.com/");
		sendKeys(m.getSearchTB(), shoes);
		clicks(m.getSearchIcon());
		List<WebElement> productMeta = m.getProductMeta();
			WebElement product = productMeta.get(1);
			clicks(product );
		switchToUrl();
		swithToNewUrl();
		List<WebElement> sizes = m.getSizes();
			WebElement size = sizes.get(1);
			clicks(size);
		clicks(m.getAddToBag());
		clicks(m.getBag());
		switchToUrl();
		swithToNewUrl();
		jsFalse(m.getPlaceOrder());
		jsClick(m.getPlaceOrder());
		switchToUrl();
		swithToNewUrl();
		Thread.sleep(3000);
	
	}
	
	@AfterMethod
	public  void AfterMethod() {
		a=new Date();
		System.out.println("Start Time"+a);
	}
	
	@AfterClass
	public void afterClass() {
		quit();
	}
	

}
 