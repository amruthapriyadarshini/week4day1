package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//Typing Oneplus 9 pro and hitting ENTER
		WebElement search = driver.findElement(By.xpath("//div[@class='nav-search-field ']/input"));
		search.sendKeys("oneplus 9 pro");
		search.sendKeys(Keys.ENTER);
		
		//Getting the price of the first product
		WebElement wbPrice = driver.findElement(By.
				xpath("(//span[@class='a-price']/span/following-sibling::span/span[2])[1]"));
		String price = 	wbPrice.getText();
				
		Thread.sleep(1000);
		//Printing the number of customer ratings of the first product
		driver.findElement(By.
				xpath("//span[@class='a-size-base s-underline-text'][1]")).
				getText();
		
		//Clicking on the first text link of the product
		driver.findElement(By.
				xpath("//span[text()='OnePlus 9 Pro 5G (Morning Mist, 8GB RAM, 128GB Storage)']")).
				click();
		//Taking a screen shot of the product
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./oneplus.png");
		FileUtils.copyFile(source, destination);
		Set<String> winHandle = driver.getWindowHandles();
		List<String> lstHandle = new ArrayList<String>(winHandle);
		driver.switchTo().window(lstHandle.get(1));
		
		//Clicking on Add to cart button.
		driver.findElement(By.id("add-to-cart-button")).click();
		Set setSubTotal = driver.getWindowHandles();
		List<String> lstSubTotal = new ArrayList<String>(setSubTotal);
		driver.switchTo().window(lstSubTotal.get(1));
		Thread.sleep(1000);
		String subTotal = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		
		//Checking if the totals are same.
		if (price.contains(subTotal))
			System.out.println("Values are same");
		driver.close();
	}

}
