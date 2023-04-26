package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 {
	public static void main(String args[]) {
		EdgeOptions co=new EdgeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=checkout/voucher&language=en-gb");
		WebElement rname=driver.findElement(By.xpath("//*[@id=\"input-to-name\"]"));
		rname.sendKeys("Izuku Midoriya");
		WebElement rmail=driver.findElement(By.xpath("//*[@id=\"input-to-email\"]"));
		rmail.sendKeys("midoriya@gmail.com");
		WebElement mname=driver.findElement(By.xpath("//*[@id=\"input-from-name\"]"));
		mname.sendKeys("Ashizuki");
		WebElement mmail=driver.findElement(By.xpath("//*[@id=\"input-from-email\"]"));
		mmail.sendKeys("ashizuki@gmail.com");
		WebElement gtype=driver.findElement(By.xpath("//*[@id=\"input-theme-7\"]"));
		gtype.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement msg=driver.findElement(By.xpath("//*[@id=\"input-message\"]"));
		msg.sendKeys("Happy Birthday xoxo <3!!!");
		WebElement amt=driver.findElement(By.xpath("//*[@id=\"input-amount\"]"));
		amt.clear();
		amt.sendKeys("69");
		WebElement checkb=driver.findElement(By.xpath("//*[@id=\"form-voucher\"]/div[8]/div/div/input"));
		checkb.click();
		WebElement subm=driver.findElement(By.xpath("//*[@id=\"form-voucher\"]/div[8]/div/button"));
		subm.click();
	}
}
