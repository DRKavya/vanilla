package amazon.page.factories;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Browser functions class with click and scroll functions to be used in other classes.
// (To avoid multiple lines of code in other classes for waits and scroll functions).
public class BrowserFunctions {
    final WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public BrowserFunctions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

    //method to click on the webelement with explicitly wait.
    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //method to scroll to the webelement and click.
    public void scrollAndClick(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //method to scroll to the webelement.
    public void scrollToElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
