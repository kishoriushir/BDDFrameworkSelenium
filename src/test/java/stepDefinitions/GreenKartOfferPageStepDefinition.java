package stepDefinitions;

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
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestBase;
import utils.TestContextSetup;

public class GreenKartOfferPageStepDefinition{
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	
	
	public GreenKartOfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Then("^User search for (.+) shortname in offer page$")
	public void user_search_for_same_shortname_in_offer_page(String shortName) throws InterruptedException {
		 switchToOfferPage(); //here just call the method to use that code present in method
		 OfferPage offerpage=testContextSetup.pageObjectManager.getOfferpage();
		 offerpage.searchItem(shortName);
	   Thread.sleep(2000); 
	   offerPageProductName=offerpage.getofferpageProductName();
	   
	   System.out.println(offerPageProductName +" is extracted from offer page");
	}
	//single Responsibility Principle
	//Create method for reusable code instead of writing again and again or restriction it into particular stepdef
	public void switchToOfferPage() {
		
		// here created LandingPage class object and define TopDeals locator in LandingPage pageobject file beacuase it comes from landing page not offerpage.
		LandingPage landingpage= testContextSetup.pageObjectManager.getLandingPage();
		landingpage.selectTopDealPage();
		testContextSetup.genericUtils.switchWindowToChild();
		   
	}
	@And("^Validate product name in offerpage matches with landing page$")
    public void validate_product_name_in_offerpage_matches_with_landing_page() throws Throwable {
		
        Assert.assertEquals(testContextSetup.landingPageproductName, offerPageProductName);
       
        
        
        
    }
}
