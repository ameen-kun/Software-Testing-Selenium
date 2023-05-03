package day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {
  @Test
  public void task() {
	  WebDriverManager.edgedriver().setup();
	  EdgeOptions opt=new EdgeOptions();
	  opt.addArguments("--remote-allow-origins=*");
	  WebDriver driver=new EdgeDriver(opt);
	  driver.manage().window().maximize();
	  driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
	  String expTitle="Guest Registration Form - User Registration";
	  String actTitle=driver.getTitle();
//	  System.out.println(actTitle);
	  Assert.assertEquals(actTitle, expTitle);
  }
}
