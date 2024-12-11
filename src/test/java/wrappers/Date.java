package wrappers;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Date {
    WebDriver driver;
    String label;

    public Date(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    @Description("Ввод даты")
    public void write(String text) {
        log.info("Writing '{}' into '{}'", text, label);
        driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-datepicker", label)))
                .sendKeys(text);
    }
}