import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0766_VerifyMandatoryWorkType {

	public static void main(String[] args) throws InterruptedException {
//		1) Launch the app
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
			
//		2) Click Login
			driver.findElement(By.id("Login")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			
//		4) Click on the App Laucher Icon left to Setup
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//		5) Click on View All
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Work");
			
//		6) Click on Work Types
			driver.findElement(By.xpath("//p[contains(text(), 'Types')]")).click();

		
//			7) Click on New
			driver.findElement(By.xpath("//div[text()='New']")).click();
//			8) Enter Work Type Name as 'Bootcamp'
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[text()='Work Type Name']/following::input)[5]")).sendKeys("Bootcamp");
//			9) Click on Save
driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

String expectedResult = "These required fields must be completed: Estimated Duration, Work Type Name\r\n" ;

String actualResult = driver.findElement(By.xpath("//li[contains(text(),\"These required fields must be completed\")]")).getText();

System.out.println(actualResult);

if(actualResult.contains(expectedResult))
{
	System.out.println("Missing field needs to be entered first:");

}
else
{
	System.out.println("Should not continue");
}
	}

}
