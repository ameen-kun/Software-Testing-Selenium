package day7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task5 {
	static WebDriver driver;
	 public static void setup() {
		  WebDriverManager.edgedriver().setup();
		  EdgeOptions opt=new EdgeOptions();
		  opt.addArguments("--remote-allow-origins=*");
		  driver=new EdgeDriver(opt);
	  }
	 @Test(groups={"SmokeTest"})
	 public void test1() {
		 setup();
		 String homeurl="https://www.godaddy.com/en-in";
		 driver.get(homeurl);
		 driver.manage().window().maximize();
		 String title="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
		 Assert.assertEquals(homeurl, driver.getCurrentUrl());
		 Assert.assertEquals(title, driver.getTitle());
		 driver.quit();
		 
  }
	 @Test(groups={"RegressionTest"})
	 public void test2() {
		 setup();
		 String homeurl="https://www.godaddy.com/en-in";
		 driver.get(homeurl);
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button")).click();
		 driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul/li[2]/a")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.quit();
	 }
	 @Test(groups={"RegressionTest"})
	 public void test3() {
		 setup();
		 String homeurl="https://www.godaddy.com/en-in";
		 driver.get(homeurl);
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button")).click();
		 driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul/li[2]/a")).click();
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals(title,"GoDaddy Domain Search - Buy and Register Available Domain Names");
		 
	 }
}
