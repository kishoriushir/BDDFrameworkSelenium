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
import pageObjects.PageObjectManager;
import utils.TestBase;
import utils.TestContextSetup;

public class GreenKartLandingPageStepDefinition{
	public WebDriver driver;
	public String landingPageproductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landingPage;
	
	public GreenKartLandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.landingPage= testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GREENKART landing page")
	public void user_is_on_greenkart_landing_page() {
	
	   // here without any code for driver its running because before execute any method from this class first it executed constructor and in that constructor we have manages driver invocation 
	   Assert.assertTrue(landingPage.getTitleofLandingPage().contains("GreenKart"));
	}
	
	@When("^User searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		landingPage.searchItem(shortName);
	    Thread.sleep(2000);
	  testContextSetup.landingPageproductName=landingPage.getProductName().split("-")[0].trim();
	    System.out.println(testContextSetup.landingPageproductName +" is extracted from Home page");
	}
	
	@And("Added {string} items of the selected product to cart")
    public void added_something_items_of_the_selected_product_to_cart(String quantity) throws Throwable {
     landingPage.IncrementQuantity(Integer.parseInt(quantity));// convert string into integer
     landingPage.addToCart();
    }
	
}
