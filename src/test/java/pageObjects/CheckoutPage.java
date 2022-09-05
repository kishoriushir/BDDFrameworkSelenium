package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	//element locator
 By cartBag = By.cssSelector("[alt='Cart']");
 By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
 By promoBtn= By.cssSelector(".promoBtn");
 By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
 By selectcountry=By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]");
		 //By.tagName("select");
//    By.xpath("//body/descendant::select")
 By selectcheckbox=By.xpath("//input[@type='checkbox']");
		 //By.tagName("input");
 By clickonproceedButton= By.xpath("//button[contains(text(),'Proceed')]");
 By accepttermsCondition=By.xpath("//b[contains(text(),'Please accept Terms & Conditions - Required')]");
 
 //methods
 public void checkoutItems() {
	 driver.findElement(cartBag).click();
	 driver.findElement(checkOutButton).click();
 }
 public boolean verifyPromoBtn() {
	return driver.findElement(promoBtn).isDisplayed();
 }
 public boolean verifyPlaceOrder() {
	 return driver.findElement(placeOrder).isDisplayed();
	 
 }
 public void clickonPlaceorderbutton() {
	 driver.findElement(placeOrder).click();
 }
 public void selectCountry() {
	 driver.findElement(selectcountry).sendKeys("ind");
	 
	 
 }
 public void selectCheckbox() {
	//driver.findElement(selectcheckbox).click();
	 boolean opt=driver.findElement(selectcheckbox).isSelected();
	 if(!(opt)) {
		 driver.findElement(selectcheckbox).click();
   	  
   	  System.out.println(" checkbox is selected");
     }
     else {
   	  System.out.println("checkbox is not selected");

     }
 }
 public void clickonProceedbutton() {
	 driver.findElement(clickonproceedButton).click();
 }
 public boolean verifyTermsandConditions() {
	 return driver.findElement(accepttermsCondition).isDisplayed();
 }
 public String displayTermsandConditionsText() {
	 return driver.findElement(accepttermsCondition).getText();
 }
}
