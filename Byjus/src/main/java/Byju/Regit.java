package Byju;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Regit {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement name;

	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mob;

	@FindBy(xpath = "//button[@class='btn']")
	private WebElement validate;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement mail;

	@FindBy(xpath = "//select[@name='state']")
	private WebElement enterstate;

	@FindBy(xpath = "//button[@type='submit'][1]")
	private WebElement submit;

	public Regit(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, (30));
	}

	// Step 3 : Method creation

	public void childname() {
		name.sendKeys("kothale");
	}

	public void entermob() {
		mob.sendKeys("9146607948");
	}

	public void validatemob() {
		validate.click();
	}

	public void email() {
		mail.sendKeys("yesrk786@gmail.com");
	}

	public void state() {
		Select sc = new Select(enterstate);
		sc.selectByValue("Maharashtra");
	}

	public void submitf() {
		submit.click();
	}
}
