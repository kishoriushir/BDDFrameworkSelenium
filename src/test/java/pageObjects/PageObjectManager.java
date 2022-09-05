package pageObjects;

import org.openqa.selenium.WebDriver;
//Factory Design Pattern to create object of page object classes

public class PageObjectManager {
	public LandingPage landingPage;    // LandingPage class variable
	public OfferPage offerPage;    // OfferPage class variable
	public WebDriver driver;
	public CheckoutPage checkOutPage; //CheckoutPage class variable
	
	//constructor
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	public LandingPage getLandingPage() {
		landingPage=new LandingPage(driver); //created object of LandingPage class and assigned it to landingpage variable
		return landingPage;
	}
	public OfferPage getOfferpage() {
		return offerPage = new OfferPage(driver);  //created object of OfferPage class and assigned it to offerpage variable
	}
	public CheckoutPage getCheckOutPage() {
		return checkOutPage= new CheckoutPage(driver); //created object of CheckoutPage class and assigned it to checkOutPage variable
	}
}
