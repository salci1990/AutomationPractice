package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends PageObject{

    public ContactUs(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement setEmail3;

    @FindBy(id = "message")
    private WebElement sendMessage3;

    @FindBy(id = "errorMEssage")
    private WebElement erorrMessage;

    public WebElement setEmail() {
        return setEmail3;
    }

    public WebElement sendMessage() {
        return sendMessage3;
    }

    public WebElement checkErrorMessage() {
        return erorrMessage;
    }
}
