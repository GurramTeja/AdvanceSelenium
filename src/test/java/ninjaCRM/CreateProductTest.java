package ninjaCRM;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import excelFileUtilities.ExcelUtility;
import javaUtility.JavaUtility;
import pom.HomePage;
import pom.ProductPage;
import webDriverUtility.WebDriverUtility;

public class CreateProductTest extends BaseClass{
@Test
public void createProduct()throws IOException, InterruptedException {
// TODO Auto-generated method stub
ExcelUtility eutil = new ExcelUtility();
WebDriverUtility wutil= new WebDriverUtility();
JavaUtility jutil = new JavaUtility();
String pname = eutil.getDataFromExcel("Product", 2, 2);
String psize = eutil.getDataFromExcel("Product", 2, 3);
String pprize = eutil.getDataFromExcel("Product", 2, 4);
//int ran = jutil.getRandomNumber();
//String productnname = pname+ran;
 HomePage hp = new HomePage(driver);
hp.getProducts().click();
Thread.sleep(2000);
hp.getProducts().click();
Thread.sleep(4000);
ProductPage ap= new ProductPage(driver);
ap.getProductid();
 
ap.getProductName().sendKeys(pname+jutil.getRandomNumber());
 ap.getQuantity().clear();
 ap.getQuantity().sendKeys(psize);
 ap.getPrice().clear();
// ap.getQuantity().sendKeys(pprize);
 ap.getPrice().sendKeys(pprize);
 wutil.select(ap.getProductCategory(),2);
 wutil.select(ap.getVendorId(), 3);
ap.getAddprodButton().click();
Thread.sleep(4000);
hp.getClosemsg().click();

//Assert.assertEquals(msg, " product "+productnname+" Successfully added");
}


}
