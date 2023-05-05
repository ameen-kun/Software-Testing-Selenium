package day10;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {
	static ExtentTest test;
	static ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	WebDriver driver;
	static int x=0;
	
	 String screencapture() throws AWTException, IOException
	  {
		 String scrshotl="D://SoftwareTesting//scrshot"+x+".png";
		  Robot robot=new Robot();
	      Dimension scr_size=Toolkit.getDefaultToolkit().getScreenSize();
	      Rectangle rect=new Rectangle(scr_size);
	      BufferedImage scrshot=robot.createScreenCapture(rect);
	      File dest=new File(scrshotl);
	      ImageIO.write(scrshot,"png",dest);
	      return scrshotl;
	  }
  @Test
  public void test1() {
	  test=extent.createTest("Test Case 01");
	  String homeurl="https://www.godaddy.com/en-in";
		 driver.navigate().to(homeurl);
		 String title="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
		 Assert.assertEquals(homeurl, driver.getCurrentUrl());
		 Assert.assertEquals(title, driver.getTitle());
  }
  @Test
  public void test2() throws InterruptedException {
	  test=extent.createTest("Test Case 02");
	  String homeurl="https://www.godaddy.com/en-in";
	  	driver.navigate().to(homeurl);
		 Thread.sleep(2500);
		 driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button")).click();
		 Thread.sleep(2500);
		 driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul/li[2]/a")).click();
  }
  @Test
  public void test3() throws InterruptedException {
	  test=extent.createTest("Test Case 03");
	  	String homeurl="https://www.godaddy.com/en-in";
	  	driver.navigate().to(homeurl);
		 Thread.sleep(2500);
		 driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button")).click();
		 Thread.sleep(2500);
		 driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul/li[2]/a")).click();
		 Thread.sleep(500);
		 String title=driver.getTitle();
		 System.out.println(title);
		 String domsearchurl=driver.getCurrentUrl();
		 Assert.assertEquals(title,"GoDaddy Domain Search - Buy and Register Available Domain Names");
		 Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"8469f0c3-e08f-4343-9756-ce0390b0d581\"]")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"8469f0c3-e08f-4343-9756-ce0390b0d581\"]")).isEnabled());
		 Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"id-1467954b-c5e3-4b0c-9046-9fc94d8ca892\"]/section/div/div/section/div/div[1]/div/div/div[2]/button")).isDisplayed());
		 driver.findElement(By.xpath("//*[@id=\"8469f0c3-e08f-4343-9756-ce0390b0d581\"]")).sendKeys("mydomain");
		 driver.findElement(By.xpath("//*[@id=\"id-1467954b-c5e3-4b0c-9046-9fc94d8ca892\"]/section/div/div/section/div/div[1]/div/div/div[2]/button")).click();
		 Assert.assertNotEquals(domsearchurl, driver.getCurrentUrl());
		 
  }
  @Test
  public void test4() throws InterruptedException {
	  test=extent.createTest("Test Case 04");
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(3000);
	  String loginurl=driver.getCurrentUrl();
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  Thread.sleep(1500);
	  Assert.assertNotEquals(driver.getCurrentUrl(),loginurl);
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")).click();
	  Thread.sleep(1500);
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
	  Thread.sleep(1500);
  }
  @Test
  public void test5() throws InterruptedException {
	  test=extent.createTest("Test Case 05");
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(3000);
	  String loginurl=driver.getCurrentUrl();
	  driver.findElement(By.name("username")).sendKeys("Suvitha");
	  driver.findElement(By.name("password")).sendKeys("12345");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  Thread.sleep(1500);
	  Assert.assertNotEquals(driver.getCurrentUrl(),loginurl);
  }
  @AfterMethod
  public void getResult(ITestResult result) throws IOException, AWTException, InterruptedException {
	  x++;
	  if(result.getStatus() == ITestResult.FAILURE) {
          test.log(Status.FAIL,result.getThrowable());
      }
      else if(result.getStatus() == ITestResult.SUCCESS) {
          test.log(Status.PASS, result.getTestName());
          
      }
      else {
          test.log(Status.SKIP, result.getTestName());
      }
	  Thread.sleep(1500);
	  String scrshotl=screencapture();
	  test.addScreenCaptureFromPath(scrshotl);
  }

  @BeforeTest
  public void setup() {	  htmlReporter=new ExtentHtmlReporter("D:\\SoftwareTesting\\repo.html");
  extent=new ExtentReports();
  extent.attachReporter(htmlReporter);
  htmlReporter.config().setChartVisibilityOnOpen(true);
  htmlReporter.config().setDocumentTitle("Automation Test Report");
  htmlReporter.config().setReportName("Sample Tests");
  htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
  htmlReporter.config().setTheme(Theme.STANDARD);
  WebDriverManager.edgedriver().setup();
  EdgeOptions opt=new EdgeOptions();
  opt.addArguments("--remote-allow-origins=*");
  driver=new EdgeDriver(opt);
  driver.manage().window().maximize();  
  }

  @AfterTest
  public void teardown() {
	  extent.flush();
	  driver.close();
  }

}
