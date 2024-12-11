package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Accounts.AccountsPage;
import pages.Contacts.ContactsPage;

@Log4j2
public class HomePage extends BasePage {

    private final String MENU_OPTION_PATTERN = "//span[text()='%s']//ancestor::one-app-nav-bar-item-root[@role='listitem']";
    private final By TITLE = By.xpath("//img[@alt='User']//ancestor::button[@type='button']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage isPageOpened() {
        log.info("Checking if Home page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Step("Opening 'Home page'")
    public HomePage open() {
        log.info("Opening Home page");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/page/home");
        waitForPageLoaded(driver);
        log.info("Home page opened successfully");
        return this;
    }

    @Step("Selecting menu option: {optionName}")
    public <T> T selectMenuOption(String optionName, Class<T> pageClass) {
        log.info("Selecting menu option: {}", optionName);
        By setOption = By.xpath(String.format(MENU_OPTION_PATTERN, optionName));
        driver.findElement(setOption).click();

        if (pageClass.equals(AccountsPage.class)) {
            log.info("Navigating to Accounts page");
            return pageClass.cast(new AccountsPage(driver));
        } else if (pageClass.equals(ContactsPage.class)) {
            log.info("Navigating to Contacts page");
            return pageClass.cast(new ContactsPage(driver));
        } else {
            throw new IllegalArgumentException("Unsupported page class: " + pageClass.getName());
        }
    }
}
