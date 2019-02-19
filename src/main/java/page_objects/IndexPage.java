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

    @FindBy(className = "sf-with-ul")
    private WebElement womenPage;

    public WebElement exitWindowSuccess() {
        return exitWindow;
    }

    public void clickAddButton() {
        addButton.click();
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public List<WebElement> findElement() {
        return listOfElements;
    }

    public WebElement womenPage() {
        return womenPage;
    }

    public void clickWomensPageButton() {
        womenPage.click();
    }
}