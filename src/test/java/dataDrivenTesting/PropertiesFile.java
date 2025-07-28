package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesFile {
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Basic Selenium\\basic.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String usr = pro.getProperty("UN1");
		String psd = pro.getProperty("PSWD1");
		String url = pro.getProperty("URL");
		String brw = pro.getProperty("BROWSER");
		String cname = pro.getProperty("CAMPNAME");
		String size = pro.getProperty("TARGETSIZE");
		String date = pro.getProperty("EXPDATE");
		
		
		
		WebDriver driver=null;
		if(brw.equals("edge")) {
			driver=new EdgeDriver();
		}
		if(brw.equals("chrome")) {
			driver=new ChromeDriver();
		}
		if(brw.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(usr);
		driver.findElement(By.id("inputPassword")).sendKeys(psd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(cname);
		driver.findElement(By.name("targetSize")).sendKeys(size);
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys(date);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='user-icon']")).click();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		
		

	}


}
