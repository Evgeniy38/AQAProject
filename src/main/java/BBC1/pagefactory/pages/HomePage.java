package BBC1.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//li[@class='orb-nav-newsdotcom']")
    private WebElement newsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNewsButton() {
        newsButton.click();
    }
}