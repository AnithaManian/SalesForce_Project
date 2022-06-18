import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0764_EditWorkType {

	public static void main(String[] args) throws InterruptedException {
//	1) Launch the app
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
		
//	2) Click Login
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		
//	4) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//	5) Click on View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Work");
		
//	6) Click on Work Types
		driver.findElement(By.xpath("//p[contains(text(), 'Types')]")).click();
//	7) Click on the Arrow button at the end of the first result
		Thread.sleep(5000);
		
//	8) Click on Edit
				
		WebElement eleEdit = driver.findElement(By.xpath("//span[contains(text(), 'Show Action')]"));
		driver.executeScript("arguments[0].click();", eleEdit);
		//driver.findElement(By.xpath("//a[@title='Show 2 more actions']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
//	9) Enter Time Frame Start as \"])[8]/following::input[1]")).sendKeys("9");'9'
		WebElement startTime = driver.findElement(By.xpath("(//label[@data-aura-class=\"uiLabel\"])[8]/following::input[1]"));
		startTime.clear();
		startTime.sendKeys("9");
//	10) Enter Time Frame End as '18'
		WebElement endTime = driver.findElement(By.xpath("(//label[@data-aura-class='uiLabel'])[9]/following::input"));
		endTime.clear();
		endTime.sendKeys("18");
//	11) Click on Save
		driver.findElement(By.xpath("(//span[text()=\"Save\"])[2]")).click();
//	12) Verify the success message
String text = driver.findElement(By.xpath("//span[text()='Work Type']")).getText();
System.out.println(text);

if(text.matches("Work Type \"Sample work type\" was saved")) 
{
	System.out.println("Work Type saved successfully");
}
else
{
	System.out.println("Not saved");
}

driver.close();
}

}
