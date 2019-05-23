
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page_objects.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MainApp {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static SignInPage signInPage;
    public static Header header;
    public static IndexPage indexPage;
    public static LayerCart layerCart;
    public static ShoppingCart shoppingCart;

    @BeforeAll
    public static void setUp() {

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

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @BeforeEach
    public void doBeforeMethod(){
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @Test
    public void loginErrorTest() {
        header.clickLoginLink();
        signInPage.clickSignInLink();
        assertThat(signInPage.isAlertOn());
    }

    @Test
    public void totalPriceTest() {
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
    }
}