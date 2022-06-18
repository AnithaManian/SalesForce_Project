import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07120_CreateNewContract {

	public static void main(String[] args) throws InterruptedException, ParseException {
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
			driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contracts",Keys.ENTER);
			Thread.sleep(5000);
//			4. Click on the Dropdown icon in the Contract tab
			driver.findElement(By.xpath("//mark[text()='Contracts']")).click();
			
//			5. Click on New Contract
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@title='New'][1]")).click();
//			6. Select the accounts listed on the'Account Name' field
			driver.findElement(By.xpath("//h2[text()='New Contract']/following::span[text()='Account Name']/following::input[@placeholder='Search Accounts...']")).sendKeys("New");
//driver.findElement(By.xpath("//div[@title='Credits']")).click();
			driver.findElement(By.xpath("//span[text()='New Account']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='New Account']/following::span[text()='Account Name']/following::input[1]")).sendKeys("Rup", Keys.ENTER);
			driver.findElement(By.xpath("//h2[text()='New Account']/following::span[text()='Save']")).click();
			String txtNewAcctName = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
			System.out.println("Account Name Selected is : "+ txtNewAcctName);
			//7.Select the Contract Start Date as Tommorow's Date
			driver.findElement(By.xpath("//h2[text()='New Contract']/following::span[text()='Contract Start Date']/following::input[1]")).sendKeys("06/18/2022");
//			8.Enter Contract Term (months) as' 6 '
			driver.findElement(By.xpath("//h2[text()='New Contract']/following::span[text()='Contract Term (months)']/following::input[1]")).sendKeys("6", Keys.ENTER);
//			9.Click save and Verify the Contract Name
			WebElement eleSave = driver.findElement(By.xpath("//h2[text()='New Contract']/following::span[text()='Save']"));
			driver.executeScript("arguments[0].click();", eleSave);
			Thread.sleep(3000);
			String txtContractID = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
			System.out.println("Contract ID is : "+ txtContractID);
						
			Thread.sleep(5000);
			
			//10.Get the Contract number
Thread.sleep(4000);

//simpleDate format
 String contractStartDate = driver.findElement(By.xpath("(//span[@class='uiOutputDate'])[1]")).getText();
 System.out.println("Start Date is " + contractStartDate);
 //String[] s= contractStartDate.split("/");
 SimpleDateFormat startDate=new SimpleDateFormat("MM/DD/YYYY");
 Date d=startDate.parse(contractStartDate);
 System.out.println(d);
 
 
 String contractEndDate = driver.findElement(By.xpath("(//span[@class='uiOutputDate'])[2]")).getText();
 System.out.println("End Date is " + contractEndDate);
 //String[] splitEndMonth = contractEndDate.split("/");
 SimpleDateFormat endDate=new SimpleDateFormat("MM/DD/YYYY");
 Date d1=endDate.parse(contractEndDate);
 System.out.println(d1);
}


}
	

