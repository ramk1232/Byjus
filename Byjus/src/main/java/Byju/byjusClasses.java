package Byju;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class byjusClasses {
	WebDriver driver;
	WebDriverWait wait1;
	Actions ac;
	@FindBy(xpath = "//div[@class='classes-selection  card']")
	private WebElement classSelText;

	@FindBy(xpath = "(//div[@class='side-nav-div'])//ul//li")
	private List<WebElement> sdeNavMnu;
	
	@FindBy(xpath = "(//li[@class='dropdown notification-list d-block'])//div[1]//div[1]")
	private WebElement usrDrpDwn;
	
	@FindBy(xpath = "(//div[@class='user_guidetour show dropdown'])//div[2]//a[1]")
	private WebElement myProfile;

	public byjusClasses(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		ac = new Actions(driver);
		wait1 = new WebDriverWait(driver, (150));
	}

	public void classSelText() {
		wait1.until(ExpectedConditions.elementToBeClickable(classSelText));
		System.out.println();
		System.out.println("Your Booked Class details are ===>" + classSelText.getText());
	}

	public void sdeNavMenu() throws InterruptedException {
		System.out.println();
		for (WebElement menu : sdeNavMnu) {
			Thread.sleep(300);
			ac.moveToElement(menu).build().perform();
			System.out.println(menu.getText());
		}
	}
	
	public void usrDropDown() {
		wait1.until(ExpectedConditions.elementToBeClickable(usrDrpDwn));
		System.out.println();
		usrDrpDwn.click();
	}
	
	public void myProfileDD() {
		wait1.until(ExpectedConditions.elementToBeClickable(myProfile));
		System.out.println();
		myProfile.click();
	}
}
