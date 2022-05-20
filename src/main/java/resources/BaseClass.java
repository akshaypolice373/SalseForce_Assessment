package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Java\\SalesForceAssessment_1\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		if(browserName.equals("chrome")) {
			
//			Chrome
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			
		} else if(browserName.equals("firefox")) {			
//			Firefox
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
		} else if(browserName.equals("IE")) {
//			Edge
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
	}
}
