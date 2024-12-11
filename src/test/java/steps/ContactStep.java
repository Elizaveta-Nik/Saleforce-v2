package steps;

import dto.Contact;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.Contacts.ContactsPage;
import pages.Contacts.NewContactModal;
import pages.HomePage;

@Log4j2
public class ContactStep {

    private final HomePage homePage;
    private final ContactsPage contactsPage;
    private final NewContactModal newContactModal;

    public ContactStep(WebDriver driver) {
        homePage = new HomePage(driver);
        contactsPage = new ContactsPage(driver);
        newContactModal = new NewContactModal(driver);
    }

    @Step("Создание нового контакта")
    public void create(Contact contact) {
        log.info("Starting contact creation for: {}", contact);
        homePage.open()
                .isPageOpened()
                .selectMenuOption("Contacts", ContactsPage.class)
                .clickOnActionButton("New")
                .createContact(contact)
                .clickButton("Save");
    }
}