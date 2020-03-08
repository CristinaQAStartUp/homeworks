package homeworks.homeworkTS;

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
//        driver.findElement(By.className("login")).click();
//        driver.findElement(By.id("email")).clear();
//        driver.findElement(By.id("email")).sendKeys("khbereg@gmail.com");
//        driver.findElement(By.id("passwd")).clear();
//        driver.findElement(By.id("passwd")).sendKeys("12345");
//        driver.findElement(By.id("SubmitLogin")).click();
    }

    @After
    public void tearDown() {
        //driver.findElement(By.className("logout")).click();
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Test(timeout = 5000l)
    public void verifyFirstTipIsCorrect_viaAssertTrue() {
        driver.findElement(By.id("search_query_top"))
                .clear();
        driver.findElement(By.id("search_query_top"))
                .sendKeys("Dress");

        Assert.assertTrue("First tip text was wrong",
                driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"))
                        .getText().contains("Dress"));
    }

}

