package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String landingPageproductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	//TestContextSetup class to define or tell this class all the variables,properties in this class
	//which you going to share with another step definition file
	//here in test base-driver, pageObjectManager-all the objects of pages and generic util -switchtoWindow method.
	public TestContextSetup() throws IOException {
		testBase=new TestBase();
		pageObjectManager=new PageObjectManager(testBase.WebDriverManager());
		genericUtils =new GenericUtils(testBase.WebDriverManager());
	}

}
