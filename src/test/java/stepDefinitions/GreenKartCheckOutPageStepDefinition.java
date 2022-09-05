package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestBase;
import utils.TestContextSetup;

public class GreenKartCheckOutPageStepDefinition{
	public WebDriver driver;
	public String landingPageproductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	public CheckoutPage checkOutPage;
	LandingPage landingPage;
	
	public GreenKartCheckOutPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.checkOutPage= testContextSetup.pageObjectManager.getCheckOutPage();
		this.landingPage= testContextSetup.pageObjectManager.getLandingPage();
	}
	
	 @And("^Verify user has ablity to enter promo code and place the order$")
	    public void verify_user_has_ablity_to_enter_promo_code_and_place_the_order() throws Throwable {
	    	
	    	Assert.assertTrue(checkOutPage.verifyPromoBtn());
	        Assert.assertTrue(checkOutPage.verifyPlaceOrder());
	        checkOutPage.clickonPlaceorderbutton();
	        checkOutPage.selectCountry();
	        checkOutPage.selectCheckbox();
	        checkOutPage.clickonProceedbutton();
	        //testContextSetup.testBase.WebDriverManager().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      Thread.sleep(10000);
	    }
	 
	 @And("^Verify user has ablity to enter promo code and place the order without accepting terms and conditions$")
	    public void verify_user_has_ablity_to_enter_promo_code_and_place_the_order_without_accepting_terms_and_conditions() throws Throwable {
	    	
	    	Assert.assertTrue(checkOutPage.verifyPromoBtn());
	        Assert.assertTrue(checkOutPage.verifyPlaceOrder());
	        checkOutPage.clickonPlaceorderbutton();
	        checkOutPage.selectCountry();
	        checkOutPage.clickonProceedbutton();
	        Assert.assertTrue(checkOutPage.verifyTermsandConditions());
	        System.out.println(checkOutPage.displayTermsandConditionsText());
	     
	    }
	
	@Then("^User proceed to Checkout and validate the (.+) items in checkout page$")
    public void user_proceed_to_checkout_and_validate_the_items_in_checkout_page(String name) throws Throwable {
		checkOutPage.checkoutItems();
		
    }
	
	@And("^Verify the user is redirected on GREENKART landing page after place the order$")
    public void verify_the_user_is_redirected_on_greenkart_landing_page_after_place_the_order() throws Throwable {
		System.out.println(testContextSetup.testBase.WebDriverManager().getCurrentUrl());
		System.out.println(testContextSetup.testBase.getWebsiteURL().getProperty("url"));  
		Assert.assertTrue(testContextSetup.testBase.WebDriverManager().getCurrentUrl().equals(testContextSetup.testBase.getWebsiteURL().getProperty("url")));

    }

   
}
