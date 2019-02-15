package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;

public class ShoppingCard extends PageObject {

    private static DecimalFormat df2 = new DecimalFormat("0.00");

    public ShoppingCard(WebDriver driver) {
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

    public Double getFirstPrice() {
        return Double.parseDouble(firstPrice.getText().substring(1));
    }

    public Double getSecondPrice() {
        return Double.parseDouble(secondPrice.getText().substring(1));
    }

    public Double getShipping() {
        return Double.parseDouble(shipping.getText().substring(1));
    }

    public Double getTotalPrice() {
        return Double.parseDouble(totalPrice.getText().substring(1));
    }
}
