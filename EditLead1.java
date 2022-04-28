package week6day1Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import week6day1.BaseClass;

public class EditLead1 extends BaseClass1 {
	@Test
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

}
