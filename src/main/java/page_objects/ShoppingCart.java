package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;
import java.util.List;

public class ShoppingCart extends PageObject {

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "product_price_3_13_0")
    private WebElement firstPrice;

    @FindBy(id = "product_price_4_16_0")
    private WebElement secondPrice;

    @FindBy(id = "total_shipping")
    private WebElement shipping;

    @FindBy(id = "total_price_container")
    private WebElement totalPrice;

    @FindBy(className = "cart_item")
    private List<WebElement> sizeOfElements;

    @FindBy(className = "cart_quantity_delete")
    private WebElement deleteElement;

    @FindBy(id = "product_2_7_0_0")
    private WebElement isVisible;

    public Double firstPrice() {
        return Double.parseDouble(firstPrice.getText().substring(1));
    }

    public Double secondPrice() {
        return Double.parseDouble(secondPrice.getText().substring(1));
    }

    public Double shipping() {
        return Double.parseDouble(shipping.getText().substring(1));
    }

    public Double totalPrice() {
        return Double.parseDouble(totalPrice.getText().substring(1));
    }

    public String getTotalPriceString() {
        return String.format("%8.2f", totalPrice());
    }

    public String sum() {
        return String.format("%8.2f", (firstPrice() + secondPrice() + shipping()));
    }

    public List<WebElement> getSizeOfElements() {
        return sizeOfElements;
    }

    public WebElement deleteElement() {
        return deleteElement;
    }

    public WebElement checkElement() {
        return isVisible;
    }
}