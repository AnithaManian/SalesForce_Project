package OtherUS;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class S0767_CustomerServiceOptions {

	public static void main(String[] args) {
		
//			1. Launch Salesforce application https://login.salesforce.com/
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
//			2. Login with username as "makaia@testleaf.com" and password as "India@123"
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		
		
////			3. Click on Learn More link in Mobile Publisher
		
		
		WebElement clkLearn = driver.findElement(By.xpath("//span[text()='Learn More']"));
		driver.executeScript("arguments[0].click();", clkLearn);
		
		
		String parent = driver.getWindowHandle();

		Set<String> setWinNew = driver.getWindowHandles();
		
		List<String> lst = new ArrayList<String>(setWinNew);
		driver.switchTo().window(lst.get(1));
				//
//		// Now iterate using Iterator
//		Iterator<String> I1 = s.iterator();
//
//		while (I1.hasNext()) {
//
//			String child_window = I1.next();
//
//			if (!parent.equals(child_window)) {
//				driver.switchTo().window(child_window);
//
//				System.out.println(driver.switchTo().window(child_window).getTitle());
		driver.get("https://www.salesforce.com/products/platform/products/mysalesforce/");
		
				// 4. MouseHover on Products and Select Service
				Shadow shadow = new Shadow(driver);
				WebElement selectProduct = shadow.findElementByXPath("//span[text()='Products']");
				selectProduct.click();
				Actions actions = new Actions(driver);
				actions.moveToElement(selectProduct).build().perform();
				// 5. Verify the tabs displayed in the page
//			Expected Result:
//			Below tabs should be displayed
//			1. Products
//			2. Company
//			3. Support & Services
//			4. Resurces
//			5. COVID-19
			}
		}
//	}
//}