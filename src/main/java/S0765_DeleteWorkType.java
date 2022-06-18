import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0765_DeleteWorkType {

	public static void main(String[] args) throws InterruptedException {
//	1//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();

		// Disable / Handle Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);

		// ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		// Launch the browser
		driver.get("https://login.salesforce.com");
		// Login using User ID and Password
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		
//	2) Click Login
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		
//	4) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//	5) Click on View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Work");
		
//	6) Click on Work Types
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(), 'Types')]")).click();
//	7) Click on the Arrow button at the end of the first result
		Thread.sleep(4000);
//	8) Click on Delete
		WebElement eleDel = driver.findElement(By.xpath("//span[contains(text(), 'Show Action')]"));
		driver.executeScript("arguments[0].click();", eleDel);
				Thread.sleep(3000);
		//Search for the row it needs to Delete
				driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Bootcamp1");
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
driver.findElement(By.xpath("//span[text()='Delete']")).click();
String text = driver.findElement(By.xpath("//span[text()='Work Type \"']")).getText();
System.out.println(text);
//	10) Verify the message

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
