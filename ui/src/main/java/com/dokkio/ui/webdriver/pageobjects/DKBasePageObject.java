package com.dokkio.ui.webdriver.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DKBasePageObject extends BasePageObject {

	
	@FindBy(css = "#menu-main-nav-1 > li:nth-of-type(2) > a")
	protected WebElement jobs;
	
	public DKBasePageObject(WebDriver driver) {
		super(driver);
	}
	
	public void moveToJobs(){
		this.jsExecutorClick(jobs);
	}
}
