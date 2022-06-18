package OtherUS;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0773_PDFDownload {

	public static void main(String[] args) throws InterruptedException {
//		1. Launch Salesforce application https://login.salesforce.com/
		WebDriverManager.chromedriver().setup();

		// Disable / Handle Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		// Launch the browser
		driver.get("https://login.salesforce.com");
//		2. Login with username as "makaia@testleaf.com" and password as "India@123"
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		
//		3. Click on the sliding icon until "View Release Notes" is displayed

		WebElement rightClick = driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']"));   
		
		   driver.executeScript("arguments[0].scrollIntoView();", rightClick);
		   
		   
//		4. Click on Get Started link
		   
		   WebElement seeViewRelNotes = driver.findElement(By.xpath("(//span[text()='Get Started'])[6]"));
			  driver.executeScript("arguments[0].click();", seeViewRelNotes);
//		5. Navigate to Release Notes new Window
			  String parent=driver.getWindowHandle();

			  Set<String> s=driver.getWindowHandles();

			 List<String> lstNewWindow = new ArrayList<String>(s);
			  driver.switchTo().window(lstNewWindow.get(1));
	  
			  Thread.sleep(5000);
//		6. Select Summer 20 release notes from the dropdown
			  WebElement element1 = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[1]"));
			  driver.executeScript("arguments[0].click();", element1);
			  WebElement findSummer = driver.findElement(By.xpath("//span[contains(@title,'Summer')][contains(text(), '20')]"));
			  driver.executeScript("arguments[0].scrollIntoView();", findSummer);
			  findSummer.click();
//		7. Click on the Download Summer 20 release notes link and Download the Release Notes
			  driver.findElement(By.xpath("//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']/following::button[1]")).click();
//		8. Verify the downloaded release notes pdf 

	}
			 
}
