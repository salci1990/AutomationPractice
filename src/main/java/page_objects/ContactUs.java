package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends PageObject{

    public ContactUs(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement setEmail;

    @FindBy(id = "message")
    private WebElement sendMessage;

    public WebElement setEmail() {
        return setEmail;
    }

    public WebElement sendMessage() {
        return sendMessage;
    }
}
