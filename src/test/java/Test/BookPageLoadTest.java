package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BookPage;

public class BookPageLoadTest {
    private WebDriver driver;
    BookPage bookPage;

    @BeforeTest
    public void beforeTest(){
        // ChromeDriver location set up in Test.Utils class
        System.setProperty("webdriver.chrome.driver", UtilsTest.CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.get(UtilsTest.BASE_URL);
        bookPage = new BookPage(driver);

    }
    @Test(testName = "Page Successfully Loaded")
    public void pageSuccessfullyLoaded(){
        Assert.assertEquals(bookPage.panelTitle.getText(), "BOOK CATALOG");
        Assert.assertEquals(bookPage.isbnTableTitle.getText(), "ISBN");
        Assert.assertEquals(bookPage.titleTableTitle.getText(), "Title");
        Assert.assertEquals(bookPage.authorTableTitle.getText(), "Author");
        Assert.assertTrue(bookPage.addBookButton.isDisplayed());
    }

    @AfterTest
    public void afterTest(){
        driver.close();
    }

}
