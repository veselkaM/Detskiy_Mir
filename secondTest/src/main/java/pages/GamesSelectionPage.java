package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GamesSelectionPage extends HalperBase {
    public GamesSelectionPage(WebDriver driver) {
        super(driver);

    }

    public void checkHeadlineName(String expectedText) {
        checkFieldText(By.xpath(".//*[@class = '_3aRMQza']"), expectedText);
    }

    @FindBy(xpath = ".//*[@class = '_1rqTXk0']")
    public
    List<WebElement> products;

    public String getItemName(int element) {
        List<WebElement> items = products;
        String Name = items.get(element).getText();
        return Name;
    }

    public void addToCart (String name) {
        click(By.xpath(".//p[contains(.,'" + name + "')]/following::div[@class = '_2VjEA4r'][1]"));
    }







}
