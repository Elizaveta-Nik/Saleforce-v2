package dto;

import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ContactFactory {

    public static Contact getContact(String salutation, String leadSource, String level) {
        Faker faker = new Faker();
        return new Contact(
                salutation,
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().phoneNumber(), // phone
                faker.phoneNumber().phoneNumber(), // homePhone
                faker.phoneNumber().cellPhone(),    // mobile
                faker.phoneNumber().phoneNumber(), // otherPhone
                faker.phoneNumber().phoneNumber(), // fax
                faker.company().name(),             // title
                faker.commerce().department(),      // department
                faker.date().birthday(1, 99).toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
                        .format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),           // birthdate
                faker.internet().emailAddress(),    // email
                faker.name().fullName(),            // assistant
                leadSource,                         // leadSource
                faker.phoneNumber().phoneNumber(),  // asstPhone
                faker.address().streetAddress(),     // mailingStreet
                faker.address().city(),              // mailingCity
                faker.address().state(),             // mailingState
                faker.address().zipCode(),           // mailingZip
                faker.address().country(),           // mailingCountry
                faker.address().streetAddress(),     // otherStreet
                faker.address().city(),              // otherCity
                faker.address().state(),             // otherState
                faker.address().zipCode(),           // otherZip
                faker.address().country(),           // otherCountry
                faker.programmingLanguage().name(),  // languages
                level,                               // level
                faker.lorem().paragraph()            // description
        );
    }
}
