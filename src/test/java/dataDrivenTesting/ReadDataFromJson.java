package dataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromJson {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		//parse the json physical file into java obj using json parser
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./TestData/Commondata.json"));
		//convert the java obj in json obj(type casting)
		JSONObject obj1 = (JSONObject)obj;
		//read the data using get()
		System.out.println(obj1.get("Browser"));
		//  String br = obj1.get("Browser").toString();
		
		System.out.println(obj1.get("Url"));
		 String url = obj1.get("Url").toString();
		 
		System.out.println(obj1.get("UserName"));
		String usr = obj1.get("UserName").toString();
		
		System.out.println(obj1.get("Password"));
		String psd = obj1.get("Password").toString();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(usr);
		driver.findElement(By.id("inputPassword")).sendKeys(psd);
		
		
		
		

	}


}
