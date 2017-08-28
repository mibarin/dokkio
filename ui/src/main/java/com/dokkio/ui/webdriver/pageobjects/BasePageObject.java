package com.dokkio.ui.webdriver.pageobjects;
import java.util.Iterator;
import java.util.Set;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait; 

public class BasePageObject {

	public WebDriver driver;
	public WebDriverWait waitFor;
	public Actions builder;
	private int timeOut = 30;

	public BasePageObject(WebDriver driver) {
		this.waitFor = new WebDriverWait(driver, timeOut);
		this.builder = new Actions(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void jsExecutorClick(WebElement e){
		JavascriptExecutor executor = (JavascriptExecutor)this.driver;
		executor.executeScript("arguments[0].click()", e);	  
	}
	
	public void jsExecutorSendKeys(WebElement e, String s){
		JavascriptExecutor executor = (JavascriptExecutor)this.driver;
		executor.executeScript("arguments[0].value='" + s + "'", e);	  
	}
	
	public void moveWindowHandle(){
		String parentHandle = driver.getWindowHandle(); 
		Set s = driver.getWindowHandles();
		Iterator ite = s.iterator();
		
		while(ite.hasNext()){
			String anotherWinHandle = ite.next().toString();
			if(!anotherWinHandle.contains(parentHandle)) {
				driver.switchTo().window(anotherWinHandle);				
			}
		}
	}
	
	public void jsExecutorscrollWindowTo(WebElement e){
		JavascriptExecutor executor = (JavascriptExecutor)this.driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", e);	  		
	}
	
	public void jsExecutorscrollDown(){
		JavascriptExecutor executor = (JavascriptExecutor)this.driver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");		
	}
}
