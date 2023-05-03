package day7;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Task2 {
	int a,b,c;
//	@BeforeTest
	@BeforeSuite
	public void getData() {
//		System.out.println("Enter a,b:");
//		Scanner sc=new Scanner(System.in);
//		a=sc.nextInt();
//		b=sc.nextInt();
		a=6;
		b=9;
		System.out.println("A = "+a+"\nB = "+b);
	}
  @Test
  public void add() {
	  c=a+b;
	  System.out.println("Add "+c);
	  Assert.assertEquals(c, 15);
  }
  @Test(priority=2)
  public void subtract() {
	  c=a-b;
	  System.out.println("Sub "+c);
	  Assert.assertEquals(c, -3);
  }@Test(priority=3)
  public void multiply() {
	  c=a*b;
	  System.out.println("Mul "+c);
	  Assert.assertEquals(c, 54);
  }@Test(priority=4)
  public void divide() {
	  c=a/b;
	  System.out.println("Div "+c);
	  Assert.assertEquals(c, 0);
  }
}
