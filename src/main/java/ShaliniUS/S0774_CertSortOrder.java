package ShaliniUS;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0774_CertSortOrder {

	public static void main(String[] args) {
//			1. Launch Salesforce application https://login.salesforce.com/
//		1) Launch the app
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);

		// ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
//			2. Login with username as "makaia@testleaf.com" and password as "India@123"
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
//			3. Click on the sliding icon until "See System Status" is displayed
		WebElement rightClick = driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']"));   
		
		   driver.executeScript("arguments[0].scrollIntoView();", rightClick);
		   
	
//			4. Click on Get Started link
			WebElement seeSystemStatus = driver.findElement(By.xpath("(//span[text()='Get Started'])[7]"));
			  driver.executeScript("arguments[0].click();", seeSystemStatus);
			  
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
//			7.  Change the Sort order by "Sort alphabetically"
			  driver.findElement(By.xpath("//button[text()=' Sort by popularity ']")).click();
			  driver.findElement(By.xpath("//button[text()=' Sort alphabetically ']")).click();
//			8. Verify the Services are displayed in alphabetical order
			  List<WebElement> allElements = driver.findElements(By.xpath("//h1[text()='Certifications, Standards and Regulations']/following::div[@class='slds-col slds-size_1-of-1 slds-medium-size_1-of-3 slds-large-size_1-of-4']"));
			  System.out.println(" Total Elements: " + allElements.size());

			  for (int i=0; i<allElements.size();i++){
			      System.out.println("Total Elelment Sorted List :" + allElements.get(i).getText());
			  }
	}
			  }
	}

}
