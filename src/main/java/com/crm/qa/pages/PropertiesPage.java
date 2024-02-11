package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
public class PropertiesPage extends TestBase{

	public PropertiesPage() {

		PageFactory.initElements(driver,this);
	}

	List<Integer> pricelist=new ArrayList<Integer>();

	@FindBy(xpath="//h1[contains(text(),'Properties for sale in London')]")
	public WebElement locationTitle;

	@FindBy(xpath="//div[contains(@id,'listing_')]//p[contains(text(), '£') and @data-testid='listing-price' ]")
	public List<WebElement> PropertiesPricelist;


	public boolean verifyLocation() {
		boolean a=locationTitle.getText().contains(prop.getProperty("location"));
		return a;
	}

	public void sortedPricelist() {
		for(WebElement price:PropertiesPricelist)
		{
			if(price.getText().replaceAll("[^0-9]", "").isEmpty())
			{
				System.out.println("This property has price printed as"+price.getText()+"so it is not added in list");
			}
			else
				pricelist.add(Integer.parseInt(price.getText().replaceAll("[^0-9]", "")));

		}
		System.out.println("List of price of properties in descending order");
		Collections.sort(pricelist,Collections.reverseOrder());
		System.out.println(pricelist);
		}
	public PropertyDetailsPage getPropertyByPosition(int position) {

		PropertiesPricelist.get(position).click();
		
		return new PropertyDetailsPage();
	}
}














