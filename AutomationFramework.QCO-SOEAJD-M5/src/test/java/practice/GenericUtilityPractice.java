package practice;

import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileutility;
import genericUtility.ExcelFileUtility;
public class GenericUtilityPractice {

	public static void main(String[] args) {
		
		PropertyFileUtility pUtil=new PropertyFileUtility ();
 
		String value=pUtil.readDataFromPropertyFile("url");
		
		System.out.println(value);
		
		String value1=pUtil.readDataFromPropertyFile("password");
		System.out.println(value1);
		
		
		
		genericUtility.JavaUtility jUtil=new JavaUtility();
		String date=jUtil.getSystemDateInFormat();
		System.out.println(date);
		
		
		int ran = jUtil.getRandomNumber();
		System.out.println(ran);
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String orgname = eUtil.readDataFromExcel("Organizations", 1, 2);
		String orgNameWithRandom =orgname+ran;
		
		System.out.println(orgname);
		System.out.println(orgNameWithRandom);
		
	}

}
