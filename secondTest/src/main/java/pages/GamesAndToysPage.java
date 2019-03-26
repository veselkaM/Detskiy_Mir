package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GamesAndToysPage extends HalperBase {

    public GamesAndToysPage(WebDriver driver) {
        super(driver);
    }

    public void checkHeadlineName(String expectedText) {
        checkFieldText(By.xpath(".//*[@class = '_3aRMQza']"), expectedText);
    }

    public void selectItem(String itemName) {
        click(By.xpath(".//*[@class = 'DfS2mF1']/span[text() = '" + itemName + "']"));
    }


}

