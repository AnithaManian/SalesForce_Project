import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0777_CreateServiceTerritory {

	public static void main(String[] args) throws InterruptedException {
//	1) Launch the app
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);

		// ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
//	2) Click Login
//	3) Login with the credentials
		driver.get("https://login.salesforce.com");
		// Login using User ID and Password
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
//	4) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//	5) Click on View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
//	6) Click on Service Territories
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service");
		driver.findElement(By.xpath("//p[contains(text(), ' Territories')]")).click();
//	7) Click on New 
		Thread.sleep(5000);
//WebElement element = driver.findElement(By.xpath("(//span[text()='Service Territories']/following::div[@title='New'])[2]"));
//driver.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(3000);
//	8) Enter Your Name in Name field
		driver.findElement(By.xpath("//h2[text()='New Service Territory']/following::span[text()='Name']/following::input[1]")).sendKeys("Rupesh");
//	9) Click on Operating Hours and Choose the First option
		driver.findElement(By.xpath("//h2[text()='New Service Territory']/following::span[text()='Operating Hours']/following::input[1]")).click();
		driver.findElement(By.xpath("//div[@title='US Shift']")).click();
//	10) Check Active Field
		driver.findElement(By.xpath("//h2[text()='New Service Territory']/following::span[text()='Active']/following::input[1]")).click();
//	11) Enter the City your residing in City Field
		driver.findElement(By.xpath("//h2[text()='New Service Territory']/following::span[text()='City']/following::input[1]")).sendKeys("Coimbatore");
//	12) Enter the State your residing in State Field
		driver.findElement(By.xpath("//h2[text()='New Service Territory']/following::span[text()='State/Province']/following::input[1]")).sendKeys("TamilNadu");
//	13) Enter the Country your residing in Country Field
		driver.findElement(By.xpath("//h2[text()='New Service Territory']/following::span[text()='Country']/following::input[1]")).sendKeys("India");
//	14) Enter your current Postal Zip Code 
		driver.findElement(By.xpath("//h2[text()='New Service Territory']/following::span[text()='Zip/Postal Code']/following::input[1]")).sendKeys("641001");
//	15) Click on Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
//	16) Verify Service Territory is created Successfully
		String text = driver.findElement(By.xpath("//span[text()='Service Territory']")).getText();
		System.out.println(text);

		if(text.contains("created"))
			System.out.println("Service Territory Rupesh Created");
		else
			System.out.println("Not created");
	}

}
