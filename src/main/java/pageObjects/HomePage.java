package pageObjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import resources.BaseClass;

public class HomePage extends BaseClass {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String parentId;
	public String childId;
	public String parentId1;
	public String childId2;
	public String title;

	
	By createButton = By.xpath("//div[@id='createNewButton']/span");
	By selectTitle = By.xpath("//a[@class='menuButtonMenuLink firstMenuItem eventMru']");
	By selectSubjectIcon = By.xpath("//img[@class='comboboxIcon']");
	By selectSubject = By.xpath("//li[@class='listItem0']/a");
	By selectAttachBtn = By.xpath("(//input[@class='btn'])[9]");
	By selectAttachFileBtn = By.xpath("//table/tbody/tr[7]/td[2]/input");
	By selectDoneBtn = By.xpath("(//input[@class='btn'])[2]");
	By selectEditBtn = By.xpath("(//input[@class='btn'])[2]");
	By selectDate = By.xpath("//table/tbody/tr[4]/td[7]");
	By selectSaveBtn = By.xpath("(//input[@class='btn'])[1]");
	By selectEvent = By.xpath("//span[@class='mruText']");
	By selectDeleteBtn = By.xpath("(//input[@name='delete'])[1]");
	
	
	@BeforeTest
	public void initialize() throws IOException {
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
	}
	
	public void getTitleText_1() {
		title=driver.getTitle(); 
	}
	
	
	public void getTitleText() throws InterruptedException {
		System.out.println(title);
		if(title.contains("Home Page ~ Salesforce - Developer Edition")) {
			driver.findElement(By.xpath("//a[@title='Home Tab']")).click();
			Thread.sleep(5000);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ESCAPE).build().perform();
			
		} else {
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[@class='uiImage'])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='profile-link-label switch-to-aloha uiOutputURL']")).click();
			Thread.sleep(3000);
		}
	}
	
	public WebElement getCreateButton() {
		return driver.findElement(createButton);
	}
	
	public WebElement getEventTitle() {
		return driver.findElement(selectTitle);
	}
	
	public WebElement getSubjectIcon() {
		return driver.findElement(selectSubjectIcon);
	}
	
	public void getSubject() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();
		parentId = iterate.next();
		childId = iterate.next();
		driver.switchTo().window(childId);
		Thread.sleep(2000);
		driver.findElement(selectSubject).click();
//		driver.close();
//	}
//	
//	public void getSwitchWindow() {
//		driver.close();
		driver.switchTo().window(parentId);
	}
	
	public WebElement getAttachBtn() {
		return driver.findElement(selectAttachBtn);
	}
	
	public void getAttachFileBtn() throws InterruptedException {
		Set<String> windows1 = driver.getWindowHandles();
		Iterator<String> iterate1 = windows1.iterator();
		String parentId1 = iterate1.next();
		String childId1 = iterate1.next();
		driver.switchTo().window(childId1);
		Thread.sleep(3000);
		driver.findElement(selectAttachFileBtn).click();
//	}
	
//	public WebElement getDoneBtn() {
		driver.findElement(selectDoneBtn).click();
		driver.switchTo().window(parentId1);
	}
//	}
	
	public void getRecentItems() {
		
		WebElement storeRecentEle = driver.findElement(By.xpath("//div[@class='mruItem']"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(storeRecentEle).perform();
	}
	
	public WebElement getEditbutton() {
		return driver.findElement(selectEditBtn);
	}
	
	public void getDatePicker() {
		WebElement storeRecentDate = driver.findElement(By.xpath("//input[@id='tsk4']"));
		Actions act3 = new Actions(driver);
		act3.moveToElement(storeRecentDate).click().perform();
	}
	
	public WebElement getDate() {
		return driver.findElement(selectDate);
	}
	
	public WebElement getSaveBtn() {
		return driver.findElement(selectSaveBtn);
	}
	
	public WebElement getEventBtn() {
		return driver.findElement(selectEvent);
	}
	
	public WebElement getDeleteBtn() {
		return driver.findElement(selectDeleteBtn);
	}
	
	public String getRecordExistenceDetails() {
		String storeText = driver.findElement(By.xpath("//div[@class='mruItem']")).getText();
		return storeText;
	}
	
	public void getClose() {
		driver.close();
	}
	
}

