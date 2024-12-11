package pages.Accounts;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

@Log4j2
public class AccountsPage extends BasePage {

    private final By MESSAGE = By.xpath("//div[@data-aura-class='forceToastMessage']");
    private String ACTION_BUTTON_PATTERN = "//div[@title='%s']";
    private final By TITLE = By.xpath("//span[@title='Account Name']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountsPage isPageOpened() {
        log.info("Checking if Accounts page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Override
    public AccountsPage open() {
        log.info("Opening Accounts page");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=AllAccounts");
        return this;
    }

    @Step("Нажатие на кнопку: {buttonName}")
    public NewAccountModal clickOnActionButton(String buttonName) {
        log.info("Clicking on action button: {}", buttonName);
        By button = By.xpath(String.format(ACTION_BUTTON_PATTERN, buttonName));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        driver.findElement(button).click();
        return new NewAccountModal(driver);
    }

    @Step("Проверка создания аккаунта")
    public boolean accountCreated() {
        log.info("Verifying account creation");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE));
        String result = messageBlock.getAttribute("data-key");
        return (result.equals("success"));
    }
}

//    private final By TITLE = By.xpath("//span[@class='slds-var-p-right_x-small']");
//    private final String ADD_NEW_ACCOUNT = "//div[@title='New']//button";
//    private final String IMPORT_ACCOUNT = "//div[@title='Import']//button";
//    private final String DROP_DOWN_MENU = "//button[@title='Select a List View: Accounts']";
//    private final String PIN_BUTTON = "//button[contains(@title,'Pin this list view.')]";
//
//    @Step("Получение заголовка страницы")
//    @Description("Метод для получения заголовка текущей страницы")
//    public String getTitle() {
//        return driver.findElement(TITLE).getText();
//    }
//
//    @Step("Нажатие на кнопку создание нового аккаунта {New}")
//    @Description("Метод для нажатия на кнопку создания нового аккаунта")
//    public void clickAddNewAccountButton(String newAccount) {
//        By addToCart = By.xpath(String.format(ADD_NEW_ACCOUNT, newAccount));
//        driver.findElement(addToCart).click();
//    }
//
//    @Step("Нажатие на кнопку импорт аккаунтов {Import}")
//    @Description("Метод для нажатия на кнопку импорта аккаунтов")
//    public void clickImportAccountButton(String importAccount) {
//        By addToCart = By.xpath(String.format(IMPORT_ACCOUNT, importAccount));
//        driver.findElement(addToCart).click();
//    }
//
//    @Step("Нажатие на выпадающее меню {dropDownMenu} и выбор элемента {option}")
//    @Description("Выбор элемента из выпадающего списка")
//    public void select(String dropDownMenu, String option) {
//        By addToCart = By.xpath(String.format(DROP_DOWN_MENU, dropDownMenu));
//        driver.findElement(addToCart).click();
//
//        driver.findElement(By.xpath(String.format("//span[normalize-space()='%s']", option))).click();
//    }
//
//    @Step("Нажатие на кнопку закрепления списка")
//    @Description("Метод для нажатия на кнопку 'Pin this list view'")
//    public void clickPinButton() {
//        By pinButton = By.xpath(PIN_BUTTON);
//        driver.findElement(pinButton).click();
//    }