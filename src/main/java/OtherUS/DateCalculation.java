package OtherUS;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DateCalculation {

	private static final String Months = null;

	public static void main(String[] args) throws InterruptedException {
		
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//
//		// Chrome Instance
//		ChromeDriver driver = new ChromeDriver(options);
//
//		// ChromeDriver driver = new ChromeDriver();
//
//		driver.manage().window().maximize();
//		driver.get("https://d2w00000dnnegeal-dev-ed.lightning.force.com/lightning/r/Contract/8002w000000l5BvAAI/view");
//		Thread.sleep(5000);
//		String contractStartDate = driver.findElement(By.xpath("(//span[@class='uiOutputDate'])[1]")).getText();
//		 System.out.println("Start Date is " + contractStartDate);
//		 
//			 
//		 String contractEndDate = driver.findElement(By.xpath("(//span[@class='uiOutputDate'])[2]")).getText();
//		 System.out.println("End Date is " + contractEndDate);
		 
		LocalDate startDate = new LocalDate(2022, 6, 18);
		LocalDate endDate = new LocalDate(2022, 12, 17); 
		//int monthsBetween = Months.monthsBetween(startDate, endDate).getMonths();

		Period age = Period.between(bday, today);
		Read more: https://javarevisited.blogspot.com/2016/10/how-to-get-number-of-months-and-years-between-two-dates-in-java.html#ixzz7WUAAosAD
		 int monthsBetween = Months.monthsBetween(contractStartDate, contractEndDate).getMonths();
	}
}
