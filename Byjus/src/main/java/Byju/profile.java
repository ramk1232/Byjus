package Byju;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class profile {
	WebDriver driver;
	Actions ac;
	WebDriverWait wait1;
	
	@FindBy(xpath = "//input[@aria-label='fullName']")
	private WebElement nme;
	
	@FindBy(xpath = "//input[@aria-label='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@aria-label='phoneInput']")
	private WebElement mobNo;
	

	public profile(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		ac = new Actions(driver);
		wait1 = new WebDriverWait(driver, (20));
	}

	public void name() {
		try {
		wait1.until(ExpectedConditions.elementToBeClickable(nme));
		System.out.println();
		System.out.println("" + nme.getText());
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void mail() {
		try {
		wait1.until(ExpectedConditions.elementToBeClickable(email));
		System.out.println("" + email.getText());
		}
		catch(Exception e1) {
			e1.getStackTrace();
		}
	}
	
	public void mobNumber() {
		try {
		wait1.until(ExpectedConditions.elementToBeClickable(mobNo));
		System.out.println("" + mobNo.getText());
		}
		catch(Exception e2) {
			e2.getStackTrace();
		}
	}
	
	

}
