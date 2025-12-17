package com.crm.BaseClass;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.crm.FileUtility.ReadProperty;

public class MasterBase extends ReadProperty{

	public static WebDriver dr= null;
	

	public static void mpreCondition(){
		
		try {
		String browser=propertiesFile("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			dr= new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			dr= new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("IE")) {
			dr=new InternetExplorerDriver();
		}
		else if (browser.equalsIgnoreCase("safari")) {
			dr= new SafariDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			dr= new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase(propertiesFile("browser"))){
			dr= new ChromeDriver();
		}
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		dr.get(propertiesFile("url"));
		}catch (IOException e) {
			
		}
	}
	public static void mpostConditions() {
		dr.quit();
	}
}
