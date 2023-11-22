package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider="getData")
	
	public void readData(String Name,String Model,int qty,int price) {
		System.out.println("Name:"+Name +"Model:"+Model+"qty:"+qty+"price:"+price);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][]data=new Object[3][4];
		
		data[0][0]="Samsung";
		data[0][1]="A80";
		data[0][2]=12;
		data[0][3]=12000;
		
		data[1][0]="Iphone";
		data[1][1]="A80";
		data[1][2]=12;
		data[1][3]=12000;
		
		data[2][0]="Vivo";
		data[2][1]="A80";
		data[2][2]=12;
		data[2][3]=12000;
		return data;
	}
	
}
