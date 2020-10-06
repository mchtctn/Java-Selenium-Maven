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

public class CreateBookTest {
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

    @Test(testName = "Create Book", dataProvider = "createBookSuccessData")
    public void createBook(String isbn, String title, String author,
                           String description, String publishedDate, String publisher) throws InterruptedException {

        bookPage.clickAddButton();
        Assert.assertEquals(bookPage.panelTitle.getText(), "ADD BOOK");
        Assert.assertEquals(bookPage.isbnLabel.getText(), "ISBN:");
        bookPage.enterISBNCode(isbn);
        Assert.assertEquals(bookPage.titleLabel.getText(), "Title:");
        bookPage.enterTitle(title);
        Assert.assertEquals(bookPage.authorLabel.getText(), "Author:");
        bookPage.enterAuthor(author);
        Assert.assertEquals(bookPage.descriptionLabel.getText(), "Description:");
        bookPage.enterDescription(description);
        Assert.assertEquals(bookPage.publishedDateLabel.getText(), "Published Date:");
        bookPage.enterPublishedDate(publishedDate);
        Assert.assertEquals(bookPage.publisherLabel.getText(), "Publisher:");
        bookPage.enterPublisher(publisher);
        bookPage.clickSubmitButton();
        Thread.sleep(1000);
        Assert.assertEquals(bookPage.panelTitle.getText(), "BOOK CATALOG");
        Assert.assertEquals(bookPage.lastCreatedBookISBN.getText(), isbn);
        Assert.assertEquals(bookPage.lastCreatedBookTitle.getText(), title);
        Assert.assertEquals(bookPage.lastCreatedBookAuthor.getText(), author);
    }

    @Test(testName = "Unsuccessful Create Book", dataProvider = "createBookIncorrectData")
    public void UnsuccessfullyCreateBook(String isbn, String title, String author,
                                         String description, String publishedDate, String publisher) throws InterruptedException {

        bookPage.clickAddButton();
        Assert.assertEquals(bookPage.panelTitle.getText(), "ADD BOOK");

        bookPage.enterISBNCode(isbn);
        bookPage.enterTitle(title);
        bookPage.enterAuthor(author);
        bookPage.enterDescription(description);
        bookPage.enterPublishedDate(publishedDate);
        bookPage.enterPublisher(publisher);
        bookPage.clickSubmitButton();

        // Published Date must be year (integer)
        Thread.sleep(1000);
        Assert.assertEquals(bookPage.panelTitle.getText(), "ADD BOOK");
        Assert.assertEquals(bookPage.isbnLabel.getText(), "ISBN:");
        Assert.assertEquals(bookPage.titleLabel.getText(), "Title:");
        Assert.assertEquals(bookPage.authorLabel.getText(), "Author:");
        Assert.assertEquals(bookPage.descriptionLabel.getText(), "Description:");
        Assert.assertEquals(bookPage.publishedDateLabel.getText(), "Published Date:");
        Assert.assertEquals(bookPage.publisherLabel.getText(), "Publisher:");

        // click Book List button for return Book List
        bookPage.clickBookListButton();

    }

    @AfterTest
    public void afterTest(){
        driver.close();
    }

    @DataProvider
    public Object[][] createBookSuccessData(){
        return BookDataProvider.createBookSuccessData();
    }
    @DataProvider
    public Object[][] createBookIncorrectData(){
        return BookDataProvider.createBookIncorrectData();
    }

}
