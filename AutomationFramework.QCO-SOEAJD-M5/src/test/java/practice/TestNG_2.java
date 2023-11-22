package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_2 {
	@Test
	public void createCustomer()
	{   Assert.fail();//fail
		System.out.println("create");
	}
	
	@Test(dependsOnMethods="createCustmer" )//skip
	public void modifyCustomer() {
		System.out.println("modify");
	}
	
	@Test
	public void deletCustomer() {
		System.out.println("delet");//passed
	}
}
