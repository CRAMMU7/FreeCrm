 package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PropertiesPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	PropertiesPage propertiespage;	
	LoginPageTest loginpagetest;
	public  LoginPageTest() {
		super();//constructor of parent class will be executed first
	}

	@BeforeMethod
	public void setUp() {
		TestBase.initialization();
    loginpagetest=new LoginPageTest();
    loginpage=new LoginPage();
	
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,"Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
		
	}
	@Test(priority=2)
	public void loginPageLogoTest() {
		boolean b=loginpage.validateLogo();
		Assert.assertTrue(b);
		
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException  {
		propertiespage=	loginpage.enterLocation(prop.getProperty("location"));
		Assert.assertTrue(propertiespage.verifyLocation());
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	

}
