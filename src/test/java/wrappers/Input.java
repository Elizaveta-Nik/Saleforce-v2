package wrappers;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input {//для маленьких полей

    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    @Description("Ввод текста в маленькое поле")
    public void write(String text) {
        log.info("Writing '{}' into '{}'", text, label);
        driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-input//input", label)))
                .sendKeys(text);
    }
}
