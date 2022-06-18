package ShaliniUS;

import java.time.Duration;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07108_NewProvisioningRequest {
	public static void main(String[] args) throws InterruptedException {
//		1) Launch the app
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
//	4) Click on the App Launcher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//	5) Click on View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
//	6) Click on User Provisioning Request
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("User Provisioning",Keys.ENTER);
		Thread.sleep(5000);
//		4. Click on the Dropdown icon in the Contract tab
		driver.findElement(By.xpath("//h2[text()='App Launcher']/following::mark[contains(text(), 'User Provisioning')]")).click();
//	7) Click on the open in SalesForce Classic
		driver.findElement(By.xpath("//a[text()='Open in Salesforce Classic.']")).click();
//	8) Click on Create New View
		Thread.sleep(3000);
		String strPartentWin=driver.getWindowHandle();
		
		Set<String>s=driver.getWindowHandles();
		
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!strPartentWin.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}
		
		System.out.println(driver.switchTo().window(child_window).getTitle());
		}
		WebDriverWait mycreateNewView = new WebDriverWait(driver, Duration.ofSeconds(30));
			
		mycreateNewView.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Create New View')]"))).click();
		
		String title1 = driver.getTitle();
		System.out.println("First Page Title: " + title1);
		//driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
//	9) Enter View Name as Snorky[Your name]
		driver.findElement(By.xpath("//h2[text()=' Create New View']/following::input[@id='fname']")).sendKeys("Rupesh1");
//	10) Enter View Unique Name as Snorky_26[yourname_anynumber]
		WebElement enterDevName = driver.findElement(By.xpath("//h2[text()=' Create New View']/following::input[@id='devname']"));
		enterDevName.clear();
		enterDevName.sendKeys("Rupesh2");
//	11) Click on My User Provisioning Requests Under Step two
		driver.findElement(By.xpath("//label[text()='My User Provisioning Requests']")).click();
//	12) Under Field Select First DropDown as Name
		//************Getting Unexpected Tag Name exception"**************
		Select drpField=new Select(driver.findElement(By.id("fcol1")));
		drpField.selectByVisibleText("Name");
//	13) Under Operator Get the List of values availble from dropdown
		WebElement operator = driver.findElement(By.id("fop1"));
			      //Select class to get options in dropdown
	      Select operatorList = new Select(operator);
	      List<WebElement> m = operatorList.getOptions();
	      System.out.println("List size: " + m.size());
	      System.out.println("Drodown list items 1st Column Field: ");
	      //iterate through options till list size
	      for (int j = 0; j < m.size(); j++) {
	         String op1 = m.get(j).getText();
	         System.out.println(op1);
	      }
//	14) Get the size of DropDownm
	        
//	15) Under Field Select First DropDown as Created Date
	         Select drpField1=new Select(driver.findElement(By.id("fcol1")));
	         //drpField1.clear();
	 		drpField1.selectByVisibleText("Created Date");        
//	16) Under Step 3 Get the List of Available Fields
	 		WebElement getAvailableFields = driver.findElement(By.name("colselector_select_0"));
		      //Select class to get options in dropdown
		      Select l1 = new Select(getAvailableFields);
		      List<WebElement> m1 = l1.getOptions();
		      System.out.println("List size: " + m1.size());
		      System.out.println("Drodown list items Available Fields: ");
		      //iterate through options till list size
		      for (int n = 0; n < m1.size(); n++) {
		         String op2 = m1.get(n).getText();
		         System.out.println(op2);
		      }
//	17) Under Step 3 Get the List of Selected Fields
		         WebElement getSelectedFields = driver.findElement(By.id("colselector_select_1"));
			      //Select class to get options in dropdown
			      Select l2 = new Select(getSelectedFields);
			      List<WebElement> m2 = l2.getOptions();
			      System.out.println("List size: " + m2.size());
			      System.out.println("Drodown list items for Selected Fields: ");
			      //iterate through options till list size
			      for (int k = 0; k < m2.size(); k++) {
			         String op3 = m2.get(k).getText();
			         System.out.println(op3);
			      }
//	18)  Select an Option From Available Field  and Click Add Option 
			      Select availableFields = new Select(driver.findElement(By.id("colselector_select_0")));
			      availableFields.selectByVisibleText("Created By");
			      driver.findElement(By.xpath("(//img[@title='Add'])[1]")).click();
//	19) Verify whether Field is added to Selected Fields 
			      WebElement getSelectedFields1 = driver.findElement(By.id("colselector_select_1")); 
			      
			      Select l3= new Select(getSelectedFields1);
			      List<WebElement> m3 = l3.getOptions();
			      if(m2.size()!=m3.size())
			      {
			      			    	System.out.println("Created BY is added from Available field to Selected Field");  
			      }
			     else
			     {
			    	 System.out.println("Object not added");
			     }
			     //
//	20) Under Step 4  Click on Visible to All Users 
			      driver.findElement(By.xpath("//h3[text()='Step 4. Restrict Visibility']/following::input[2]")).click();
//	21) Click on Save
			      driver.findElement(By.xpath("(//input[@title='Save'])[2]")).click();
//	22) Verify New User is Created
			      Thread.sleep(3000);
			      String textNewUser = driver.findElement(By.xpath("//h1[contains(text(),'Ru')]")).getText();
			      System.out.println("New User Created: " + textNewUser);
			     String title2 = driver.getTitle();
			      System.out.println(title2);
			      
//	23) Get the Title of the Page
			     String title3 = driver.getTitle();
			     System.out.println(title3);
//	24) Close Other Browsers Than Current Browser
			      driver.close();
			      driver.quit();		      
	}
	;
	}

