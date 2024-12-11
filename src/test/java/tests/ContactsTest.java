package tests;

import com.github.javafaker.Faker;
import dto.Contact;
import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;


@Log4j2
public class ContactsTest extends BaseTest {

    Faker faker = new Faker();
    Contact contactTest = Contact.builder()
            .salutation("Dr.")
            .firstName("Veta")
            .lastName(faker.name().lastName())
            .phone(faker.phoneNumber().phoneNumber())
            .phone(faker.phoneNumber().phoneNumber())
            .build();

    @Test(testName = "Create a new contact",
            description = "Verify that a new contact can be created with valid data")
    @Description("Creating a new contact with valid data")
    public void checkCreateContact() {
        log.info("Starting test: Create a new contact");

        loginStep.login();
        log.info("Logged into the system");

        contactStep.create(contactTest);
        log.info("Contact created");

        boolean isContactCreated = contactsPage.contactCreated();
        log.info("Contact creation verification: {}", isContactCreated);

        Assert.assertTrue(isContactCreated, "Contact was not created.");
        log.info("Test completed: Create a new contact");
    }
}
