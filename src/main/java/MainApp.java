import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.*;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class MainApp {

    private WebDriver driver;
    private WebDriverWait wait;
    private SignInPage signInPage;
    private Header header;
    private IndexPage indexPage;
    private LayerCart layerCart;
    private ShoppingCart shoppingCart;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 60);

        signInPage = new SignInPage(driver);
        header = new Header(driver);
        indexPage = new IndexPage(driver);
        signInPage = new SignInPage(driver);
        header = new Header(driver);
        layerCart = new LayerCart(driver);
        shoppingCart = new ShoppingCart(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginErrorTest() {
        driver.get("http://automationpractice.com/index.php");
        header.clickLoginLink();
        signInPage.clickSignInLink();
        assertThat(signInPage.isAlertOn());
    }

    @Test
    public void totalPriceTest() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);
        builder.moveToElement(indexPage.findElement().get(2)).build().perform();

        indexPage.clickAddButton();

        wait.until(ExpectedConditions.visibilityOf(layerCart.exitWindow()));
        assertThat(layerCart.exitWindow().isDisplayed()).isTrue();
        layerCart.closeLayerCart();

        builder.moveToElement(indexPage.findElement().get(3)).build().perform();

        indexPage.clickAddButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("center_column")));

        wait.until(ExpectedConditions.visibilityOf(layerCart.exitWindow()));
        assertThat(layerCart.exitWindow().isDisplayed()).isTrue();
        layerCart.closeLayerCart();

        builder.moveToElement(header.shopingCard()).build().perform();
        wait.until(ExpectedConditions.visibilityOf(header.checkPriceCard()));
        assertThat(header.checkPriceCard().isDisplayed()).isTrue();
        header.openShoppingCard();

        assertThat(shoppingCart.sum()).isEqualTo(shoppingCart.totalPriceString());
    }

    @Test
    public void checkPageTitleTest() {
        driver.get("http://automationpractice.com/index.php");
    }
}