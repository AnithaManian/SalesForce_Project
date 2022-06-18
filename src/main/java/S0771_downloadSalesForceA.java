import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0771_downloadSalesForceA {

	public static void main(String[] args) {
//			1. Launch Salesforce application https://login.salesforce.com/
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);

		// ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
//			2. Login with username as "makaia@testleaf.com" and password as "India@123"
		
		driver.get("https://login.salesforce.com");
		// Login using User ID and Password
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
//			3. Click on the sliding icon until "Download SalesForceA" is displayed
//			4. Click on App Strore link
//			5. Navigate to the new window 
//			6. Get the link displayed and click confirm
//			7. Verify url https://apps.apple.com/us/app/salesforcea/<id> loaded 

	}

}
