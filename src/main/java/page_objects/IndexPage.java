package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IndexPage extends PageObject {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(partialLinkText = "Add to cart")
    private WebElement addButton;

    @FindBy(className = "cross")
    private WebElement exitWindow;

    @FindBy(className = "product-container")
    private List<WebElement> listOfElements;

    public WebElement exitWindowSuccess() {
        return exitWindow;
    }

    public void addButton() {
        addButton.click();
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public List<WebElement> findElement() {
        return listOfElements;
    }
}
