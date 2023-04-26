package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeOptions opt=new EdgeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.abhibus.com/bus-ticket-booking");
		WebElement source=driver.findElement(By.id("source"));
		source.sendKeys("Coimbatore");
		Thread.sleep(1500);
		source.sendKeys(Keys.ENTER);
		WebElement dest=driver.findElement(By.id("destination"));
		dest.sendKeys("Salem");
		Thread.sleep(1500);
		dest.sendKeys(Keys.ENTER);
		WebElement dat=driver.findElement(By.id("datepicker1"));
		dat.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','28-04-2023')", dat);
//		WebElement date=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[5]/td[2]/a"));
//		date.click();
		WebElement sear=driver.findElement(By.xpath("//*[@id=\"seo_search_btn\"]"));
		sear.click();
	}

}
