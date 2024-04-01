package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement; 
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainTaskk {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		// -=Main Task=- 
		
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		
		driver.get("https://www.playtech.ee/");
		driver.manage().window().maximize(); 
		
		//click on "Who we are" 
		driver.findElement(By.xpath("/html/body/header/div/nav/a[1]")).click();   
		//accept cookies
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/a[1]")).click();   
		
		Thread.sleep(3000); 
		
		//Run the JavaScript code for scrolling 
		JavascriptExecutor jse = (JavascriptExecutor) driver;  
		jse.executeScript("window.scrollBy(0,1200)");
		
		//ensure the visibility of "Global presence" 
		List<WebElement> elements = driver.findElements(By.xpath("/html/body/main/section[4]/div/h2"));
		
		for (WebElement element : elements) { 
			if (element.isDisplayed()) {
				System.out.println("\"Global presence\" is displayed");  
				//		-=BONUS TASK 2. STARTS=-
				//PrintWriter sends text to FileWriter, which then writes it to File
				File file = new File("Bonus Task 2.txt");
				FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw); 
				pw.println("\"Global presence\" is displayed"); 
				pw.close(); //close saves the .txt file 				 
				//		-=BONUS TASK 2. ENDS=- 
			} else {
			System.out.println("Main task failed: element is not displayed"); 
			}
		}
		
		//First make sure element is enabled and ...THEN ensure it's displayed 
		//driver.findElement(By.xpath("/html/body/main/section[4]/div/h2")).isEnabled();
		//driver.findElement(By.xpath("/html/body/main/section[4]/div/h2")).isDisplayed(); 
		
		//close the window 
		driver.close();
			
	
		}
}