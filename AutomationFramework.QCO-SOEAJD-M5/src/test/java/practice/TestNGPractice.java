package practice;

import org.testng.annotations.Test;

public class TestNGPractice {
	@Test(priority=-3)//-3,-3 it will go for ASCii create,delet
	public void createCustomer() {
		System.out.println("create");
	}
	@Test(priority=0)
	public void modifycustomer() {
		System.out.println("modify");
	}
	
	@Test(priority=-3)
	public void deletCustomer() {
		System.out.println("delet");
	}
	@Test(invocationCount=-1)//Disabled
	public void createCustomer1() {
		System.out.println("create");
	}
	@Test(invocationCount=2 )//after modify
	public void modifycustomer1() {
		System.out.println("modify1");

}
	@Test(enabled=false)//disable
	public void status() {
		System.out.println("delet");
	//=========================================================================
		
	
		
	}
	}
