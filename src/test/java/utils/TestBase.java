package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public WebDriver driver;
	
	//Created method to invoke driver and use this method to call whenever driver is needed to invoke.
public WebDriver WebDriverManager() throws IOException {
	Properties prop = getWebsiteURL();
	String URL=prop.getProperty("url");
	
	if (driver==null) {
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");//here paste the chromedriver in resources folder and give the dynamic path
	driver =new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	driver.get(URL);
	}
	return driver;
}
//created method to load properties from global.properties file..like URL  
public Properties getWebsiteURL() throws FileNotFoundException, IOException {
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");// here we give the dynamic project path concatenate with path of global.properties file so it run in any system. 
	Properties prop= new Properties();
	prop.load(fis);
	return prop;
}
}
