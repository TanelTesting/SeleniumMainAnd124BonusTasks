package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement; 
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainTask {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// -=Main Task=- 
		
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		
		driver.get("https://www.playtech.ee/");
		driver.manage().window().maximize(); 
		
		driver.findElement(By.xpath("/html/body/header/div/nav/a[1]")).click(); //Click on the "Who we are" tab.  
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/a[1]")).click(); //accept cookies  
		
		Thread.sleep(3000); 
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;  //Run the JavaScript code for scrolling 
		
		jse.executeScript("window.scrollBy(0,1200)");
		
		List<WebElement> elements = driver.findElements(By.xpath("/html/body/main/section[4]/div/h2"));
		
		for (WebElement element : elements) { 
			if (element.isDisplayed()) {
				System.out.println("\"Global presence\" is displayed");  
			} else {
			System.out.println("Main task failed: element is not displayed"); 
			}
		}
		
		driver.findElement(By.xpath("/html/body/main/section[4]/div/h2")).isEnabled();
		driver.findElement(By.xpath("/html/body/main/section[4]/div/h2")).isDisplayed(); 
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("BonusTask2")); //for myself: try/catch needs to be selected 
			writer.write("Bonus task is going to be here"); 
			
			for (WebElement name : elements) {
				writer.write("\n" + elements);
			}
			writer.close(); //for myself: writer.close(); needs to be added, otherwis it won't save anything 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		driver.close();
		

		
		
	}
}