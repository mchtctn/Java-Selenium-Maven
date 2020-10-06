package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends PageObject {

    public final String ISBN = "9999999999999";
    public final String TITLE = "Title";
    private final String AUTHOR = "Author";
    private final String DESCRIPTION = "Description";
    private final String PUBLISHED_DATE = "2020";
    private final String PUBLISHER = "Publisher";

    // ELEMENTS
    /****************
     * Page Elements
     ****************/
    @FindBy(css=".panel-title")
    public WebElement panelTitle;

    @FindBy(css="tr > th:nth-child(1)")
    public WebElement isbnTableTitle;

    @FindBy(css="tr > th:nth-child(2)")
    public WebElement titleTableTitle;

    @FindBy(css="tr > th:nth-child(3)")
    public WebElement authorTableTitle;

    @FindBy(css="tbody > tr:last-child > td:nth-child(1)")
    public WebElement lastCreatedBookISBN;

    @FindBy(css="tbody > tr:last-child > td:nth-child(2)")
    public WebElement lastCreatedBookTitle;

    @FindBy(css="tbody > tr:last-child > td:nth-child(3)")
    public WebElement lastCreatedBookAuthor;

    /*****************
     * Create Elements
     *****************/
    @FindBy(css="a[href=\"/create\"]")
    public WebElement addBookButton;

    @FindBy(css="input[name='isbn']")
    private WebElement isbnField;

    @FindBy(css="label[for='isbn']")
    public WebElement isbnLabel;

    @FindBy(css="input[name='title']")
    private WebElement titleField;

    @FindBy(css="label[for='title']")
    public WebElement titleLabel;

    @FindBy(css="input[name='author']")
    private WebElement authorField;

    @FindBy(css="label[for='author']")
    public WebElement authorLabel;

    @FindBy(css="textarea[name='description']")
    private WebElement descriptionArea;

    @FindBy(css="input[name='description']")
    private WebElement descriptionField;

    @FindBy(css="label[for='description']")
    public WebElement descriptionLabel;

    @FindBy(css="input[name='published_year']")
    private WebElement publishedDateField;

    @FindBy(css="label[for='published_date']")
    public WebElement publishedDateLabel;

    @FindBy(css="input[name='publisher']")
    private WebElement publisherField;

    @FindBy(css="label[for='publisher']")
    public WebElement publisherLabel;

    @FindBy(css="button[type='submit']")
    private WebElement submitButton;

    /***************
     * Edit Elements
     ***************/
    @FindBy(css="a[href=\"/\"]")
    public WebElement bookListButton;

    @FindBy(css=".btn-success")
    private WebElement editButton;

    @FindBy(css="h4 a")
    public WebElement editPageBookListButton;

    @FindBy(css="dl > dd:nth-child(2)")
    public WebElement isbnValue;

    @FindBy(css="dl > dd:nth-child(4)")
    public WebElement authorValue;

    @FindBy(css="dl > dd:nth-child(6)")
    public WebElement descriptionValue;

    @FindBy(css="dl > dd:nth-child(8)")
    public WebElement publishDateValue;

    @FindBy(css="dl > dd:nth-child(10)")
    public WebElement publisherValue;

    /*****************
     * Delete Elements
     *****************/

    @FindBy(css=".btn-danger")
    private WebElement deleteButton;


    // METHODS

    /**
     * Constructor
     * @param driver
     */
    public BookPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter the book's isbn code in the isbn field
     * @param isbn
     */
    public void enterISBNCode(String isbn){
        this.isbnField.clear();
        this.isbnField.sendKeys(isbn);
    }

    /**
     * Enter the book's title to the title field
     * @param title
     */
    public void enterTitle(String title){
        this.titleField.clear();
        this.titleField.sendKeys(title);
    }

    /**
     * Enter the book's author to the author field
     * @param author
     */
    public void enterAuthor(String author){
        this.authorField.clear();
        this.authorField.sendKeys(author);
    }

    /**
     * Enter the book's description to the description area
     * @param description
     */
    public void enterDescription(String description){
        this.descriptionArea.clear();
        this.descriptionArea.sendKeys(description);
    }

    /**
     * Enter the book's description to the description field
     * @param description
     */
    public void enterDescriptionField(String description){
        this.descriptionField.clear();
        this.descriptionField.sendKeys(description);
    }

    /**
     * Enter the book's published date to the published date field
     * @param publishedDate
     */
    public void enterPublishedDate(String publishedDate){
        this.publishedDateField.clear();
        this.publishedDateField.sendKeys(publishedDate);
    }

    /**
     * Enter the book's publisher to the publisher field
     * @param publisher
     */
    public void enterPublisher(String publisher){
        this.publisherField.clear();
        this.publisherField.sendKeys(publisher);
    }

    /**
     * Click add book button
     */
    public void clickAddButton(){
        this.addBookButton.click();
    }

    /**
     * Click submit button
     */
    public void clickSubmitButton(){
        this.submitButton.click();
    }

    /**
     * Click edit button
     */
    public void clickEditButton(){
        this.editButton.click();
    }

    /**
     * Click delete button
     */
    public void clickDeleteButton(){
        this.deleteButton.click();
    }

    /**
     * Click Book List button
     */
    public void clickBookListButton(){
        this.bookListButton.click();
    }

    /**
     * Select the book from the isbn code of the book
     * @param isbn
     */
    public void selectBookByISBN(String isbn){
        HelperPage helpers = new HelperPage(driver);
        WebElement selectedBook = helpers.getElementByContent(isbn);
        selectedBook.click();
    }

    /**
     * Create a book with default values
     */
    public void createBookWithDefaultValues(){
        this.setDefaultParameters();
        this.clickSubmitButton();
    }

    /**
     * Set default values to the create book fields
     */
    private void setDefaultParameters() {
        this.enterISBNCode(ISBN);
        this.enterTitle(TITLE);
        this.enterAuthor(AUTHOR);
        this.enterDescription(DESCRIPTION);
        this.enterPublishedDate(PUBLISHED_DATE);
        this.enterPublisher(PUBLISHER);
    }
}
