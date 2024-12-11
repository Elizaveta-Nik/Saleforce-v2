package dto;

import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class AccountFactory {

    public static Account getAccount(String rating, String type, String ownership, String industry, String priority,
                                     String sla, String upsellOpportunity, String active) {
        Faker faker = new Faker();
        return new Account(
                "Veta " + faker.company().name(),
                rating,
                faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().cellPhone(),
                faker.idNumber().valid(),
                faker.internet().url(),
                faker.internet().url(),
                faker.idNumber().valid(),
                type,
                ownership,
                industry,
                faker.number().digits(50),
                faker.number().digits(200),
                faker.idNumber().valid(),
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country(),
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country(),
                priority,
                sla,
                faker.date().birthday(1, 99).toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
                        .format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                faker.number().digit(), // slaSerialNumber
                faker.number().digits(70),
                upsellOpportunity,
                active,
                faker.lorem().paragraph() // description
        );
    }
}
