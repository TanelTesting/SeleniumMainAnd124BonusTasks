package ui;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class BonusTask4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// -=Bonus Task4=- 
		
				WebDriverManager.chromedriver().setup(); 
				ChromeDriver driver = new ChromeDriver(); 
				
				driver.get("https://www.playtech.ee/");
				driver.manage().window().maximize(); 
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/a[1]")).click(); //accept cookies 
				
				
				Actions actions = new Actions(driver);
				WebElement languageElement = driver.findElement(By.xpath("/html/body/header/div/div/div/div[1]")); //hover mouse over the EN 
				actions.moveToElement(languageElement).perform();
				
				driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/a")).click(); //click on ET 
				/*
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				driver.findElement(By.xpath("/html/body/header/div/nav/a[1]")).click(); //click on MEIST 
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				//Run the JavaScript code for scrolling 
				JavascriptExecutor jse = (JavascriptExecutor) driver;  
				jse.executeScript("window.scrollBy(0,1200)");
				
				//ensure the visibility of "Meie asukohad" 
				List<WebElement> elements = driver.findElements(By.xpath("/html/body/main/section[4]/div/h2"));
				
				for (WebElement element : elements) { 
					if (element.isDisplayed()) {
						System.out.println("\"Meie asukohad\" is displayed");  
					} else {
					System.out.println("Main task failed: element is not displayed"); 
					}
				}
				
				driver.close(); 
		
		
		
		
		
		
		
	}

}
