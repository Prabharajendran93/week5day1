package week6day1Assignments;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import week6day1.BaseClass;

public class DeleteLead1 extends BaseClass1 {

	@Test
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
