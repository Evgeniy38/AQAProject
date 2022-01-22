package BBC1.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.util.concurrent.TimeUnit.SECONDS;

public class BasePage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='tp-iframe-wrapper tp-active']")
    private WebElement popupWindow;

    @FindBy(xpath = "//button[@class='tp-close tp-active']")
    private WebElement closeButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCloseButtonIfVisiblePopupWindow() {
        if (popupWindow.isDisplayed()) {
            closeButton.click();
        }
    }

    public void implicitWait(long timeWait) {
        driver.manage().timeouts().implicitlyWait(timeWait, SECONDS);
    }
}
