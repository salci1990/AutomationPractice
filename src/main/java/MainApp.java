import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import page_objects.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MainApp {

    private WebDriver driver;
    private WebDriverWait wait;
    private SignInPage signInPage;
    private Header header;
    private IndexPage indexPage;
    private LayerCart layerCart;
    private ShoppingCart shoppingCart;
    private WomenProducts womenProducts;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);

        signInPage = new SignInPage(driver);
        header = new Header(driver);
        indexPage = new IndexPage(driver);
        signInPage = new SignInPage(driver);
        header = new Header(driver);
        layerCart = new LayerCart(driver);
        shoppingCart = new ShoppingCart(driver);
        womenProducts = new WomenProducts(driver);
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

    @Test(priority = 1)
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

        assertThat(shoppingCart.sum()).isEqualTo(shoppingCart.getTotalPriceString());
    }

    @Test
    public void checkPageTitleTest() {
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void checkWomensCounterElements() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);
        builder.moveToElement(indexPage.moveToWomenPage()).build().perform();
        indexPage.clickToButton();

        String numberOfElements = womenProducts.pageSizeOfElements().toString();
        Boolean isNumberOfElemenmtsCorrect = womenProducts.getProductsNumber().contains(numberOfElements);

        assertThat(isNumberOfElemenmtsCorrect).isTrue();
    }

    @Test
    public void elementDeleteTest() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);
        builder.moveToElement(indexPage.findElement().get(0)).build().perform();

        indexPage.clickAddButton();

        wait.until(ExpectedConditions.visibilityOf(layerCart.exitWindow()));
        assertThat(layerCart.exitWindow().isDisplayed()).isTrue();
        layerCart.closeLayerCart();

        builder.moveToElement(indexPage.findElement().get(1)).build().perform();

        indexPage.clickAddButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("center_column")));

        wait.until(ExpectedConditions.visibilityOf(layerCart.exitWindow()));
        assertThat(layerCart.exitWindow().isDisplayed()).isTrue();
        layerCart.closeLayerCart();

        builder.moveToElement(header.shopingCard()).build().perform();
        wait.until(ExpectedConditions.visibilityOf(header.checkPriceCard()));
        assertThat(header.checkPriceCard().isDisplayed()).isTrue();
        header.openShoppingCard();

        wait.until(ExpectedConditions.visibilityOf(shoppingCart.checkElement()));

        builder.moveToElement(shoppingCart.deleteElement());
        shoppingCart.deleteElement().click();

        assertThat(shoppingCart.checkElement().isDisplayed());
        wait.until(ExpectedConditions.invisibilityOf(shoppingCart.checkElement()));

        builder.moveToElement(shoppingCart.deleteElement());
        shoppingCart.deleteElement().click();
    }
}