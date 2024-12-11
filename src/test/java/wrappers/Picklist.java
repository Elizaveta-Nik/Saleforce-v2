package wrappers;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Picklist {

    WebDriver driver;
    String label;
    String pickListPattern = "//label[text()='%s']//ancestor::lightning-picklist";

    public Picklist(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    @Description("Выбор элемента из выпадающего списка")
    public void select(String option) {
        log.info("Selecting '{}' inside picklist '{}'", option, label);
        driver.findElement(By.xpath(String.format(pickListPattern + "//button", label)))
                .click();
        driver.findElement(By.xpath(String.format(pickListPattern + "//lightning-base-combobox-item//span[text()='%s']",
                label, option))).click();
    }
}