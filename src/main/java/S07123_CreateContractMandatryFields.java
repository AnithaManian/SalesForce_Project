import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07123_CreateContractMandatryFields {

	public static void main(String[] args) throws InterruptedException {
//		1. Login to https://login.salesforce.com
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");

	// Chrome Instance
	ChromeDriver driver = new ChromeDriver(options);

	// ChromeDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.get("https://login.salesforce.com");
	// Login using User ID and Password
	driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
	driver.findElement(By.id("Login")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
//		2. Click on the toggle menu button from the left corner
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//		3. Click View All and click 'Contract' from App Launcher
	driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contracts",Keys.ENTER);
		Thread.sleep(5000);
//		4. Click on the Dropdown icon in the Contract tab
		driver.findElement(By.xpath("//mark[text()='Contracts']")).click();
		
//		5. Click on New Contract
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='New'][1]")).click();
//		6. Select the accounts listed on the'Account Name' field
		driver.findElement(By.xpath("//h2[text()='New Contract']/following::span[text()='Account Name']/following::input[@placeholder='Search Accounts...']")).sendKeys("Anitha");
		
//driver.findElement(By.xpath("//div[@title='Credits']")).click();
		//7.Select the Contract Start Date as Tommorow's Date
		driver.findElement(By.xpath("//h2[text()='New Contract']/following::span[text()='Contract Start Date']/following::input[1]")).sendKeys("06/14/2022", Keys.ENTER);
		//9.Click save
		WebElement eleSave = driver.findElement(By.xpath("//h2[text()='New Contract']/following::span[text()='Save']"));
		driver.executeScript("arguments[0].click();", eleSave);
		Thread.sleep(3000);
		String errorMsg = "These required fields must be completed: Contract Term (months)";
		//System.out.println(errorMsg);
		
		if(errorMsg.contains("These required fields must be completed:")) {
			System.out.println("Mandatory Field Required to continue");
		}
		
		else
		{
			System.out.println("Not correct");
		}
		
		driver.close();
	}

}
