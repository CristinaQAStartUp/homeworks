package homeworks.homeworkTS;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Cristina on 01.03.2020.
 */
public class AccountTest {
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
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("khbereg@gmail.com");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("12345");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @After
    public void tearDown() {
        driver.findElement(By.className("logout")).click();
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Test
    public void orderHistoryAndDetails() {
        driver.findElement(By.xpath("//a[@title='Orders']")).click();
    }

    @Test
    public void myCreditSlips() {
        driver.findElement(By.xpath("//a[@title='Credit slips']")).click();
    }

    @Test
    public void myAddresses() {
        driver.findElement(By.xpath("//a[@title='Addresses']")).click();
    }

    @Test
    public void myPersonalInformation() {
        driver.findElement(By.xpath("//a[@title='Information']")).click();
    }

    @Test
    public void myWishLists() {
        driver.findElement(By.xpath("//a[@title='My wishlists']")).click();
    }

}
