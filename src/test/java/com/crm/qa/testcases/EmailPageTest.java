package com.crm.qa.testcases;
                                                                                                                                                    
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AgentsPage;
import com.crm.qa.pages.EmailPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PropertiesPage;
import com.crm.qa.pages.PropertyDetailsPage;
import com.crm.qa.utilities.TestUtil;

public class EmailPageTest extends TestBase {
	AgentsPage agentsPage;

	PropertyDetailsPage propertydetailspage;
	PropertiesPage propertiespage;
	LoginPage loginpage;
	EmailPage emailPage;
	String sheetName="EmailEnquiry";
	public EmailPageTest() {
		super();
	}
	
@BeforeMethod
public void setUp() {
	TestBase.initialization();
	propertydetailspage=new PropertyDetailsPage();
	emailPage =new EmailPage();
	
	
	
	/*agentsPage=new AgentsPage();
    propertiespage=	loginpage.enterLocation(prop.getProperty("location"));
	propertydetailspage=propertiespage.getPropertyByPosition(Integer.parseInt(prop.getProperty("position")));*/
	propertydetailspage.getEmailPage();
}

@DataProvider
public Object[][] getZooplaTestData(String sheetName)
{
	Object[][]data=TestUtil.getTestData(sheetName);
	return data;
}

@Test(dataProvider="getZooplaTestData")
public void sendEnquiryToAgent(String nme,String mail,String phon ,String post) {
	//emailPage.sendEnquiryToAgent("Ammu Smith", "aamunie23@gmail.com","9608765432", "AB1 2CD");
	emailPage.sendEnquiryToAgent(nme, mail, phon ,post); 
}

}
