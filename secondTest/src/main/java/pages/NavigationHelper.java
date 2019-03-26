package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HalperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void selectMenuItem(String itemName){
        click(By.xpath(".//*[@class = '_2Emd3Nz' and text() = '"+itemName+"']"));

    }
}
