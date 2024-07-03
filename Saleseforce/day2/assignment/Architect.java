package Saleseforce.day2.assignment;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Architect extends Baseclass {

	@Test
	public void salseforceAdministraor() throws InterruptedException {

		driver.findElement(By.xpath("//span[.='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//button[.='Confirm']")).click();
		Thread.sleep(5000);

		Shadow dom = new Shadow(driver);

		WebElement learning = dom.findElementByXPath("//li[@data-item-id='3']");
		learning.click();
		Actions act = new Actions(driver);
		WebElement findElement = dom.findElementByXPath("//span[.='Learning on Trailhead']");
		act.moveToElement(findElement).click().perform();

		WebElement salseForcecer = dom.findElementByXPath("//a[.='Salesforce Certification']");
		act.moveToElement(salseForcecer).click().perform();

		driver.findElement(By.xpath("//a[@href='/en/credentials/architectoverview']")).click();

		List<WebElement> findElements = driver.findElements(By.xpath(".credentials-card_title"));

		for (WebElement webElement : findElements) {

			String text = webElement.getText();
			System.out.println(text);

		}

		driver.findElement(By.linkText("Application Architect")).click();

		List<WebElement> applicationArc = driver.findElements(By.xpath(".credentials-card_title"));

		for (WebElement webElement : applicationArc) {

			String text = webElement.getText();
			System.out.println(text);
			driver.close();
			driver.switchTo().window(parentWindow);
			driver.quit();

		}
	}
}
