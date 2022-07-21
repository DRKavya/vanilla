package amazon.page.factories;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

//Created this class to store all the webelements and methods related to search results page.
public class SearchPage {

    final WebDriver driver;

    //created an object browser(as naming will be easy to read) for BrowserFunctions class to use those methods.
    BrowserFunctions browser;

    JavascriptExecutor js;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        browser = new BrowserFunctions(driver);
    }

    //locating webelement Samsung brand in the filters.
    @FindBy(xpath="//span[contains(@class,'a-size-base a-color-base') and contains(text(), 'Samsung')]")
    WebElement filterBrandSamsung;

    //locating webelement sort by Option.
    @FindBy(css="#a-autoid-0-announce")
    WebElement sortByOption;

    //locating webelement sort by high to low.
    @FindBy(xpath="//a[contains(text(),'Price: High to Low')]")
    WebElement sortByHighToLow;

    //locating list of webelement for all the search results.
    @FindBy(xpath="//*[@class='s-main-slot s-result-list s-search-results sg-row']/div")
    List<WebElement> searchResults;

    //locating webelement for about this item.
    @FindBy(css="div#feature-bullets h1")
    public WebElement aboutThisItem;

    //locating webelement for about this item section.
    @FindBy(css="#feature-bullets > ul")
    public WebElement aboutThisItemSection;

    //method to search samsung tv and sort by high to low.
    public void searchSamsungTVAndSortByHighToLow(){
        browser.scrollAndClick(filterBrandSamsung);
        browser.click(sortByOption);
        browser.click(sortByHighToLow);
    }

    //method to click on the second highest priced item(television) and switch to new tab to check about this item section.
    public void clickSecondSearchResult(){
        browser.click(searchResults.get(2));
        ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(1));
        browser.scrollToElement(aboutThisItem);
    }
}
