package amazon.page.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Created this class to store all the webelements and methods related to home page.
public class HomePage {

    final WebDriver driver;

    //created an object browser(as naming will be easy to read) for BrowserFunctions class to use those methods.
    BrowserFunctions browser;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        browser = new BrowserFunctions(driver);
    }

    //locating webelement hamburger menu.
    @FindBy(css="i[class='hm-icon nav-sprite']")
    WebElement hamburgerMenu;

    //locating webelement TV department.
    @FindBy(xpath="//div[contains(text(),'TV, Appliances, Electronics')]")
    WebElement departmentTvAppliancesElectronics;

    //locating webelement Television.
    @FindBy(xpath="//a[contains(text(),'Televisions')]")
    WebElement television;

    //method to select television category from the hamburger menu.
    public void selectTelevisionFromHamburgerMenu(){
        browser.click(hamburgerMenu);
        browser.scrollAndClick(departmentTvAppliancesElectronics);
        browser.click(television);
    }
}
