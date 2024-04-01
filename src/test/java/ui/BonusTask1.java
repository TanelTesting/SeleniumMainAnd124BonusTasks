package ui;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.awt.Dimension;
import java.util.List; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BonusTask1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); 
		
		driver.get("https://www.playtech.ee/");
		driver.manage().window().maximize(); 
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/a[1]")).click(); //accept cookies 
		Thread.sleep(3000); 
		
		//katsetus! System.out.println(PartofMaintaskten.internalProject);
		//System.out.println(PartofMaintaskten.!internalProject); 
		
		WebElement whoweare = driver.findElement(By.xpath("/html/body/header/div/nav/a[1]"));
				
		
		org.openqa.selenium.Dimension whoweareDim = whoweare.getSize();
		//System.out.println(((Rectangle) whoweare).getHeight());
		
		Point pnt = whoweare.getLocation(); 
		Rectangle selfour = whoweare.getRect(); 
		
	
		int NumberX=pnt.getX();
		int NumberY=pnt.getY();
		
		System.out.println("Position of X and Y points is: " + pnt);
		System.out.println(NumberX);
		System.out.println(NumberY); 
		System.out.println("Rectangle size is " +selfour);
		
		
		Thread.sleep(3000);
		
		Actions act= new Actions(driver); 
		act.moveByOffset(NumberX, NumberY).click().perform(); 
		//act.moveByOffset(NumberX, NumberY).click(); 
		
	}

}
