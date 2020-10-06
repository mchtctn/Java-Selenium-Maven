package Test;

import dataProvider.BookDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BookPage;

public class EditBookTest {
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
    @Test(testName = "Edit Book", dataProvider = "editBookSuccessData", priority = 1)
    public void editBook(String isbn, String title, String author,
                         String description, String publishedDate, String publisher) throws InterruptedException {
        bookPage.clickAddButton();
        bookPage.createBookWithDefaultValues();
        Thread.sleep(2000);

        bookPage.selectBookByISBN(bookPage.ISBN);
        Assert.assertEquals(bookPage.panelTitle.getText(), bookPage.TITLE);
        Assert.assertEquals(bookPage.bookListButton.getText(), "Book List");

        bookPage.clickEditButton();
        bookPage.enterISBNCode(isbn);
        bookPage.enterTitle(title);
        bookPage.enterAuthor(author);
        bookPage.enterDescriptionField(description);
        bookPage.enterPublishedDate(publishedDate);
        bookPage.enterPublisher(publisher);
        bookPage.clickSubmitButton();
        Thread.sleep(2000);

        Assert.assertEquals(bookPage.panelTitle.getText(), title);
        Assert.assertEquals(bookPage.isbnValue.getText(), isbn);
        Assert.assertEquals(bookPage.authorValue.getText(), author);
        Assert.assertEquals(bookPage.descriptionValue.getText(), description);
        Assert.assertEquals(bookPage.publishDateValue.getText(), publishedDate);
        Assert.assertEquals(bookPage.publisherValue.getText(), publisher);

        //delete book
        bookPage.clickDeleteButton();
    }

    // This case return error because when user click 'Book List' button return edit page.
    @Test(testName = "Edit Book Page Return Book List Page", priority = 2)
    public void editBookPageReturnBookListPage() throws InterruptedException {
        bookPage.clickAddButton();
        bookPage.createBookWithDefaultValues();
        Thread.sleep(2000);

        bookPage.selectBookByISBN(bookPage.ISBN);
        Assert.assertEquals(bookPage.panelTitle.getText(), bookPage.TITLE);
        Assert.assertEquals(bookPage.bookListButton.getText(), "Book List");
        bookPage.clickEditButton();

        Assert.assertEquals(bookPage.bookListButton.getText(), "Book List");

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

    @DataProvider
    public Object[][] editBookSuccessData() {
        return BookDataProvider.editBookSuccessData();
    }

}
