package TestWatchVid;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Byju.BookCls;
import Byju.Regit;
import Byju.byjusClasses;
import Byju.profile;

public class Register {
//rrr
	WebDriver driver;
	Regit Reg;
	SoftAssert assertt;
	WebDriverWait wait;
	BookCls bokcls;
	byjusClasses clss;
	profile pro;

	// For Log4j
	Logger logger = LogManager.getLogger(Register.class); // Log4j

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		System.out.println("before class is running");
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		logger.info("Chrome Browser opened");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(
				"https://byjus.com/byjus-classes-book-free-60-mins-class/?utm_source=google&utm_mode=CPA&utm_campaign=K10-IN-Brand-BYJU%27S-USD-Exact&utm_term=byjus&gclid=Cj0KCQjwy5maBhDdARIsAMxrkw30p2qYMoe8xOHblLDi_uHpY-rPiZwNcjD2aSjj0kksaMtQvK4RH9EaAthoEALw_wcB");

		logger.info("Expected site opened");

	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		Thread.sleep(1000);
		Reg = new Regit(driver);
		bokcls = new BookCls(driver);
		clss = new byjusClasses(driver);
		pro = new profile(driver);

	}

	@Test(priority = 1)
	public void byjuChildNm() throws InterruptedException {
		logger.info("Entering info in Byjus Class Schedule form");
		Reg.childname();
		String url1 = driver.getCurrentUrl(); // Actual
		System.out.println(url1);
		assertt = new SoftAssert();
		assertt.assertEquals(url1,
				"https://byjus.com/byjus-classes-book-free-60-mins-class/?utm_source=google&utm_mode=CPA&utm_campaign=K10-IN-Brand-BYJU%27S-USD-Exact&utm_term=byjus&gclid=Cj0KCQjwy5maBhDdARIsAMxrkw30p2qYMoe8xOHblLDi_uHpY-rPiZwNcjD2aSjj0kksaMtQvK4RH9EaAthoEALw_wcB");
		assertt.assertAll();
	}

	@Test(priority = 2)
	public void byjubyjuEnterMob() throws InterruptedException {
		Reg.entermob();
//		String entMob = driver.getTitle(); // Actual
//		System.out.println(entMob);

	}

	@Test(priority = 3)
	public void byjuEmail() throws InterruptedException {
		Reg.email();

	}

	@Test(priority = 4)
	public void byjuState() throws InterruptedException {
		Reg.state();

	}

	@Test(priority = 5)
	public void byjuValidMob() throws InterruptedException {
		Reg.validatemob();
		logger.info("Mobile Number validated");
		Thread.sleep(10000);

	}

	@Test(priority = 7)
	public void byju() throws InterruptedException {
		Reg.submitf();
		Thread.sleep(2000);
		logger.info("Byjus Form Submitted successfully");
		String title = driver.getTitle(); // Actual
		System.out.println(title);
		assertt = new SoftAssert();
		assertt.assertEquals(title, "Register a Free Demo Class - BYJU'S Classes");
		assertt.assertAll();
	}

	@Test(priority = 6)
	public void byjuRadioBtn() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("Filling Details to Book Class");
		bokcls.radiobtn();
		Thread.sleep(2000);
	}

	@Test(priority = 8)
	public void byjuChossTpk() throws InterruptedException {
		bokcls.chosstopic();
		Thread.sleep(5000);

	}

	@Test(priority = 9)
	public void byjuTimSlot() throws InterruptedException {
		bokcls.timslot();
		String url = driver.getCurrentUrl(); // Actual
		System.out.println(url);
		assertt = new SoftAssert();
		assertt.assertEquals(url,
				"https://byjus.com/byjus-classes-book-free-60-mins-class/?utm_source=google&utm_mode=CPA&utm_campaign=K10-IN-Brand-BYJU%27S-USD-Exact&utm_term=byjus&gclid=Cj0KCQjwy5maBhDdARIsAMxrkw30p2qYMoe8xOHblLDi_uHpY-rPiZwNcjD2aSjj0kksaMtQvK4RH9EaAthoEALw_wcB");
		assertt.assertAll();
		Thread.sleep(2000);
	}

	@Test(priority = 10)
	public void byju1Bookcls() throws InterruptedException {
		bokcls.Bokcls();
		logger.info("Class Booked Succesfully.");
	}

	@Test(priority = 11)
	public void byjuBookedClssText() throws InterruptedException {
		clss.classSelText();
		String url2 = driver.getCurrentUrl(); // Actual
		System.out.println(url2);
		assertt = new SoftAssert();
		assertt.assertEquals(url2, "https://byjus.com/learn/byjus-classes/book/session");
		assertt.assertAll();

	}

	@Test(priority = 12)
	public void byjuSideNavItems() throws InterruptedException {
		clss.sdeNavMenu();
	}
	
	@Test(priority = 13)
	public void byjuprofile() throws InterruptedException {
		clss.usrDropDown();
		Thread.sleep(3000);
		clss.myProfileDD();
	}
	
	@Test(priority = 14)
	public void byjuOnProfile() throws InterruptedException {
		Thread.sleep(3000);
		pro.name();
		pro.mail();
		pro.mobNumber();
		String url4 = driver.getCurrentUrl(); // Actual
		System.out.println(url4);
		assertt = new SoftAssert();
		assertt.assertEquals(url4, "https://byjus.com/learn/profile");
		assertt.assertAll();
	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterClass
	public void afterclass() {
		// driver.close();
	}
}
