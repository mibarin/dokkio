package com.dokkio.ui.webdriver.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JobPage extends DKBasePageObject {

	@FindBy(css = ".iw-so-tabs-content > .iw-so-tab-active > .job-header > h3")
	protected WebElement activeJobDescTitle;

//	@FindBy(id = "Jobs-2") 
//id is the best for finding an element,but when job items increase in this case, link text is better and for sure
	@FindBy(linkText = "QA Engineer")
	protected WebElement QABtn;
	
	public JobPage(WebDriver driver) {
		super(driver);
	}
	
	public String getActiveJobTitle(){
		this.waitFor.until(ExpectedConditions.visibilityOf(activeJobDescTitle));
		return activeJobDescTitle.getText();
	}
	
	public String getQABtnColor(){
		this.waitFor.until(ExpectedConditions.visibilityOf(QABtn));
		return QABtn.getCssValue("background-color");
	}
	
	public void clickQABtn(){
		this.waitFor.until(ExpectedConditions.visibilityOf(QABtn));
		this.jsExecutorClick(QABtn);
	}

}
