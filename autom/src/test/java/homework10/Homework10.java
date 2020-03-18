package homework10;

import org.hamcrest.CoreMatchers;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Cristina on 14.03.2020.
 * Custom waits
 */
public class Homework10 {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // don't mix implicit and explicit waits
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyFirstTipIsCorrectlyUpdatedAfterEnteringNewQuery() {
        driver.findElement(By.id("search_query_top"))
                .clear();
        driver.findElement(By.id("search_query_top"))
                .sendKeys("Dress");

        WebElement firstTip = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")));

        Assert.assertThat(firstTip.getText(),
                CoreMatchers.containsString("Dress"));

        WebElement fifthTip = (new WebDriverWait(driver, 10))
                .until(MyCustomWaits.listNthElementHasText(
                        By.xpath("//*[@id=\"index\"]/div[2]/ul/li"),
                        4,
                        "Dress")
                );

    }

    @Test
    public void verifyHeaderAndUrl() {

        driver.findElement(By.id("contact-link")).click();

        WebElement hhh = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='page-heading bottom-indent']")));

        Boolean myTitle = (new WebDriverWait(driver, 10))
                .until(MyCustomWaits.pageIsLoaded("contact","CONTACT US"));
    }



    @Test
    public void verifyElementNoMorePresent() {

        driver.findElement(By.id("contact-link")).click();
        //Thread.sleep(500);
        LandingPage landingPage = new LandingPage(driver);

        landingPage.aaa();

    }

    class LandingPage {

        //@FindBy(id = "editorial_block_center")
        //@FindBy(id = "block_top_menu")
        //@FindBy(id = "search_block_top")
        @FindBy(id = "facebook_block")
        //@FindBy(id = "search_query_top")

        private WebElement eee;

        public LandingPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        void aaa()

        {
            new WebDriverWait(driver, 10)
                    .until(MyCustomWaits.stalenessOfElement(eee));
        }
    }

}
