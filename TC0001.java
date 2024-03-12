package demoworkshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC0001 {

	public static void main(String[] args) {
		
		String url="https://demowebshop.tricentis.com/";//Url of the application
		WebDriver driver = new ChromeDriver();
		driver.get(url);
	    driver.manage().window().maximize(); ////Maximize chrome Browser
		
		// Providing valid Email with invalid password
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys("gkchowdary@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		
		// verifying the message
		
		driver.findElement(By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]")).isDisplayed(); 
		
		
		// Providing invalid Email and Valid password
		
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("Gopi2343@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("gopi12");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		//verifying the message
		driver.findElement(By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]")).isDisplayed();
		driver.findElement(By.xpath("//li[normalize-space()='No customer account found']")).isDisplayed();
		driver.findElement(By.id("Email")).clear();
		
		// Input Email Field with only name
		
		driver.findElement(By.id("Email")).sendKeys("gopikrishna");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		
		//verifying the message
		
		driver.findElement(By.xpath("//span[@for=\"Email\"]")).isDisplayed();
		String s1 = driver.findElement(By.xpath("//span[@for=\"Email\"]")).getText();
		System.out.println(s1);
		driver.findElement(By.id("Email")).clear();
		
		//Providing valid EMAIL and VALID Password
		
		driver.findElement(By.id("Email")).sendKeys("gkchowdary.96@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='\"gkchowdary.96@gmail.com\"']")).isDisplayed(); //verification of the Email whether it is displayed or not
		driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click(); //Logout successfully from the application
		driver.close();	
		driver.quit();
	}
}