import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0734_CreateLegalEntity {

	public static void main(String[] args) throws InterruptedException {
//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
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
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
//		2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//		3. Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal");
		driver.findElement(By.xpath("//p[contains(text(), 'Entities')]")).click();
//		4. Click on the Dropdown icon in Oppurtunity tab
		Thread.sleep(5000);
		//WebElement oppurtunity = driver.findElement(By.xpath("//span[text()='Opportunities']/following::lightning-icon[1]"));
		//driver.executeScript("arguments[0].click();", oppurtunity);
		driver.findElement(By.xpath("(//div[@title='New']")).click();		
//		5. Click on New Legal Entity
		Thread.sleep(3000);
		WebElement legalEntity1 = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		driver.executeScript("arguments[0].click();", legalEntity1);
		
		
//		6. Enter Name as 'Salesforce Automation by Your Name'
		WebElement element = driver.findElement(By.xpath("(//span[text()='Name'])[2]/following::input[1]"));
		element.sendKeys("Salesforce Automation by Anitha Manian1");
		
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
//		7.Click save and verify Legal Entity Name
		String text= driver.findElement(By.xpath("//span[text()='Legal Entity']")).getText();
		System.out.println(text);
		
		if(text.contains("Anitha Manian1")){
			System.out.println("New Record for Legal Entity got created");
		}
		else
		{
			System.out.println("Record not created");
		}
		
		driver.close();

	}

}