package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	WebDriver driver;
	public CampaignPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "campaignName")
	private WebElement campaignName;
	
	@FindBy(name = "campaignStatus")
	private WebElement campaignstatus;
	
	@FindBy(name = "targetSize")
	private WebElement targetsizeTF;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expectedclosedate;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createcampaignsubmitBtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getCampaignstatus() {
		return campaignstatus;
	}

	public WebElement getTargetsizeTF() {
		return targetsizeTF;
	}

	public WebElement getExpectedclosedate() {
		return expectedclosedate;
	}

	public WebElement getCreatecampaignsubmitBtn() {
		return createcampaignsubmitBtn;
	}
	
}
