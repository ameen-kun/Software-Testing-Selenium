package day5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task5 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeOptions opt=new EdgeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("start-maximized");
		WebDriver driver = new EdgeDriver(opt);
//	    driver.get("https://www.google.com");
//	    driver.findElement(By.name("q")).sendKeys("Apple");
//	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//	    System.out.print(driver.getWindowHandle()+" : ");
//	    System.out.println(driver.getTitle());
//	    driver.switchTo().newWindow(WindowType.WINDOW);
//	    driver.get("https://www.google.com");
//	    driver.findElement(By.name("q")).sendKeys("Selenium");
//	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//	    System.out.print(driver.getWindowHandle()+" : ");
//	    System.out.println(driver.getTitle());
//	    driver.switchTo().newWindow(WindowType.WINDOW);
//	    driver.get("https://www.google.com");
//	    driver.findElement(By.name("q")).sendKeys("Cucumber");
//	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//	    System.out.print(driver.getWindowHandle()+" : ");
//	    System.out.println(driver.getTitle());
//	    Set<String>s=driver.getWindowHandles();
//	    System.out.println(s.size());
		driver.get("https://www.google.com");
		Thread.sleep(500);
		for(int i=0;i<2;i++) {
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.get("https://www.google.com");
		}
		String arr[]= {"Apple","Selenium","Cucumber"};
		int x=0;
		Set<String> s=driver.getWindowHandles();
		for(String h:s) {
			driver.switchTo().window(h);
			driver.findElement(By.name("q")).sendKeys(arr[x]);
		    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		    System.out.print(driver.getWindowHandle()+" : ");
		    System.out.println(driver.getTitle());
		    x++;
		}
		System.out.println("Number of windows : "+s.size());
	}

}
