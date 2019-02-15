package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayerCard extends PageObject {

    public LayerCard(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cross")
    private WebElement exitWindow;

    public WebElement exitWindow() {
        return exitWindow;
    }

    public void exitWindowSuccess() {
        exitWindow.click();
    }
}
