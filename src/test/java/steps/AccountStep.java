package steps;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.Accounts.AccountsPage;
import pages.Accounts.NewAccountModal;
import pages.HomePage;

@Log4j2
public class AccountStep {

    private final HomePage homePage;
    private final AccountsPage accountsPage;
    private final NewAccountModal newAccountModal;

    public AccountStep(WebDriver driver) {
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        newAccountModal = new NewAccountModal(driver);
        log.info("AccountStep initialized with driver: {}", driver);
    }

    @Step("Создание нового аккаунта")
    public void create(Account account) {
        log.info("Starting account creation for: {}", account);
        homePage.open()
                .isPageOpened()
                .selectMenuOption("Accounts", AccountsPage.class)
                .clickOnActionButton("New")
                .createAccount(account)
                .clickButton("Save");
    }
}
