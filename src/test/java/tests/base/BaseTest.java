package tests.base;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Accounts.AccountsPage;
import pages.Accounts.NewAccountModal;
import pages.Contacts.ContactsPage;
import pages.Contacts.NewContactModal;
import pages.HomePage;
import pages.LoginPage;
import steps.AccountStep;
import steps.ContactStep;
import steps.LoginStep;
import tests.TestListener;
import utils.PropertyReader;

import java.time.Duration;

@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {

    protected WebDriver driver;
    protected NewAccountModal newAccountModal;
    protected LoginPage loginPage;
    protected AccountsPage accountsPage;
    protected ContactsPage contactsPage;
    protected NewContactModal newContactModal;
    protected AccountStep accountStep;
    protected ContactStep contactStep;
    protected LoginStep loginStep;
    protected HomePage homePage;

    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    @Description("Opening browser")
    public void setup(@Optional("chrome") String browser) {
        log.info("Setting up browser: {}", browser);
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-notifications");
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        newAccountModal = new NewAccountModal(driver);
        newContactModal = new NewContactModal(driver);
        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
        contactsPage = new ContactsPage(driver);
        accountStep = new AccountStep(driver);
        contactStep = new ContactStep(driver);
        loginStep = new LoginStep(driver);
        homePage = new HomePage(driver);
        log.info("Browser setup completed");
    }

    @AfterMethod(alwaysRun = true)
    @Description("Closing browser")
    public void tearDown(ITestResult result) {
        log.info("Tearing down browser");
        driver.quit();
        log.info("Browser closed");
    }
}
