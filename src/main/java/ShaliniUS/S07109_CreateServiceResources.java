package ShaliniUS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07109_CreateServiceResources {

	public static void main(String[] args) {
//	1) Launch the app
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);

		// ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
//	2) Click Login
//	3) Login with the credentials
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
//	4) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//	5) Click on View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
//	6) Click on Service Resources
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service Resources");
		driver.findElement(By.xpath("//mark[text()='Service Resources']")).click();
//	7) Click on Show one more action Dropdown
		WebElement eleEdit = driver.findElement(By.xpath("//span[contains(text(),'Show Actions')]"));
		driver.executeScript("arguments[0].click();", eleEdit);
//	8) Click on edit
		driver.findElement(By.xpath("//a[@Title='Edit']")).click();
//	9) Change the Name as your name
		WebElement editName = driver.findElement(By.xpath("//h2[contains(text(),'Edit')]/following::span[text()='Name']/following::input[1]"));
		editName.clear();
		editName.sendKeys("Rupesh");
//	10) Click on save
		driver.findElement(By.xpath("//h2[contains(text(),'Edit')]/following::span[text()='Save']")).click();
		driver.navigate().refresh();
//	11) Verify the new name has changed
		String txtName = driver.findElement(By.xpath("//a[@data-refid='recordId'][1]")).getText();
		System.out.println("Updated Name is: " +txtName);
		
// Name is getting updated but still old name is getting reflected any way to refresh the page before selecting the name field***********
		if (txtName.contains("Rupesh"))
		{
			System.out.println("New name got updated");
			
	}
		else
		{
			System.out.println("Not Updated");
		}

}
}