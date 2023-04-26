package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 {
	public static void main(String args[]) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions co=new EdgeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver=new EdgeDriver(co);
		driver.manage().window().maximize();
		driver.navigate().to("https://j2store.net/free/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement clothing=driver.findElement(By.xpath("//*[@id=\"Mod112\"]/div/div/ul/li[1]/a/img"));
		clothing.click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.close();
	}
}
