package Byju;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookCls {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//label[@for='trial-grade-0']")
	private WebElement rdioBtn;

	@FindBy(xpath = "//label[@for='trial-topic-card-2548318-0']")
	private WebElement chosTpic;

	@FindBy(xpath = "(//div[@class='slot-time-section'])[1]//div//div[1]")
	private WebElement timslt;

	@FindBy(xpath = "//button[@data-text='Book Now']")
	private WebElement confirm;

	public BookCls(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, (30));

	}

	public void radiobtn() {
		System.out.println();
		if (rdioBtn.isEnabled()) {
			System.out.println(rdioBtn.getText());
		}
		wait.until(ExpectedConditions.elementToBeClickable(rdioBtn));
		rdioBtn.click();
	}

	public void chosstopic() {
		System.out.println();
		if (chosTpic.isDisplayed()) {
			System.out.println("Your Topic is ===>" + chosTpic.getText());
		}
		wait.until(ExpectedConditions.elementToBeClickable(chosTpic));
		chosTpic.click();
	}

	public void timslot() {
		System.out.println();
		if (timslt.isDisplayed()) {
			System.out.println("Your Time Slot is " + timslt.getText());
		}
		wait.until(ExpectedConditions.elementToBeClickable(timslt));
		timslt.click();
	}

	public void Bokcls() {
		System.out.println();
		boolean result = confirm.isEnabled();
		if (result == true) {
			System.out.println("Book class button is enabled on screen");
		} else {
			System.out.println("Book class button is not enabled on screen");
		}
		wait.until(ExpectedConditions.elementToBeClickable(confirm));
		confirm.click();
	}

}
