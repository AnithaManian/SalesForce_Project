import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0738_DeleteLegalEntity {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();

		// Disable / Handle Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);

		// ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
//			1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		// Login using User ID and Password
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		// driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
//		2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//		3. Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal");
//		4. Click on the legal Entities tab 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[contains(text(), 'Entities')]")).click();

		Thread.sleep(3000);
		
//		5. Search the Legal Entity 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Anitha Manian1");
		
//		6. Click on the Dropdown icon and Select Delete
		Thread.sleep(4000);
		WebElement ele = driver.findElement(By.xpath("(//span[text()='Show Actions'])[1]"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(5000);
		
	//			7.Click on the Delete option in the displayed popup window.
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		
		
//		Alert alertConfirm = driver.switchTo().alert();
//		
//		System.out.println(alertConfirm.getText());
//		Thread.sleep(2000);
//		alertConfirm.accept();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
//			8. Verify Whether Legal Entity is Deleted using Legal Entity Name		
		String text = driver.findElement(By.xpath("//span[text()='Legal Entity \"']")).getText();
		System.out.println(text);
//			10) Verify the message

		if(text.contains("was deleted"))
		{
			System.out.println("Deleted Successfully");
		}
		else
		{
			System.out.println("Not Deleted");
		}
			
		driver.close();
		

	}

}
