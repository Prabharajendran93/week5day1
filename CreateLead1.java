package week6day1Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import week6day1.BaseClass;

public class CreateLead1 extends BaseClass1 {

	@Test
	public void createlead() throws InterruptedException {

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
