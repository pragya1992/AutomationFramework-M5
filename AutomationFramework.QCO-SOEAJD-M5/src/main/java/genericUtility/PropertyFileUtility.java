package genericUtility;
//For Comman Data , For Test dat will use Excel
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *This class consist of reusable method related propertyFile
 * @author Pragya;
 */
public class PropertyFileUtility {
	
	/**
	 * This method will read data from property file for the key provided by caller and return the value to caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String  readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommaData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
		
		
	}

}
