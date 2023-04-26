package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions eopt=new EdgeOptions();
		eopt.addArguments("--remote-allow-orgins=*");
		WebDriver driver=new EdgeDriver(eopt);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/droppable/");
		Actions act=new Actions(driver);
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		act.clickAndHold(drag).release(drop).build().perform();
//		act.dragAndDrop(drag, drop).build().perform();
	}

}
