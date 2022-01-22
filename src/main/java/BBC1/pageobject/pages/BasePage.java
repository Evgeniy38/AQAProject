package BBC1.pageobject.pages;

import org.openqa.selenium.WebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.By.xpath;

public class BasePage {

    WebDriver driver;

    private static final String POPUP_WINDOW = "//div[@class='tp-iframe-wrapper tp-active']";
    private static final String CLOSE_BUTTON = "//button[@class='tp-close tp-active']";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCloseButtonIfVisiblePopupWindow () {
        if (driver.findElement(xpath(POPUP_WINDOW)).isDisplayed()) {
            driver.findElement(xpath(CLOSE_BUTTON)).click();
        }
    }

    public void implicitWait(long timeWait){
        driver.manage().timeouts().implicitlyWait(timeWait, SECONDS);
    }
}
