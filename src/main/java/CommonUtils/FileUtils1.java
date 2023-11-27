package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils1 {

	public String GetDataFromPropertyFile(String key) throws IOException
	{
		 FileInputStream fis = new FileInputStream("src\\test\\resources\\Vtiger.properties");
		 Properties p =new Properties();
		 p.load(fis);
	     String value = p.getProperty(key);
		 return value;		
	}
}
