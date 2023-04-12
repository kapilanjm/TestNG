package org.pom.page;
import java.util.List;

import org.baseclass.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MynthraElements extends BaseClassForEcommerce {
	public MynthraElements() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getS() {
		return s;
	}

	public WebElement getSearchTB() {
		return SearchTB;
	}

	public WebElement getSearchIcon() {
		return SearchIcon;
	}

	public WebElement getSearchList() {
		return SearchList;
	}

	public List<WebElement> getProductBase() {
		return ProductBase;
	}
	
	public WebElement getPeterEnglandMaroon() {
		return PeterEnglandMaroon;
	}

	public List<WebElement> getProductMeta() {
		return productMeta;
	}
	
	public List<WebElement> getProductBrand() {
		return productBrand;
	}

	public List<WebElement> getProductAmount() {
		return productAmount;
	}

	public List<WebElement> getSizes() {
		return Sizes;
	}

	public WebElement getAddToBag() {
		return AddToBag;
	}

	public WebElement getBag() {
		return Bag;
	}

	public WebElement getCheckCartLink() {
		return CheckCartLink;
	}

	public WebElement getPlaceOrder() {
		return PlaceOrder;
	}
	
	@CacheLookup
	@FindBy(xpath="")
	private WebElement s;
	
	@CacheLookup
	@FindBy(xpath="//input[@class='desktop-searchBar' or @placeholder='Search for products, brands and more' and @data-reactid='907']")
	private WebElement SearchTB;
	
	@CacheLookup
	@FindBy(xpath="//a[@class='desktop-submit' or @data-reactid='908']")
	private WebElement SearchIcon;
	
	@CacheLookup
	@FindBy(xpath="//li[@class='desktop-suggestion null' ]")
	private WebElement SearchList;
	
	@CacheLookup
	@FindBy(xpath="//li[@class='product-base']")
	private List<WebElement> ProductBase;
	
	@FindBy(partialLinkText ="https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/19434992/2022/8/8/13054f01-4fee-41be-b1b5-0b706fe24ed41659959632982MenMaroonFullSleevesFormalShirt1.jpg")
	private WebElement PeterEnglandMaroon;
			
	@CacheLookup
	@FindBy(className ="product-productMetaInfo")
	private List<WebElement> productMeta;
	
	@FindBy(xpath = "//h3[@class='product-brand']")
	private List<WebElement> productBrand;
	
	@CacheLookup
	@FindBy(className="product-discountedPrice")
	private List<WebElement> productAmount;
	
	@CacheLookup
	@FindBy(xpath="//div[@class='size-buttons-buttonContainer']")
	private List<WebElement> Sizes;
	
	@CacheLookup
	@FindBy(xpath="//div[contains(text(),'ADD TO BAG')]")
	private WebElement AddToBag;
	
	@CacheLookup
	@FindBy(xpath="//span[text()='Bag']")
	private WebElement Bag;
	
	@CacheLookup
	@FindBy(partialLinkText = "/checkout/cart")////a[contains(@href,'/checkout/cart')]
	private WebElement CheckCartLink;
	
	@CacheLookup
	@FindBy(xpath="//div[text()='PLACE ORDER']")
	private WebElement PlaceOrder;

}
