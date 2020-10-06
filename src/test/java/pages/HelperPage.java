package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PageObject;

public class HelperPage extends PageObject {

    public HelperPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getElementByContent (String content) {
        return driver.findElement(By.xpath("//*[text() = '"+ content+ "']"));
    }
}
