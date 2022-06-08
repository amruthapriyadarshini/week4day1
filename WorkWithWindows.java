package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new  ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		//Clicking Open Home Page button 
		driver.findElement(By.id("home")).click();
		//String originalHandle= driver.getWindowHandle();
		System.out.println(driver.getTitle());
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> lstWindowHandle1 = new ArrayList<String>(windowHandles1);
		
		driver.switchTo().window(lstWindowHandle1.get(1));
		driver.switchTo().window(lstWindowHandle1.get(0));
		driver.switchTo().window(lstWindowHandle1.get(1)).close();
		driver.switchTo().window(lstWindowHandle1.get(0));
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		Set<String> multiWindowHandles = driver.getWindowHandles();
		List<String> lstMultiWinHandle = new ArrayList<String>(multiWindowHandles);
		//Closing the newly opened windows
		driver.switchTo().window(lstMultiWinHandle.get(2)).close();
		driver.switchTo().window(lstMultiWinHandle.get(1)).close();
		driver.switchTo().window(lstMultiWinHandle.get(0));
		
		

		
		Thread.sleep(1000);
		//Clicking on 
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(2000);
		Set<String> waitWinHandle = driver.getWindowHandles();
		List<String> lstWaitWin = new ArrayList<String>(waitWinHandle);
		driver.switchTo().window(lstWaitWin.get(2)).close();
		driver.switchTo().window(lstWaitWin.get(1)).close();
		driver.switchTo().window(lstWaitWin.get(0));
		driver.quit();
	}

}
