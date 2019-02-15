package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayerCart extends PageObject {

    public LayerCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cross")
    private WebElement exitWindow;

    public WebElement exitWindow() {
        return exitWindow;
    }

    public void closeLayerCart() {
        exitWindow.click();
    }
}
