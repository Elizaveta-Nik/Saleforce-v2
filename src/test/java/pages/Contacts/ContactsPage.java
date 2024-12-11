package pages.Contacts;

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
public class ContactsPage extends BasePage {

    private final By MESSAGE = By.xpath("//div[@data-aura-class='forceToastMessage']");
    private String ACTION_BUTTON_PATTERN = "//lightning-button/button[text()='%s']";
    private final By TITLE = By.xpath("//span[@title='Name']");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactsPage isPageOpened() {
        log.info("Checking if Contacts page is opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Override
    public ContactsPage open() {
        log.info("Opening Contacts page");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/pipelineInspection");
        return this;
    }

    @Step("Нажатие на кнопку: {buttonName}")
    public NewContactModal clickOnActionButton(String buttonName) {
        log.info("Clicking on action button: {}", buttonName);
        By button = By.xpath(String.format(ACTION_BUTTON_PATTERN, buttonName));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        driver.findElement(button).click();
        return new NewContactModal(driver);
    }

    @Step("Проверка создания аккаунта")
    public boolean contactCreated() {
        log.info("Verifying account creation");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE));
        String result = messageBlock.getAttribute("data-key");
        return (result.equals("success"));
    }
}

//    private final By TITLE = By.xpath("//p[@class='slds-page-header__name-meta']");
//    private final String ADD_NEW_CONTACT = "//button[@name='NewContact']";
//    private final String LIST_VIEW = "//button[@name='pipelineInspectionToListView']";
//    private final String DROP_DOWN_MENU = "//button[@title='Select a List View: Contacts']";
//
//    @Step("Получение заголовка страницы")
//    @Description("Метод для получения заголовка текущей страницы")
//    public String getTitle() {
//        return driver.findElement(TITLE).getText();
//    }
//
//    @Step("Нажатие на кнопку создание нового аккаунта {New}")
//    @Description("Метод для нажатия на кнопку создания нового аккаунта")
//    public void clickAddNewContactButton(String newAccount) {
//        By addToCart = By.xpath(String.format(ADD_NEW_CONTACT, newAccount));
//        driver.findElement(addToCart).click();
//    }
//
//    @Step("Нажатие на кнопку импорт аккаунтов {Import}")
//    @Description("Метод для нажатия на кнопку импорта аккаунтов")
//    public void clickListView(String listView) {
//        By addToCart = By.xpath(String.format(LIST_VIEW, listView));
//        driver.findElement(addToCart).click();
//    }
//
//    @Step("Нажатие на выпадающее меню {dropDownMenu} и выбор элемента {option}")
//    @Description("Выбор элемента из выпадающего списка")
//    public void select(String dropDownMenu, String option) {
//        By addToCart = By.xpath(String.format(DROP_DOWN_MENU, dropDownMenu));
//        driver.findElement(addToCart).click();
//
//       // driver.findElement(By.xpath(String.format("//span[normalize-space()='%s']", option))).click(); не уверена в xpath
//    }