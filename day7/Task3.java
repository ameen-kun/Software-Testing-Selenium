package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 {
	WebDriver driver;
  @Test
  public void pagetest() throws InterruptedException {
	  Thread.sleep(5000);
	  String loginurl=driver.getCurrentUrl();
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  Thread.sleep(1500);
	  Assert.assertNotEquals(driver.getCurrentUrl(),loginurl);
  }
  @BeforeMethod
  public void setup() {
	  WebDriverManager.edgedriver().setup();
	  EdgeOptions opt=new EdgeOptions();
	  opt.addArguments("--remote-allow-origins=*");
	  opt.addArguments("start-maximized");
	  driver=new EdgeDriver(opt);
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterMethod
  public void teardown() {
	  driver.close();
  }

}
