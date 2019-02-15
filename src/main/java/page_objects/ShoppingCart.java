package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;

public class ShoppingCart extends PageObject {

    private static DecimalFormat df2 = new DecimalFormat("0.00");

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

    public String firstPrice() {
        return String.format("%8.2f",Double.parseDouble(firstPrice.getText().substring(1)));
    }

    public String secondPrice() {
        return String.format("%8.2f",Double.parseDouble(secondPrice.getText().substring(1)));
    }

    public String shipping() {
        return String.format("%8.2f",Double.parseDouble(shipping.getText().substring(1)));
    }

    public String totalPrice() {
        return String.format("%8.2f", Double.parseDouble(totalPrice.getText().substring(1)));
    }

    public String sum() {
        return (firstPrice() + secondPrice() + shipping());
    }
}
