package baseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pom.HomePage;
import pom.LoginPage;
import propertiesFileUtility.PropertiesUtility;

public class BaseClass {
	
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	
	public PropertiesUtility putil = new PropertiesUtility();
	@BeforeSuite(groups= {"Smoke","Regression"})
	public void beforesuite() {
	Reporter.log("DB Connectivity open",true);
	}
	@BeforeTest(groups= {"Smoke","Regression"})
	public void beforetest() {
	System.out.println("preconditions");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"Smoke","Regression"})
	public void beforeclass(/*String BROWSER*/) throws IOException {
	String BROWSER = putil.getdatafrompropertiesfile("Browser");
	if(BROWSER.equals("Edge")) {
	driver= new EdgeDriver();
	}
	else if(BROWSER.equals("Chrome")) {
	driver= new ChromeDriver();
	}
	else if(BROWSER.equals("Firefox")) {
	driver= new FirefoxDriver();
	}
	sdriver=driver;
	System.out.println("lauching Browser");
	driver.manage().window().maximize();
	}
	
	@BeforeMethod(groups= {"Smoke","Regression"})
	public void beforeMethod() throws IOException {
	String BROWSER = putil.getdatafrompropertiesfile("Browser");
	String URL = putil.getdatafrompropertiesfile("Url");
	String USERNAME = putil.getdatafrompropertiesfile("Username");
	String PASSWORD= putil.getdatafrompropertiesfile("Password");
	driver.get(URL);
	LoginPage lp = new LoginPage(driver);
	lp.getUN().sendKeys(USERNAME);
	lp.getPW().sendKeys(PASSWORD);
	lp.getLoginbtn().click();
	System.out.println("LOGIN DONE");
	}
	@AfterMethod(groups= {"Smoke","Regression"})
	public void aftermethod() {
	HomePage hp = new HomePage(driver);
	
	
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("user-icon"))); // Use By.className as per your HomePage POM
    wait.until(ExpectedConditions.elementToBeClickable(By.className("user-icon")));
	
    
    hp.getUserIcon().click();
	
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Logout ']"))); // Use By.xpath as per your HomePage POM
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Logout ']")));
    
    
	hp.getLogoutBtn().click();
	System.out.println("LOGOUT DONE");
	}
	@AfterClass(groups= {"Smoke","Regression"})
	public void afterClass() {
	driver.quit();
	System.out.println("closing browser");
	}
	@AfterTest(groups= {"Smoke","Regression"})
	public void aftertest() {
	System.out.println("POST CONDITIONS");
	}
	@AfterSuite(groups= {"Smoke","Regression"})
	public void afterSuite() {
	System.out.println("closeDB Connectivity");
	}
	}


