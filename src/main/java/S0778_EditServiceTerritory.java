import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0778_EditServiceTerritory {

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
//	7) Click on Down Arrow DropDown and choose edit
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Rupesh",Keys.ENTER);
	Thread.sleep(4000);
//	WebElement eleEdit = driver.findElement(By.xpath("(//div[contains(@class,'forceVirtualAction')])[1]"));
//	driver.executeScript("arguments[0].click();", eleEdit);
	driver.findElement(By.xpath("(//div[contains(@class,'forceVirtualAction')])[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@title='Edit']")).click();
//	8) Get the System Information Created by Using Regex print the name alone
	String textCreatedBy = driver.findElement(By.xpath("(//span[text()='Derrick Dsouza'])[2]")).getText();
	System.out.println("Created By :" + textCreatedBy);
//	9) Get the System Information Modified By Using Regex print the name alone
	String textLastModifiedBy = driver.findElement(By.xpath("(//span[text()='Derrick Dsouza'])[3]")).getText();
	System.out.println("Modified By :" + textLastModifiedBy);
//	10) Get the text of the owner 
	String textOwner = driver.findElement(By.xpath("(//span[text()='Derrick Dsouza'])[1]")).getText();
	System.out.println("Owner:" +textOwner);
//	11) Verify Owner, Created By and Modified By are matching
	
	if(textCreatedBy.contains(textLastModifiedBy))
		System.out.println("Names are matching");
	else
		System.out.println("Names not matching");
//	12) Change the Country name To  North America
	
	Thread.sleep(2000);
	WebElement eleCountry = driver.findElement(By.xpath("//input[@placeholder='Country']"));
	eleCountry.clear();
	eleCountry.sendKeys("North America");
//	13) Click on Save 
	driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
//	14) Verify LastModified date 
String eleModifiedBy = driver.findElement(By.xpath("(//span[text()='Last Modified By']/following::div[@class='slds-form-element__control slds-grid itemBody'])[3]")).getText();
String[] splitModifiedBy = eleModifiedBy.split(",");
System.out.println("Verify the Last Modified Date" + splitModifiedBy[1]);

String text = driver.findElement(By.xpath("//span[text()=\"Service Territory\"]")).getText();
System.out.println(text);

if(text.contains("was saved"))
	System.out.println("Service Territory was saved");
else
	System.out.println("Service Territory was not saved");

driver.close();
	}

}

