import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07121_EditContract {

	public static void main(String[] args) throws InterruptedException {
//			1. Login to https://login.salesforce.com
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
//			2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//			3. Click View All and click 'Contract' from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
//			4. Click the Contract tab
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contracts",Keys.ENTER);
		driver.findElement(By.xpath("//mark[text()='Contracts']")).click();
		Thread.sleep(5000);
//			5. Search the Account number in the Search box
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("00000289", Keys.ENTER);
		Thread.sleep(3000);
//			6.Click on the Dropdown icon and Select Edit
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Show Actions')]"));
		driver.executeScript("arguments[0].click();", element);
		WebElement eleEdit = driver.findElement(By.xpath("//a[@title='Edit']"));
		driver.executeScript("arguments[0].click();", eleEdit);
//			7.Select Status as 'Activated'
		Thread.sleep(5000);
//		WebElement eleStatus = driver.findElement(By.xpath("//h2[contains(text(),'Edit')]/following::span[text()='Status']/following::a[1]"));
//		driver.executeScript("arguments[0].scrollIntoView();", eleStatus);
//		eleStatus.click();
		driver.findElement(By.xpath("//h2[contains(text(),'Edit')]/following::span[text()='Status']/following::a[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Activated'])[1]")).click();
//			8.Select Owner Expiration Notice as'30 days'
//		WebElement eleOwnerExp = driver.findElement(By.xpath("//span[text()='Owner Expiration Notice']/following::a[text()='30 Days'][1]"));
//		driver.executeScript("arguments[0].scrollIntoView();", eleOwnerExp);
//		eleOwnerExp.click();
		driver.findElement(By.xpath("//span[text()='Owner Expiration Notice']/following::a[1]")).click();
		WebElement eleOwnerExp = driver.findElement(By.xpath("(//a[text()='30 Days'])[1]"));
		driver.executeScript("arguments[0].scrollIntoView();", eleOwnerExp);
//			9.Click save and Verify the Status
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		
		String txtStatus = driver.findElement(By.xpath("//span[text()='Activated']")).getText();
		System.out.println(txtStatus);
		
		if (txtStatus.contains("Activated"))
		{
			System.out.println("Working as expected");
		}
		else
		{
			System.out.println("Not saved");
		}
	}

}
