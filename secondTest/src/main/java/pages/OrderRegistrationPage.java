package pages;

import models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderRegistrationPage extends HalperBase {

    public OrderRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@class='_2P4-IOG QzcsDWN _12s6t6p']")
    WebElement goToCartButtom;

    @FindBy(xpath = ".//*[@class='_3qhIrLB _2Tx0waf _3gdejw3']")
    WebElement addedItem;

    @FindBy(xpath = ".//*[@class='_2kAHxCq' and text() = 'Продолжить']")
    WebElement runOnButtom;


    @FindBy(xpath = ".//div[@class='sKrTveh']")
    public
    List<WebElement> store;

    @FindBy(xpath = ".//*[@class='_2r_9cBU' and text() = 'При получении']")
    WebElement payInStore;

    @FindBy(xpath = ".//*[@class='_2kAHxCq' and text() = 'Перейти к контактам']")
    WebElement goToContacts;

    @FindBy(xpath = ".//*[@class='mKlIXOP' and text() = 'Имя заказчика *']/following-sibling::input[@class='_3E_1Q5k _3zvZywN' ]")
    WebElement name;

    @FindBy(xpath = ".//*[@class='_3blpEKD' and text() = 'Телефон для СМС-уведомлений *']/following-sibling::input[@class='_17rN26t' ]")
    WebElement phone;

    @FindBy(xpath = ".//*[@class='mKlIXOP' and text() = 'Адрес электронной почты *']/following-sibling::input[@class='_3E_1Q5k _3zvZywN' ]")
    WebElement email;

    @FindBy(xpath = ".//*[@class='_1XgjjyV' and text() = 'Комментарий к заказу']/following-sibling::*[@class='_3go3na4' ]")
    WebElement comment;

    @FindBy(xpath = ".//*[@class='_3IstczW']")
    WebElement subscribeToTheNews;


    @FindBy(xpath = ".//*[@class='_2kAHxCq' and text() = 'Подтвердить']")
    WebElement confirmButtom;



    public void goToCart() {
        isElementPresent(addedItem);
        click(goToCartButtom);
    }

    public void checkItemName(String expectedText) {
        checkFieldText(By.xpath(".//*[@class='_3XP4vFx']"), expectedText);
    }

    public void chooseDelivery(String delivery) {
        click(By.xpath(".//*[@class='_2r_9cBU' and contains(.,'" + delivery + "')]"));
    }

    public void selectStore(int element) {
        List<WebElement> items = store;
        click(items.get(element));
    }


    public void choosePriceOfDelivery(String price) {
        click(By.xpath(".//div[@class='_3ab30w9 _3D65anc' and text() = '" + price + "']"));
    }


    public void runOn() {
        click(runOnButtom);
    }

    public void payInStore() {
        click(payInStore);
    }

    public void goToContacts() {
        click(goToContacts);
    }


    public void fillContactInfo(ContactData contactData, boolean news) {
        type(name, contactData.getName());
        type(phone, contactData.getPhone());
        type(email, contactData.getEmail());
        type(comment, contactData.getComment());

        if (!news) {
            click(subscribeToTheNews);
        }
    }

    public void checkContactForm(String expectedName, String expectedPhone, String expectedEmail,
                                 String expectedComment) {
        checkFieldText(name, expectedName);
        checkFieldText(phone, expectedPhone);
        checkFieldText(email, expectedEmail);
        checkFieldText(comment, expectedComment);
    }

    public void confirm() {
        click(confirmButtom);
    }


}
