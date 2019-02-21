package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends PageObject{

    public ContactUs(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement setEmail1;

    @FindBy(id = "message")
    private WebElement sendMessage1;

    @FindBy(id = "errorMEssage")
    private WebElement erorrMessage;

    public WebElement setEmail() {
        return setEmail1;
    }

    public WebElement sendMessage() {
        return sendMessage1;
    }

    public WebElement checkErrorMessage() {
        return erorrMessage;
    }
}
