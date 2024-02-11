package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PropertiesPage;
import com.crm.qa.pages.PropertyDetailsPage;


public class PropertiesPageTest extends TestBase {
	PropertiesPage propertiespage;
	PropertyDetailsPage propertydetailspage;
	LoginPage loginpage;

	public PropertiesPageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() throws InterruptedException {
		TestBase.initialization();
		propertiespage=new PropertiesPage();
		
		loginpage=new LoginPage();
		propertiespage=	loginpage.enterLocation(prop.getProperty("location"));
	}
	
	
	
	@Test
	public void sortedPricelistTest() {
		propertiespage.sortedPricelist();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
}
}
