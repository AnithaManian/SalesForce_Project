import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0780_DeleteServiceTerritory {

	public static void main(String[] args) throws InterruptedException {
		//1) Launch the app
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);

		// ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
	//2) Click Login
	//3) Login with the credentials
		driver.get("https://login.salesforce.com");
		// Login using User ID and Password
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
	//4) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	//5) Click on View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	//6) Click on Service Territories
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service");
		driver.findElement(By.xpath("//p[contains(text(), ' Territories')]")).click();
//		7) Click on Down Arrow DropDown and choose edit
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("ANitha1",Keys.ENTER);
		Thread.sleep(4000);
//		WebElement eleEdit = driver.findElement(By.xpath("(//div[contains(@class,'forceVirtualAction')])[1]"));
//		driver.executeScript("arguments[0].click();", eleEdit);
		driver.findElement(By.xpath("(//div[contains(@class,'forceVirtualAction')])[1]")).click();
		Thread.sleep(3000);
//		10)Click on delete
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
//		11) Click on Delete  on Confirmation box
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
//		12) Verify Whether the Service Territory is deleted Successfully
		String text = driver.findElement(By.xpath("//span[text()='Service Territory \"']")).getText();
		System.out.println(text);
		
		if(text.contains("ANitha1"))
		{
			System.out.println("Row got deleted");
		}
		
		else {
			{
				System.out.println("Row NOT deleted");
			}
		}
			
	}

}
