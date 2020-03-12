package homeworks.homeworkTS;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Cristina on 02.03.2020.
 */
public class SearchTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }


    @Test
    public void quantityOfTips() {
        driver.findElement(By.id("search_query_top"))
                .clear();
        driver.findElement(By.id("search_query_top"))
                .sendKeys("Printed Summer Dress");

        int isPresent = driver.findElements(By.xpath("//*[@id=\"index\"]/div[2]/ul/li")).size();

        Assert.assertTrue(isPresent == 3);

    }

    @Test(timeout = 5000l)
    public void verifyFirstTipIsCorrect() {
        driver.findElement(By.id("search_query_top"))
                .clear();
        driver.findElement(By.id("search_query_top"))
                .sendKeys("Printed Summer Dress");

        Assert.assertThat(
                driver
                        .findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"))
                        .getText(),
                CoreMatchers.containsString("Printed Summer Dress"));
    }
}