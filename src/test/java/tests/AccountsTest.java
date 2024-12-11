package tests;

import com.github.javafaker.Faker;
import dto.Account;
import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;


@Log4j2
public class AccountsTest extends BaseTest {

    Faker faker = new Faker();
    Account accountTest = Account.builder()
            .accountName("Veta")
            .phone("1213123")
            .fax(faker.phoneNumber().cellPhone())
            .rating("Hot")
            .build();

    @Test(testName = "Create a new account",
            description = "Verify that a new account can be created with valid data")
    @Description("Creating a new account with valid data")
    public void checkCreateAccount() {
        log.info("Starting test: Create a new account");

        loginStep.login();
        log.info("Logged into the system");

        accountStep.create(accountTest);

        log.info("Account created");

        boolean isAccountCreated = accountsPage.accountCreated();
        log.info("Account creation verification: {}", isAccountCreated);

        Assert.assertTrue(isAccountCreated, "Account was not created.");
        log.info("Test completed: Create a new account");
    }
}