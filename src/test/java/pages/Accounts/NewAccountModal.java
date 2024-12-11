package pages.Accounts;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import wrappers.Date;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.TextArea;

@Log4j2
public class NewAccountModal extends BasePage {

    private final String BUTTON_PATTERN =
            "//button[text()='%s']//ancestor::records-form-footer//ul[@class='slds-button-group-row']";
    private final By BUTTON_SAVE = By.xpath(
            "//button[text()='Save']//ancestor::records-form-footer//ul[@class='slds-button-group-row']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SAVE));
        return this;
    }

    @Override
    public NewAccountModal open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        return null;
    }

    @Step("Заполнение формы нового аккаунта корректными данными.")
    public NewAccountModal createAccount(Account account) {
        log.info("Creating account '{}'", account.getAccountName());
        //Информация об аккаунте
        new Input(driver, "Account Name").write(account.getAccountName());

        if (account.getRating() != null) {
            new Picklist(driver, "Rating").select(account.getRating());
        }
        if (account.getPhone() != null) {
            new Input(driver, "Phone").write(account.getPhone());
        }
        if (account.getFax() != null) {
            new Input(driver, "Fax").write(account.getFax());
        }
        if (account.getAccountNumber() != null) {
            new Input(driver, "Account Number").write(account.getAccountNumber());
        }
        if (account.getWebsite() != null) {
            new Input(driver, "Website").write(account.getWebsite());
        }
        if (account.getAccountSite() != null) {
            new Input(driver, "Account Site").write(account.getAccountSite());
        }
        if (account.getTickerSymbol() != null) {
            new Input(driver, "Ticker Symbol").write(account.getTickerSymbol());
        }
        if (account.getType() != null) {
            new Picklist(driver, "Type").select(account.getType());
        }
        if (account.getOwnership() != null) {
            new Picklist(driver, "Ownership").select(account.getOwnership());
        }
        if (account.getIndustry() != null) {
            new Picklist(driver, "Industry").select(account.getIndustry());
        }
        if (account.getEmployees() != null) {
            new Input(driver, "Employees").write(account.getEmployees());
        }
        if (account.getAnnualRevenue() != null) {
            new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        }
        if (account.getSicCode() != null) {
            new Input(driver, "SIC Code").write(account.getSicCode());
        }

        if (account.getBillingStreet() != null) {
            new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        }
        if (account.getBillingCity() != null) {
            new Input(driver, "Billing City").write(account.getBillingCity());
        }
        if (account.getBillingState() != null) {
            new Input(driver, "Billing State/Province").write(account.getBillingState());
        }
        if (account.getBillingZip() != null) {
            new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZip());
        }
        if (account.getBillingCountry() != null) {
            new Input(driver, "Billing Country").write(account.getBillingCountry());
        }

        if (account.getShippingStreet() != null) {
            new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        }
        if (account.getShippingCity() != null) {
            new Input(driver, "Shipping City").write(account.getShippingCity());
        }
        if (account.getShippingState() != null) {
            new Input(driver, "Shipping State/Province").write(account.getShippingState());
        }
        if (account.getShippingZip() != null) {
            new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZip());
        }
        if (account.getShippingCountry() != null) {
            new Input(driver, "Shipping Country").write(account.getShippingCountry());
        }

        if (account.getCustomerPriority() != null) {
            new Picklist(driver, "Customer Priority").select(account.getCustomerPriority());
        }
        if (account.getSla() != null) {
            new Picklist(driver, "SLA").select(account.getSla());
        }
        if (account.getDate() != null) {
            new Date(driver, "SLA Expiration Date").write(account.getDate());
        }
        if (account.getSlaSerialNumber() != null) {
            new Input(driver, "SLA Serial Number").write(account.getSlaSerialNumber());
        }
        if (account.getNumberOfLocations() != null) {
            new Input(driver, "Number of Locations").write(account.getNumberOfLocations());
        }
        if (account.getUpsellOpportunity() != null) {
            new Picklist(driver, "Upsell Opportunity").select(account.getUpsellOpportunity());
        }
        if (account.getActive() != null) {
            new Picklist(driver, "Active").select(account.getActive());
        }

        if (account.getDescription() != null) {
            new TextArea(driver, "Description").write(account.getDescription());
        }

        return this;
    }

    @Step("Нажатие на кнопку: {buttonName}")
    public void clickButton(String buttonName) {
        By button = By.xpath(String.format(BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
        new AccountsPage(driver);
    }
}