package com.cg.selenium.mavenSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asobiera\\Downloads\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
		/*
		 * WebElement search = driver.findElement(By.name("q"));
		 * search.sendKeys("Capgemini"); search.submit();
		 */
		
		/*
		 * WebElement images = driver.findElement(By.linkText("Images"));
		 * images.click();
		 */
			//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
			WebElement search = driver.findElement(By.name("field-keywords"));
			search.click();
			search.sendKeys("python");
			driver.findElement(By.className("nav-input")).click();;
			List<WebElement> first = driver.findElements(By.className("s-image"));
			for(int i =0; i<first.size(); i++) {
				try {
				first.get(i).click();
				if(driver.findElement(By.className("a-popover-inner")).isDisplayed())
				{
					Thread.sleep(1000);
					driver.navigate().back();
					first = driver.findElements(By.className("s-image"));
				}
				Thread.sleep(1000);
				WebElement addtocart=driver.findElement(By.id("add-to-cart-button"));
				addtocart.click();
				driver.navigate().back();
				driver.navigate().back();
				first = driver.findElements(By.className("s-image"));
				}
	
				catch(org.openqa.selenium.NoSuchElementException e) {
					driver.navigate().back();
					first = driver.findElements(By.className("s-image"));
				}
				catch(org.openqa.selenium.ElementNotInteractableException e) {
					driver.navigate().back();
					first = driver.findElements(By.className("s-image"));
				}
				
			}
			
			//WebElement login = driver.findElement((By.id("loginbutton")));
			//login.click();
			 

		
		
		
	}

}
