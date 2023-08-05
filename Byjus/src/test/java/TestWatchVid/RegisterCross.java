package TestWatchVid;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Byju.BookCls;
import Byju.Regit;

public class RegisterCross {
	
	WebDriver driver;
	Regit Reg;
	SoftAssert assertt;
	WebDriverWait wait;
	BookCls bokcls;
	
	//For Log4j
	Logger logger = LogManager.getLogger(Register.class);   //Log4j
	
	@Parameters("browser")
	
	@BeforeTest
		
		public void openBrowser(String browsername) {
			System.out.println(browsername);
			
			if (browsername.equals("Chrome")) {
				
				System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
				driver = new ChromeDriver();	
			}
			
			if (browsername.equals("Firefox")) {
					
				System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver1.exe");
				driver = new FirefoxDriver();
					
			}
	        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://byjus.com/byjus-classes-book-free-60-mins-class/?utm_source=google&utm_mode=CPA&utm_campaign=K10-IN-Brand-BYJU%27S-USD-Exact&utm_term=byjus&gclid=Cj0KCQjwy5maBhDdARIsAMxrkw30p2qYMoe8xOHblLDi_uHpY-rPiZwNcjD2aSjj0kksaMtQvK4RH9EaAthoEALw_wcB");
		}
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		
		Reg = new Regit(driver);
		bokcls = new BookCls(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		
		System.out.println("before method is running");
		Thread.sleep(3000);
		
		
		logger.info("Entering info in Byjus Class Schedule form");
		
		Reg.childname();
		Thread.sleep(2000);
		Reg.entermob();	
		Thread.sleep(1000);		
		Reg.email();
		Thread.sleep(1000);
		Reg.state();
		Thread.sleep(1000);
		Reg.validatemob();
		Thread.sleep(10000);
		logger.info("Mobile Number validated");
		Thread.sleep(5000);
		bokcls.radiobtn();
		Thread.sleep(1000);
		Reg.submitf();
		logger.info("Byjus Form Submitted successfully");
		Thread.sleep(3000);
		bokcls.chosstopic();
		Thread.sleep(3000);
		bokcls.timslot();
		Thread.sleep(3000);
		bokcls.Bokcls();
		
		logger.info("Byjus Form Submitted successfully");
	}
	
	@Test
	public void byju() {
		System.out.println("test method is running");
		Reg.email();
		String title = driver.getTitle(); // Actual
		Assert.assertEquals(title, "BYJU'S Online learning Programs For K3, K10, K12, NEET, JEE, UPSC & Bank Exams");
	}

	@AfterMethod
	public void afterMethod() {
					
	}
	@AfterClass
	public void afterclass() {
		Reg = null;
		bokcls = null;

	}
	@AfterTest
	public void afterTest() {
		driver.close();
		System.gc();
	}
}


