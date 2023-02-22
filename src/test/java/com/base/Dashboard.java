package com.base;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Dashboard extends BasePage{
	
	AppiumDriver<?> driver;

	@AndroidFindBy(xpath = "(//*[@id='navigation_bar_item_icon_view'])[5]")
	public MobileElement btnLeagues;

	@AndroidFindBy(xpath = "//*[@text='Leagues' and @id='titleTextView']")
	public MobileElement txtHeader;
	
	@AndroidFindBy(xpath = "//*[@contentDescription='Navigate up' and @class='android.widget.ImageButton']")
	public MobileElement btnBack;

	@AndroidFindBy(xpath = "//*[@text='STANDINGS']")
	public MobileElement tabStandings;
	


	public Dashboard(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	

	public void clickOnLeagues() throws InterruptedException {
		if (isElementDisplayed(btnLeagues))
		   clickonElement(btnLeagues);
		
	}

	public void validateHeader() throws InterruptedException {
		if (isElementDisplayed(txtHeader))
			asserEqual(txtHeader, "Leagues");
		
	}
	
	public void clickOnBack() throws InterruptedException {
		if (isElementDisplayed(btnBack))
			   clickonElement(btnBack);
	}
	
	public void clickStandings() throws InterruptedException {
		if(isElementDisplayed(tabStandings))
			clickonElement(tabStandings);
	}
	
	public String validateSelectedTab(String tabName) {
		return getDriver().findElement(By.xpath("//*[@text='"+tabName+"']")).getAttribute("selected");
	}
	
	public void selectLeague() {
		Object[][] data =readTestData("League");
		Map map= (Map) data[0][0];
		MobileElement e= (MobileElement) getDriver().findElement(By.xpath("//*[@id='league_name_text' and @text='"+map.get("LeagueType").toString()+"']"));
		e.click();
	}
	
	
}
