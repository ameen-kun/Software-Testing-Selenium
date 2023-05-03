package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 {
	WebDriver driver;
  @Test
  public void login() throws InterruptedException {
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(5000);
	  String loginurl=driver.getCurrentUrl();
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  Thread.sleep(1500);
	  Assert.assertNotEquals(driver.getCurrentUrl(),loginurl);
  }
  @Test(dependsOnMethods="login")
  public void logout() throws InterruptedException {
	  Thread.sleep(3000);
	  String dash=driver.getCurrentUrl();
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")).click();
	  Thread.sleep(1500);
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
	  Thread.sleep(1500);
	  Assert.assertNotEquals(dash, driver.getCurrentUrl());	  
  }
  @BeforeTest
  public void setup() {
	  WebDriverManager.edgedriver().setup();
	  EdgeOptions opt=new EdgeOptions();
	  opt.addArguments("--remote-allow-origins=*");
	  opt.addArguments("start-maximized");
	  driver=new EdgeDriver(opt);
  }

  @AfterTest
  public void teardown() {
	  driver.close();
  }
}
