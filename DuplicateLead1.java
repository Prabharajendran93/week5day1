package week6day1Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import week6day1.BaseClass;

public class DuplicateLead1 extends BaseClass1 {

	@Test
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

}
