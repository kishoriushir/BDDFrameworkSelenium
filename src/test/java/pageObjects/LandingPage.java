package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	//Element Locator
 By search = By.xpath("//input[@type='search']");
 By productName=By.cssSelector("h4.product-name");
 By TopDeals=By.linkText("Top Deals");
 By Increment=By.cssSelector("a.increment");
 By addToCart =By.cssSelector(".product-action button");
 
 
 // methods
 public void searchItem(String name) {
	 driver.findElement(search).sendKeys(name);
 }
 public void getSearchText(String name) {
	 driver.findElement(search).getText();
 }
 public String getProductName() {
	 return driver.findElement(productName).getText();
	  
 }
 public void selectTopDealPage() {
	 driver.findElement(TopDeals).click();
	  
 }
 public void IncrementQuantity(int quantity) {
	 int i=quantity-1;
	 while(i>0) {
		 driver.findElement(Increment).click();
		 i--;	 
	 } 
 }
 public void addToCart() {
	 driver.findElement(addToCart).click();
 }
 public String getTitleofLandingPage() {
	 return driver.getTitle();
 }
}
