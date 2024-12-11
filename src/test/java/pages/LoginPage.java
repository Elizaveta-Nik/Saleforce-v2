package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("username");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e){
            log.error(e.getMessage());
            Assert.fail("Login page don't open");
        }
        waitForPageLoaded(driver);
        return this;
    }

    @Step("Открытие 'Login page'")
    public LoginPage open() {
        log.info("Open LoginPage");
        driver.get("https://tms9-dev-ed.develop.my.salesforce.com/");
        waitForPageLoaded(driver);
        return this;
    }

    @Step("Войдите в приложение с действительными данными - имя пользователя: {userName}, пароль: {password}.")
    public HomePage login(String userName, String password) {
        log.info("Log in using credential '{}', '{}'", userName, password);
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }
}