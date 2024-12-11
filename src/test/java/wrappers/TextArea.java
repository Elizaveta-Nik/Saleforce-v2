package wrappers;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TextArea {//для больших полей

    WebDriver driver;
    String label;
    String textAreaPattern = "//label[text()='%s']//ancestor::lightning-textarea";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    @Description("Ввод текста в широкое поле")
    public void write(String text) {//Billing Street, Shipping Street, Description
        log.info("Writing '{}' into '{}'", text, label);
        driver.findElement(By.xpath(String.format(textAreaPattern + "//textarea", label)))
                .sendKeys(text);
    }
}
