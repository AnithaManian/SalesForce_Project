import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0735_EditLegalEntity {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
//		    1. Login to https://login.salesforce.com
//			2. WebDriverManager.chromedriver().setup();

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
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		// driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
//		2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//		3. Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//p[contains(text(), 'Entities')]")).click();
//			5. Search the Legal Entity 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Anitha Manian1");
//			6. Click on the Dropdown icon and Select Edit
		// Check the checkbox
		Thread.sleep(4000);
		WebElement ele = driver.findElement(By.xpath("(//span[text()='Show Actions'])[1]"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

//			7.Enter the Company name as 'Testleaf'.
		Thread.sleep(2000);
		WebElement compEle = driver.findElement(By.xpath("(//span[text()='Company Name']/following::input)[1]"));
		compEle.clear();
		compEle.click();
		compEle.sendKeys("Test LEAF");
		

//			8. Enter Description as 'SalesForce'.
		WebElement descEle = driver.findElement(By.xpath("//span[text()='Description']/following::textarea"));
		descEle.clear();
		descEle.sendKeys("Sales Force");
//			9.Select Status as 'Active'
		WebElement statusDrpDown = driver.findElement(By.xpath("//a[@class='select']"));
		driver.executeScript("arguments[0].click();", statusDrpDown);
		
//			10. Click on Save and Verify Status as Active
		driver.findElement(By.xpath("//a[@title='Active']")).click();
		
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		
		String text= driver.findElement(By.xpath("//span[text()='Legal Entity']")).getText();
		System.out.println(text);
		
		
		if(text.matches("Anitha Manian1"))
				{
			System.out.println("Legal Entity is Edited successfully");
		}
		else
		{
			System.out.println("Record not updated");
		}
		
		driver.close();

//			The Legal Entity is Edited Successfully
	
	}

}
