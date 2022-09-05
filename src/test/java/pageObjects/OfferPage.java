package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	
		WebDriver driver;
		public OfferPage(WebDriver driver)
		{
			this.driver=driver;
			
		}
		
	//element locator	
	private By search = By.xpath("//input[@type='search']");
	private By offerPageProductName=By.cssSelector("tr td:nth-child(1)");
	 
	 
	 
	 //methods
	
	 public void searchItem(String name) {
		 driver.findElement(search).sendKeys(name);
	 }
	 public void getSearchText(String name) {
		 driver.findElement(search).getText();
	 }
	 public String getofferpageProductName() {
		 return driver.findElement(offerPageProductName).getText();
		  
	 }
	 
	 
	}


