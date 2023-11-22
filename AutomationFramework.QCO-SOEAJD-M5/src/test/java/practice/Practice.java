package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;

public class Practice extends BaseClass {
@Test(groups="SmokeSuite")
public void sample1Test() {
	System.out.println("Hello1");
	Assert.fail();
}
@Test
public void sample2Test() {
	System.out.println("Hello2");
	
}
@Test
public void sample3Test() {
	System.out.println("Hello3");
	
}
}
