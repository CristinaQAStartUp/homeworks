package homework10;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static homework10.Homework10.driver;

/**
 * Created by Cristina on 15.03.2020.
 */
public class MyCustomWaits {

    public static ExpectedCondition<WebElement> listNthElementHasText(By locator, int elNo, String expTextPart) {

        return new ExpectedCondition<WebElement>() {

            private String nthElementText = "";

            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver driver) {
                try {
                    WebElement element = driver.findElements(locator).get(elNo);
                    nthElementText = element.getText();

                    return nthElementText.contains(expTextPart) ? element : null;
                } catch (IndexOutOfBoundsException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return String.format("\n\n\n\n\n%dth element \nof list \nto have text: %s\n while actual text was: %s\n\n\n\n\n",
                        elNo, expTextPart, nthElementText);
            }
        };
    }


    public static ExpectedCondition<Boolean> pageIsLoaded(String expUrl, String expTitle) {
        return new ExpectedCondition<Boolean>() {

            private String title;
            private String url;

            @NullableDecl
            @Override
            public Boolean apply(WebDriver webDriver) {
                try {
                    WebElement element = driver.findElement(By.xpath("//h1[@class='page-heading bottom-indent']"));
                    title = element.getText();
                    url = driver.getCurrentUrl();

                    return title.contains(expTitle) && url.contains(expUrl);
                } catch (NoSuchElementException e) {
                    return false;
                }
            }

            @Override
            public String toString() {
                return String.format("Some values are not correct." +
                        "There should be \'' %s \' in the title. Was found: %s \n" +
                        "\n\n\nThere should be \'' %s \' in the url. Was found: %s", expUrl, url, expTitle, title);
            }

        };
    }


    public static ExpectedCondition<Boolean> stalenessOfElement(WebElement elToBeDisappeared) {
        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver webDriver) {

                try {
                    elToBeDisappeared.isDisplayed();
                    System.out.println("Element is present!");
                    return false;
                } catch (NoSuchElementException e) {
                    System.out.println(elToBeDisappeared);
                    System.out.println("No such element!");
                    return true;
                }

            }

            @Override
            public String toString() {
                return String.format("The element %s IS present", elToBeDisappeared);
            }
        };
    }

}
