package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class testCasesForLoginPage extends BaseClass {

	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void testCases() throws InterruptedException {
		
		LoginPage lip = new LoginPage(driver);
		lip.getUsername().sendKeys("hari.radhakrishnan@qeagle.com");
		lip.getPassword().sendKeys("Tuna@123");
		lip.getLoginBtn().click();
		
		HomePage hp = new HomePage(driver);
		hp.getTitleText_1();
		hp.getTitleText();
		hp.getCreateButton().click();
		hp.getEventTitle().click();
		hp.getSubjectIcon().click();
		hp.getSubject();
//		hp.getSwitchWindow();
		Thread.sleep(2000);
		hp.getAttachBtn().click();
		hp.getAttachFileBtn();
//		hp.getDoneBtn().click();
		hp.getRecentItems();
		hp.getEditbutton().click();
		hp.getDatePicker();
		hp.getDate().click();
		hp.getSaveBtn().click();
		hp.getEventBtn().click();
		hp.getDeleteBtn().click();
		String recordExistense = hp.getRecordExistenceDetails();
		
		if(recordExistense.equals("No records to display")) {
			System.out.println("Event Delete");
		} else {
			System.out.println("Even Present");
		}
	}
}
