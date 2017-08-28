# dokkio
Assignment #1:
Write an automated functional test that ensures that on dokkio.com, the QA Engineer job listing is 
not displayed until you click the “QA Engineer” button. Node.js preferred.

The assignment is written in Java.  Writing Java, I thought I could demonstrate more more concepts in testing.  I can quickly learn how to 
write a simple test in Node.js, but many concepts are hard to learn for me in short period of time.

I. File Structure:
 - src/test/java/com.dokkio.ui.testcases: for test files.  It has QAJobDisplayTest.java.  It consists of 2 tests.  One checks the default state,
                                          which is Full Stack Engineer is shown as a job title and QA button color is not selected.  It could have
                                          contain more checks, but I thought these checks are enough to demonstrate my skills.  
                                          Another test executes clicking "QA Enigneer" button.  It checks the page title and the color chnages of the QA
                                          button.  The tests run for FireFox and Chrome.
 - src/main/java: libraries for testing.  
     *com.dokkio.common.contentpatterns/PageContents.Java: It contains strings from the test page for testing. 
     *com.dokkio.common.urls/URLs.Java: It contains the dokkio page url.  
     *com.dokkio.ui.pageattributes: CSSValues.java: It contains CSS attributes from the page for testing.
     *com.dokkio.ui.webcriver.pageobjects: BasePageObjec.java: It defines basic objects and methods useful for any UI automation.
                                           DKBasePageObject.java: It defines common objects and methods necessary and specific to the dokkio page in general.
                                           JobPage.java: It defines objects and methods specific to the Job section of the page.
                                           
 - pom.xml: This is a Maven project and .jar file dependencies are defined to be automatically configured.
 - testng.xml: This is also a TestNG project. Browsers and test suite names are defined.
 
 II. Systems used for development:
  - jdk1.8.0_131
  - Windows7 x64 - used my company PC for my convenience.  Otherwise, it would be on OSX.
  - Eclipse Neon.3 Release (4.6.3)
  - TestNg 6.11
  - maven 3.5.0
  - chromedriver 2.27 win64: under C:\webdriver
  - geckodriver v0.17.0-win32 : under C:\webdriver
  - FireFox 55.0.3 (32-bit)
  - Chrome Version 60.0.3112.113 (Official Build) (64-bit)
  
 III. How to run after setting up your system according to II.
  1. In Eclipse, go to File > Open Projecs From File System after this repository is cloned to your system.
  2. Right click on testng.xml.  Select Run As > TestNG Suite.
 
 
 
