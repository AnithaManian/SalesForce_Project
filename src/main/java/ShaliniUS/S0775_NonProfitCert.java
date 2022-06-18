package ShaliniUS;

import java.time.Duration;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0775_NonProfitCert {

	public static void main(String[] args) throws InterruptedException {
//			1. Launch Salesforce application https://login.salesforce.com/
//			2. Login with username as "makaia@testleaf.com" and password as "India@123"
	//	1) Launch the app
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");

	// Chrome Instance
	ChromeDriver driver = new ChromeDriver(options);

	// ChromeDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.get("https://login.salesforce.com");

//2) Click Login
	
//3) Login with the credentials
	driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
	driver.findElement(By.id("Login")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
//			3. Click on the sliding icon until "See System Status" is displayed
	
	Thread.sleep(7000);

	WebElement rightClick = driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']"));   
	
	   driver.executeScript("arguments[0].scrollIntoView();", rightClick);
	   
	WebElement seeSystemStatus = driver.findElement(By.xpath("(//span[text()='Get Started'])[7]"));
	  driver.executeScript("arguments[0].click();", seeSystemStatus);
//			4. Click on Get Started link
//			5. Navigate to SalesForce Trust new Window
	  String parent=driver.getWindowHandle();

	  Set<String> s=driver.getWindowHandles();

	  // Now iterate using Iterator
	  Iterator<String> I1= s.iterator();

	  while(I1.hasNext())
	  {

	  String child_window=I1.next();


	  if(!parent.equals(child_window))
	  {
	  driver.switchTo().window(child_window);

	  System.out.println(driver.switchTo().window(child_window).getTitle());
	  
//			6. Select Trust Compliance from the dropdown
	  WebElement findElement1= driver.findElement(By.xpath("//p[@id='trust-label'][1]/following::span[text()='Show More']"));
	  driver.executeScript("arguments[0].click();", findElement1);
	  driver.findElement(By.xpath("//p[text()='   Compliance']")).click();
	  
//			7. Click on Show Filters
	  driver.findElement(By.xpath("//button[text()=' Show filters ']")).click();
//			8. Select "Nonprofit" under INDUSTRIES
	  WebElement listNonProfit = driver.findElement(By.xpath("//h2[text()='Industries']/following::input[@id='Nonprofit']"));
	  driver.executeScript("arguments[0].click();", listNonProfit);
//			9. Verify the 20 Ceriticates that are Nonprofit only should be displayed
	  List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='slds-col slds-size_1-of-1 slds-medium-size_1-of-3 slds-large-size_1-of-4']"));
System.out.println(" Total Non Profit Element: " + allElements.size());

for (int i=0; i<allElements.size();i++){
    System.out.println("Non Profit items :" + allElements.get(i));
}


//Expected Result:
//			1. Clear Filter option should be displayed
//			2. 20 Nonprofit certifications only be displayed certificates
// ******When executing its 23 Non Profit Certificates *** all 23 items are getting displayed

	}
	  }
	}
}
