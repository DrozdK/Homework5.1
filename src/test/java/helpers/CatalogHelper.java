package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class CatalogHelper extends BasePage {

    public CatalogHelper(WebDriver driver) {
        super(driver);
    }

    //locators
    public static final By FEN_BUTTON = By.xpath("//span[text()='Фены']");
    public static final By CLOSE_LOCATE_WINDOW = By.xpath("//div[contains(@class,'popover')]//span[contains(@class, 'button')]");
    public static final String DYSON_TAG = "//span[@class='schema-tags__text' and text()='Dyson']";

    //methods
    public static void selectManufacture(String manufacture) {
        driver.findElement(By.xpath("//ul//span[text()='"+manufacture+"']")).click();
    }

    public static void ScrollPage() {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 250)");
    }

    public static List<String> getTags(){
        List <String> tags = new ArrayList<>();
        driver.findElements(xpath("//span[@class='schema-tags__text']"))
                .forEach((WebElement questionEl)-> tags.add(questionEl.getText()));
        return tags;
    }
}
