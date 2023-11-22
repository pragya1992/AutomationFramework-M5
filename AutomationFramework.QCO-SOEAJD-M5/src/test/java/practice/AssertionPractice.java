package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
@Test

public void practice()
{
	System.out.println("Step:1");
	Assert.assertEquals(1,1);
	System.out.println("Step:2");
	Assert.assertEquals(2,1);//give the Line no aswell
	System.out.println("Step:3");
	Assert.assertEquals(0,1);//wont Run
	}
@Test

public void practice2()
{ 
	SoftAssert sa=new SoftAssert();

	System.out.println("==============SoftAssert================");
	System.out.println("Step:1");
	System.out.println("Step:2");
	sa.assertEquals(2,1);// Always error accure line no 32 only
	
	//sa.assertAll();//Should at End -Failures logged it will stop the execution 
	
	System.out.println("Step:3");
	Assert.assertEquals(2,1);//all soft fail assert will not recognize bz assert all in last will not run if hard assert got fail
	sa.assertEquals(false, true);
	
	sa.assertAll();//Should at End -Failures logged
}
}
