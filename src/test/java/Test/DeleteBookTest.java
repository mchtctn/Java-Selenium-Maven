package Test;

import dataProvider.BookDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BookPage;

public class DeleteBookTest {
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

    @Test(testName = "Delete Book")
    public void deleteBook() throws InterruptedException {
        bookPage.clickAddButton();
        bookPage.createBookWithDefaultValues();
        Thread.sleep(2000);
        bookPage.selectBookByISBN(bookPage.ISBN);
        bookPage.clickDeleteButton();
        Thread.sleep(1000);
        Assert.assertTrue(bookPage.addBookButton.isDisplayed());
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
