package day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeOptions opt=new EdgeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		WebElement tb=driver.findElement(By.name("cusid"));
		WebElement sub=driver.findElement(By.name("submit"));
		tb.clear();
		tb.sendKeys("401");
		Thread.sleep(1000);
		sub.click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		tb.clear();
		tb.sendKeys("402");
		Thread.sleep(1000);
		sub.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		Alert al=driver.switchTo().alert();
		String msg=al.getText();
		Thread.sleep(1000);
		al.accept();
		System.out.println(msg);
	}

}
