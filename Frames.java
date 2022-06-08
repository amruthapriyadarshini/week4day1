package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("frame1");
		Thread.sleep(1000);
		//Entering Hii in the text box
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Hiii");
		
		Thread.sleep(1000);
		driver.switchTo().frame("frame3");
		//Clicking the check box
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		//Selecting the option Cat in the list box
		driver.findElement(By.xpath("//select[@id='animals']/option[@value='cat']")).click();
		driver.switchTo().parentFrame();
		driver.close();

	}

}
