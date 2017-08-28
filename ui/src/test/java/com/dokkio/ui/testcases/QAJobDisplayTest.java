package com.dokkio.ui.testcases;

//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dokkio.common.contentpatterns.PageContents;
import com.dokkio.common.urls.URLs;
import com.dokkio.ui.pageattributes.CSSValues;
import com.dokkio.ui.webdriver.pageobjects.JobPage;

import junit.framework.Assert;

public class QAJobDisplayTest {

	private WebDriver driver;
	private JobPage jp;	
	private String browser;
		
	@BeforeTest
	@Parameters("browser")
	public void SetUp(String browser) throws Exception{	
		this.browser = browser;
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\webdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();	
		driver.get(URLs.DOKKIOHOME);		
		jp = new JobPage(driver);
		jp.moveToJobs();
	}
	
	@Test(priority = 1)
	public void SRFSEntineerShownByDefaultTest() throws InterruptedException{
		Assert.assertEquals(jp.getActiveJobTitle(), PageContents.FULLSTACKENGINEER_SR);
		Assert.assertTrue(jp.getQABtnColor().contains(CSSValues.JOBBUTTONNOTSELECTEDBGCOLOR));
	}
	
	@Test(priority = 2)
	public void QAJobDisplayedAfterButtonClickedTest() throws InterruptedException{
	    jp.clickQABtn();
		Assert.assertEquals(jp.getActiveJobTitle(), PageContents.QAENGINEER);
		Assert.assertTrue(jp.getQABtnColor().contains(CSSValues.JOBBUTTONSELECTEDBGCOLOR));
	}	

	@AfterTest
	public void TearDown(){
		driver.quit();
	}


}
