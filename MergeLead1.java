package week6day1Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import week6day1.BaseClass;

public class MergeLead1 extends BaseClass1 {

	@Test
	public void mergelead() throws InterruptedException {

		// click the contact,merge
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// click on merge contact using xpath lacator
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
}
