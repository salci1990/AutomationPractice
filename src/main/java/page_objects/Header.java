package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends PageObject {

    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "login")
    private WebElement loginLink;

    @FindBy(partialLinkText = "Cart")
    private WebElement shoppingCart;

    @FindBy(id = "button_order_cart")
    private WebElement pricesCard;

    @FindBy(tagName = "Contact us")
    private WebElement contactUs;

    public void clickLoginLink() {
        loginLink.click();
    }

    public WebElement shopingCard() {
        return shoppingCart;
    }

    public void openShoppingCard() {
        shoppingCart.click();
    }

    public WebElement checkPriceCard() {
        return pricesCard;
    }

    public void contactUs() {
        contactUs.click();
    }
}
