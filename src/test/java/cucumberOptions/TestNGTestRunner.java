package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/test/java/features",
glue="stepDefinitions",
monochrome=true,
tags="@placeOrder or @searchProductsandOffersPage or @placeOrderwithoutselectingtermsandconditions ",
plugin= {"html:target/cucumberhtmlReport.html","json:target/cucumberjsonReport.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarions.txt"
		}

)
//To execute all scenarios parallely
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=true)
	public Object [][] scenarios()
	{
		return super.scenarios();
	}

}

