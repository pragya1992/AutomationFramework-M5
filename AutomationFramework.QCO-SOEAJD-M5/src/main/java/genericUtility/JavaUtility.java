package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This Method will return the current system date in specified format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy-hh-mm");
		String currentdate=formatter.format(d);
		return currentdate;
	}
/**
 * This Method will genrate a random number for easy run
 * @return
 */
	public int getRandomNumber() {
		Random r=new Random();
		int value=r.nextInt(1000);
		return value;
	}
}
