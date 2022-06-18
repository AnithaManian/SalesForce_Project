import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0779_CreateParentTerritory {

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
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Rupesh",Keys.ENTER);
//		7) Click on Parent Territory Input field of newly created Service Territory
		Thread.sleep(5000);
		WebElement editParentTerritory = driver.findElement(By.xpath("(//span[contains(text(), 'Edit Parent Territory')])[1]"));
		driver.executeScript("arguments[0].click();", editParentTerritory);
//		8) Under that Click on New Service Territory
		driver.findElement(By.xpath("//input[@placeholder='Search Service Territories...']")).sendKeys("New");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@title=\"New Service Territory\"]")).click();
//		9) Enter Name as Mukesh Ambani
		driver.findElement(By.xpath("(//span[text()='Name'])[2]/following::input[1]")).sendKeys("Mukesh Ambani");
//		10) Click on Search Operating Hours
		driver.findElement(By.xpath("(//span[text()='Operating Hours'])[2]/following::input[@title='Search Operating Hours']")).sendKeys("New");

//		11)  Click New Operating Hours in the DropDown
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title='New Operating Hours']")).click();
//		12) Enter Name as "Mukesh Ambani
		driver.findElement(By.xpath("(//span[text()=\"Name\"])[3]/following::input")).sendKeys("Mukesh Ambani");
//		13) Select Time as India standard Time(Asia/Kolkata)
		driver.findElement(By.xpath("//span[text()='Time Zone']/following::a[1]")).click();
		WebElement drpList = driver.findElement(By.xpath("//a[contains(text(), 'Asia/Kolkata')]"));
		driver.executeScript("arguments[0].scrollIntoView();", drpList);
		drpList.click();
//		14) Click on Save
		driver.findElement(By.xpath("//h2[text()='New Operating Hours']/following::span[text()='Save']")).click();
//		15) Verify Name of Operating Hours
		String textOperatingHrs = driver.findElement(By.xpath("//span[@class='pillText']")).getText();
		System.out.println(textOperatingHrs);
		
		if(textOperatingHrs.contains("Mukesh Ambani"))
		{
			System.out.println("Woring as expected");
		}
		else
		{
			System.out.println("Not Woring as expected");
		}
//		16) Click on Save
		driver.findElement(By.xpath("//h2[text()='New Service Territory']/following::span[text()='Save']")).click();
//		17) Verify Whether Parent Territory is Created Successfully
		String text = driver.findElement(By.xpath("//span[text()='Service Territory']")).getText();
		System.out.println(text);
		if (text.contains("created"))
		{System.out.println("Parent Territory got Created");

	}
		else
		{

		System.out.println("Parent Territory got Created");
		}
	}
}
