package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HalperBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public HalperBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        isElementPresent(element);
        element.click();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }


    protected void type(WebElement element, String text) {
        if (text != null) {
            String existingTest = element.getAttribute("value");
            if (!text.equals(existingTest)) {
                element.clear();
                element.sendKeys(text);
            }
        }
    }

    protected void checkFieldText(WebElement element, String text) {
        String expectedText = element.getText();
        if (expectedText.equals("")) {
            expectedText = element.getAttribute("value");
        }
        Assert.assertEquals(expectedText, text);
    }

    protected void checkFieldText(By locator, String text) {
        String expectedText = driver.findElement(locator).getText();
        if (expectedText.equals("")) {
            expectedText = driver.findElement(locator).getAttribute("value");
        }
        Assert.assertEquals(expectedText, text);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }
}
