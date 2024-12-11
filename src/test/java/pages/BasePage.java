package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

@Log4j2
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log.info("BasePage initialized with driver: {}", driver);
    }

    public void waitForPageLoaded(WebDriver driver) {
        log.info("Waiting for page to load");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Objects.requireNonNull(((JavascriptExecutor) driver)
                        .executeScript("return document.readyState"))
                        .toString().equals("complete");
            }
        });
    }

    public abstract BasePage isPageOpened();
    public abstract BasePage open();
}


//    public void waitForPageLoaded() {
//        new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return Objects.requireNonNull(((JavascriptExecutor) driver).executeScript("return document.readyState"))
//                        .toString().equals("complete");
//            }
//        };
//    }
//
//    public void clickJS(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("argument[0].click();", element);
//    }//для: нажатия на кнопку
//
//    public void scrollJS() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,5000)");
//    }//для: скролла (горизонтально, вертикально) в пикселях
//
//    public void scrollJSElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollIntoView(true);", element);
//    }//для: скролла к конкретному элементу
//
//    public void scroll(){
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.PAGE_UP);//PAGE_DOWN вверх-вниз
//        //actions.moveToElement(driver.findElement(By.id("")));еще вариант
//    }
//}