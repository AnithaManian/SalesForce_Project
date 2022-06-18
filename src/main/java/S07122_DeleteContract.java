import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07122_DeleteContract {

	public static void main(String[] args) throws InterruptedException {
		//1. Login to https://login.salesforce.com
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
//				2. Click on the toggle menu button from the left corner
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//				3. Click View All and click 'Contract' from App Launcher
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			
//				4. Click the Contract tab
			driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contracts",Keys.ENTER);
			driver.findElement(By.xpath("//mark[text()='Contracts']")).click();
			Thread.sleep(5000);
//				5. Search the Account number in the Search box
			driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("00000285", Keys.ENTER);
			Thread.sleep(3000);
//				6.Click on the Dropdown icon and Select Delete
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Show Actions')]"));
			driver.executeScript("arguments[0].click();", element);
			WebElement eleDelete = driver.findElement(By.xpath("//a[@title='Delete']"));
			driver.executeScript("arguments[0].click();", eleDelete);
//			7.Click on the Delete option in the displayed popup window.
			driver.findElement(By.xpath("//span[text()='Delete']")).click();
//			8. Verify Whether Contract is Deleted using  Contract number
			driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("00000285", Keys.ENTER);
			String txt = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
			System.out.println(txt);
			
			if(txt.contains("No item")) {
				System.out.println("Record Deleted");
			}
			else {
				System.out.println("Record NOT Deleted");
			}
	}

}
