import models.ContactData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BuyToyTest extends BaseTest {


    @Test
    public void testTravelInsurance() throws Exception {
        //1. Перейти на страницу Игрушки и игры
        navigation.selectMenuItem("Игрушки и игры");
        // 2. Проверить наличие на странице заголовка – Игрушки и игры
        iggryIgrushki.checkHeadlineName("Детские игрушки и игры");
        // 3.Выбрать раздел игрушек "Игрушечное оружие"
        iggryIgrushki.selectItem("Вертолеты, самолеты, Космическая техника, катера, корабли");
        //проверяем, что перешли на желаемую страницу
        selection.checkHeadlineName("Вертолеты, самолеты, Космическая техника, катера, корабли");
        //выбираем игрушку
        String item = selection.getItemName(1);
        //добавляем игрушку в корзину
        selection.addToCart(item);
        //переходим в корзину
        orderRegistration.goToCart();
        //проверяем, что в корзине та самая игрущка
        orderRegistration.checkItemName(item);
        //выбираем способ доставки Забрать в магазе
        orderRegistration.chooseDelivery("Забрать");
        //выбираем первый встречный магаз
        orderRegistration.selectStore(0);
        //выбираем бесплатный вариант
        orderRegistration.choosePriceOfDelivery("Бесплатно");
        //идём дальше
        orderRegistration.runOn();
        //выбираем способ оплаты
        orderRegistration.payInStore();
        //переходим к заполнению кантактных данных
        orderRegistration.goToContacts();
        //заполняем
        orderRegistration.fillContactInfo(new ContactData("Имя", "9155634156", "qwwer@mail.ru",
                "коммент"), true);
        //проверяем, что контакты ввели правильно
        orderRegistration.checkContactForm("Имя", "+7 915 563-41-56", "qwwer@mail.ru", "коммент");
        //подтверждаем
        orderRegistration.confirm();
        //проверяем, что по всем трём пунктам оформления заказа проставилась галочка
        assertEquals(3, orderRegistration.checkMark.size());
    }


}
