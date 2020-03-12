import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Every;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by Cristina on 11.03.2020.
 */
public class Homework9 {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


    @Test(timeout = 5000l)
    public void verifyTipsAreCorrect1() {
        driver.findElement(By.id("search_query_top"))
                .clear();
        driver.findElement(By.id("search_query_top"))
                .sendKeys("Printed Summer Dress");


        List<String> tips = driver.findElements(By.xpath("//*[@id=\"index\"]/div[2]/ul/li")).stream()
                .map(t -> t.getText())
                .collect(Collectors.toList());

        //Assert.assertThat(tips, everyItem(containsString("Printed Summer Dress")));

        Assertions.assertThat(tips)
                .allMatch(t->t.contains("Printed Summer Dress"));

    }
}
