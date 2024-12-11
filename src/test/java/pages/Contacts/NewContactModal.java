package pages.Contacts;

import dto.Contact;
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
public class NewContactModal extends BasePage {

    private final String BUTTON_PATTERN = "//lightning-button/button[text()='%s']";
    private final By BUTTON_SAVE = By.xpath(
            "//lightning-button/button[text()='New']");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewContactModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SAVE));
        return this;
    }

    @Override
    public NewContactModal open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/new");
        return this;
    }

    @Step("Заполнение формы нового контакта корректными данными.")
    public NewContactModal createContact(Contact contact) {
        log.info("Creating contact '{}' '{}'", contact.getFirstName(),contact.getLastName());
        if (contact.getSalutation() != null) {
            new Picklist(driver, "Salutation").select(contact.getSalutation());
        }
        if (contact.getFirstName() != null) {
            new Input(driver, "First Name").write(contact.getFirstName());
        }
        if (contact.getLastName() != null) {
            new Input(driver, "Last Name").write(contact.getLastName());
        }
        if (contact.getPhone() != null) {
            new Input(driver, "Phone").write(contact.getPhone());
        }
        if (contact.getHomePhone() != null) {
            new Input(driver, "Home Phone").write(contact.getHomePhone());
        }
        if (contact.getMobile() != null) {
            new Input(driver, "Mobile").write(contact.getMobile());
        }
        if (contact.getOtherPhone() != null) {
            new Input(driver, "Other Phone").write(contact.getOtherPhone());
        }
        if (contact.getFax() != null) {
            new Input(driver, "Fax").write(contact.getFax());
        }
        if (contact.getTitle() != null) {
            new Input(driver, "Title").write(contact.getTitle());
        }
        if (contact.getDepartment() != null) {
            new Input(driver, "Department").write(contact.getDepartment());
        }
        if (contact.getBirthdate() != null) {
            new Date(driver, "Birthdate").write(contact.getBirthdate());
        }
        if (contact.getEmail() != null) {
            new Input(driver, "Email").write(contact.getEmail());
        }
        if (contact.getAssistant() != null) {
            new Input(driver, "Assistant").write(contact.getAssistant());
        }
        if (contact.getLeadSource() != null) {
            new Picklist(driver, "Lead Source").select(contact.getLeadSource());
        }
        if (contact.getAsstPhone() != null) {
            new Input(driver, "Asst. Phone").write(contact.getAsstPhone());
        }

        if (contact.getMailingStreet() != null) {
            new TextArea(driver, "Mailing Street").write(contact.getMailingStreet());
        }
        if (contact.getMailingCity() != null) {
            new Input(driver, "Mailing City").write(contact.getMailingCity());
        }
        if (contact.getMailingState() != null) {
            new Input(driver, "Mailing State/Province").write(contact.getMailingState());
        }
        if (contact.getMailingZip() != null) {
            new Input(driver, "Mailing Zip/Postal Code").write(contact.getMailingZip());
        }
        if (contact.getMailingCountry() != null) {
            new Input(driver, "Mailing Country").write(contact.getMailingCountry());
        }

        if (contact.getOtherStreet() != null) {
            new TextArea(driver, "Other Street").write(contact.getOtherStreet());
        }
        if (contact.getOtherCity() != null) {
            new Input(driver, "Other City").write(contact.getOtherCity());
        }
        if (contact.getOtherState() != null) {
            new Input(driver, "Other State/Province").write(contact.getOtherState());
        }
        if (contact.getOtherZip() != null) {
            new Input(driver, "Other Zip/Postal Code").write(contact.getOtherZip());
        }
        if (contact.getOtherCountry() != null) {
            new Input(driver, "Other Country").write(contact.getOtherCountry());
        }

        if (contact.getLanguages() != null) {
            new Input(driver, "Languages").write(contact.getLanguages());
        }
        if (contact.getLevel() != null) {
            new Picklist(driver, "Level").select(contact.getLevel());
        }
        if (contact.getDescription() != null) {
            new TextArea(driver, "Description").write(contact.getDescription());
        }

        return this;
    }

    @Step("Нажатие на кнопку: {buttonName}")
    public void clickButton(String buttonName) {
        By button = By.xpath(String.format(BUTTON_PATTERN, buttonName));
        driver.findElement(button).click();
        new ContactsPage(driver);
    }
}