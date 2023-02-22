package com.flows;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.base.Dashboard;



public class ValidateLeagueNavigation extends BasePage {

	Dashboard dashboard;

	@Test
	@Parameters ("platform")
	public void popThreeDots(String platform) throws InterruptedException, MalformedURLException {
		openDriver(platform);
		dashboard = new Dashboard(getDriver());
        dashboard.clickOnLeagues();
        dashboard.validateHeader();
        dashboard.clickStandings();
        Assert.assertTrue(Boolean.valueOf(dashboard.validateSelectedTab("STANDINGS")));
        dashboard.clickOnBack();
        
        dashboard.validateHeader();
        
        
	

	}

	@AfterTest
	public void closeDriver() {
		quitDriver();
	}

}
