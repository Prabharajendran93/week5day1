package week6day1Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass2 {

	public ChromeDriver driver;

	@BeforeMethod
	public void preCondition() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// enter the URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		// maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// enter the user name and password
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// click submit
		driver.findElement(By.className("decorativeSubmit")).click();

		// click CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

	}

	@AfterMethod
	public void postCondition() {

		// close all windows
		driver.close();
	}

}
