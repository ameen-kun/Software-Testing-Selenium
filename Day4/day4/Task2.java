package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 {
	public static void main(String args[]) {
		EdgeOptions co=new EdgeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		WebElement fname=driver.findElement(By.id("input-firstname"));
		fname.sendKeys("Ashizuki");
		WebElement lname=driver.findElement(By.id("input-lastname"));
		lname.sendKeys("Izuku");
		WebElement mail=driver.findElement(By.id("input-email"));
		mail.sendKeys("ashizuke@gmail.com");
		WebElement passw=driver.findElement(By.id("input-password"));
		passw.sendKeys("ash@123");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement subr=driver.findElement(By.id("input-newsletter-yes"));
		subr.click();
		WebElement terms=driver.findElement(By.name("agree"));
		terms.click();
		WebElement subm=driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/button"));
		subm.click();
	}
}
