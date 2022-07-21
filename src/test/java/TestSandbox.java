import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.page.factories.HomePage;
import amazon.page.factories.SearchPage;
import com.typesafe.config.Config;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSandbox {
    private static final Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static final WebDriver driver = DriverFactory.getDriver();

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

    @Tag("smokeTest")
    @DisplayName("This test is to search samsung television and check About this item for second highest priced TV.")

    @BeforeAll
    static void beforeAll(){
        driver.get(HOME_PAGE_URL);
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
    }

    //Test method to go the second highest samsung tv details page.
    @Test
    @Order(1)
    void NavigateToSecondHighestSamsungTv() {
        homePage.selectTelevisionFromHamburgerMenu();
        searchPage.searchSamsungTVAndSortByHighToLow();
        searchPage.clickSecondSearchResult();
    }

    //Test Method to assert About this item section of samsung TV.
    @Test
    @Order(2)
    void assertAboutThisItem(){
        assertEquals("About this item", searchPage.aboutThisItem.getText());
        System.out.println(searchPage.aboutThisItemSection.getText());
    }

    //method to run after all methods to quit the browser window.
    @AfterAll
    static void afterAll(){
        driver.quit();
    }
}
