package week6day1Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Assignment2Attributes extends BaseClass1 {
	
	@Test(priority=1)
	public void createlead() throws InterruptedException{
	{
		// create lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		// enter company name ,first name,last name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("PRABHA");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("RAJENDRAN");

		// enter first name local, department name,description,primary email
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("PRABHA");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("EEE");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("ASSISTANT");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("prabha@gmail.com");

		// handle drop down
		WebElement Element = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select st = new Select(Element);
		st.selectByVisibleText("New York");

		// click submit button
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(5000);

		// get the title
		String title = driver.getTitle();
		System.out.println(title);
	}
	}


	@Test(priority=4, enabled=false)
	
	public void duplicatelead() throws InterruptedException {

		// click the lead, create lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		// enter the company name, first name, last name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("PRABHA");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("RAJENDRAN");

		// enter the first name local, department name,description and primary email
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("PRABHA");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("EEE");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("ASSISTANT");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("prabha@gmail.com");

		// handle the drop down
		WebElement Element = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select st = new Select(Element);
		st.selectByVisibleText("New York");

		// click submit button
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(5000);

		// print the title
		String title = driver.getTitle();
		System.out.println(title);

		// click duplicate lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		Thread.sleep(5000);

		// clear the company name
		driver.findElement(By.id("createLeadForm_companyName")).clear();

		// change the company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("MECH");

		// clear the first name
		driver.findElement(By.id("createLeadForm_firstName")).clear();

		// change the first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("PRABHI");

		// click submit
		driver.findElement(By.name("submitButton")).click();

		// print the title
		String titlenew = driver.getTitle();
		System.out.println(titlenew);
	}

@Test(priority=2, enabled=false)

	public void mergelead() throws InterruptedException{
	
	// click the contact,merge
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();

			// click on merge contact using xpath locator
			driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

			// click on widget of from contact
			driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']/following::img")).click();

			// Switching windows
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> window1 = new ArrayList<String>(windowHandles);
			driver.switchTo().window(window1.get(1));
			Thread.sleep(5000);

			// click on first resulting contact
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
			driver.switchTo().window(window1.get(0));

			// click on widget of to contact
			driver.findElement(By.xpath("//input[@id='partyIdTo']/following::a/img")).click();

			// Switching windows
			Set<String> windowHandles2 = driver.getWindowHandles();
			List<String> window2 = new ArrayList<String>(windowHandles2);
			driver.switchTo().window(window2.get(1));
			Thread.sleep(5000);

			// click on first resulting contact
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
			driver.switchTo().window(window2.get(0));

			// click on merge button using xpath locator
			driver.findElement(By.xpath("//a[text()='Merge']")).click();

			// accept the alert
			Alert alert = driver.switchTo().alert();
			alert.accept();

			// verify the title of the page
			String title = driver.getTitle();
			System.out.println("the title of the page is" + title);
			if (title.contains("Merge Contacts")) {
				System.out.println("the title of the page contains merge contact");
			} else {
				System.out.println("the title of the page does not contains merge contact");
			}
}

@Test(priority=3)

public void editlead() throws InterruptedException {

	// click lead and find lead
	driver.findElement(By.xpath("//a[text()='Leads']")).click();
	driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//span[text()='Advanced']/following::input)[2]")).sendKeys("p");

	// click find lead
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]")).click();

	// get the title
	String edittitle = driver.getTitle();
	System.out.println(edittitle);

	// click edit
	driver.findElement(By.xpath("//a[text()='Edit']")).click();

	// clear the company name and enter the new company name
	driver.findElement(By.id("updateLeadForm_companyName")).clear();
	driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("wipro");

	// click the update button
	driver.findElement(By.xpath("//input[@value='Update']")).click();

	// print the title
	String cname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
	System.out.println(cname);

	// check whether the title is matched
	if (cname.contains("wipro")) {
		System.out.println("title is matched");
	} else {
		System.out.println("title is not matched");
	}
}

@Test(priority=5, invocationCount=2)
public void deletelead() throws InterruptedException {
	{

		// click the lead ,find lead and phone
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		// enter the phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1");

		// click find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		// print the first value
		String val1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]"))
				.getText();
		System.out.println(val1);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();

		// click delete and find leads
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// enter the first value
		driver.findElement(By.xpath("(//label[text()='Lead ID:']/following::input)[1]")).sendKeys(val1);

		// click find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// check whether the value is displayed
		driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
	}
}
		}

	


