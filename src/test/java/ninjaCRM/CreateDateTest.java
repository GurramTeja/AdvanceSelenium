package ninjaCRM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import excelFileUtilities.ExcelUtility;
import javaUtility.JavaUtility;
import pom.CampaignPage;
import pom.HomePage;
import webDriverUtility.WebDriverUtility;

public class CreateDateTest extends BaseClass {
@Test(groups="Smoke")
public void createDate()throws InterruptedException, IOException {
// TODO Auto-generated method stub
ExcelUtility eutil = new ExcelUtility();
WebDriverUtility wutil= new WebDriverUtility();
JavaUtility jutil = new JavaUtility();
//Read data from excel
String campname = 
eutil.getDataFromExcel("Campaign", 1, 2);
String size = eutil.getDataFromExcel("Campaign", 1, 3);
//int ran = jutil.getRandomNumber();
//String campaignname = campname+ran;
//String expectedate = jutil.togetRequired(30);
//click on create Campaign button
HomePage hp = new HomePage(driver);
hp.getCreatecampaign().click();
//enter mandatory fields
CampaignPage cp = new CampaignPage(driver);
cp.getCampaignName().sendKeys(campname /*campname  +jutil.getRandomAlphaNumericString(10) */);
cp.getTargetsizeTF().sendKeys(size);
// wutil.passinput(driver, cp.getExpectedclosedate(), jutil.togetRequired(30));
wutil.passinput(driver, cp.getExpectedclosedate(), jutil.togetRequired(30));
cp.getCreatecampaignsubmitBtn().click();
 //validation
Thread.sleep(4000);



WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
//Thread.sleep(2000);
wutil.waitforVisibilityofElement(driver, toast);
String msg = toast.getText();
/*
if(msg.contains(campname)) {
System.out.println("campaign is created");
}
else{
System.out.println("campaign not created");
}
*/
Assert.assertEquals(msg, "Campaign "+campname+" Successfully Added");
//Assert.assertTrue(msg.contains(campname));
//Thread.sleep(4000);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust time as needed

// Wait until the "close" button is visible and clickable
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='close']")));
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='close']")));
driver.findElement(By.xpath("//button[@aria-label='close']")).click();
}
}
