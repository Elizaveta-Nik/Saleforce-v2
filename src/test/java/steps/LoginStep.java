package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

@Log4j2
public class LoginStep {

    private LoginPage loginPage;

    public LoginStep(WebDriver driver) {
        loginPage = new LoginPage(driver);
        log.info("LoginStep initialized with driver: {}", driver);
    }

    @Step("Войдите в приложение с действительными данными - имя пользователя: {userName}, пароль: {password}.")
    public void login() {
//        String userName = System.getenv("USERNAME");
//        String password = System.getenv("PASSWORD");

        log.info("Starting login process for user");
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox","Password001")
                .open();
        log.info("Login process completed");
    }
}
