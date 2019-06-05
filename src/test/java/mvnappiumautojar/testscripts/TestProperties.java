package mvnappiumautojar.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String args[]) throws IOException {
		Properties pr = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/Conf.properties");
		pr.load(fs);
		
		System.out.println(pr.getProperty("device.name"));
	}
}
