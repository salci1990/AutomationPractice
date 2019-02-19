package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WomenProducts extends PageObject {

    public WomenProducts(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-container")
    private List<WebElement> headingCounter;

    @FindBy(className = "heading-counter")
    private WebElement productsNumber;

    public List<WebElement> elementsCounter() {
        return headingCounter;
    }

    public String getProductsNumber() {
        return productsNumber.getText();
    }

    public Integer pageSizeOfElements() {
        return headingCounter.size();
    }
}