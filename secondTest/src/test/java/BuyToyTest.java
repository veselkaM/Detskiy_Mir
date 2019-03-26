import models.ContactData;
import org.junit.Test;

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
        //запоминаем выбираем игрушку
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
        orderRegistration.choosePriceOfDelivery("Бесплатно");
        orderRegistration.runOn();
        orderRegistration.payInStore();
        orderRegistration.goToContacts();
        orderRegistration.fillContactInfo(new ContactData("Имя", "9155634156", "qwwer@mail.ru",
                "коммент"), true);
        orderRegistration.checkContactForm("Имя", "+79155634156", "qwwer@mail.ru","коммент");
        orderRegistration.confirm();



        /*
        //6. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        insuranceSelection.chooseMinimalPackage();
        //7. Нажать Оформить
        insuranceSelection.clickCheckoutButton();

        //8.  На вкладке Оформить заполнить Фамилию и Имя, Дату рождения застрахованных
        ContactData insuredData = new ContactData("INSUREDSURNAME", "INSUREDNAME",  "22.07.1992",
                "ФАМИЛИЯ", "ИМЯ", "ОТЧЕСТВО", "22.07.1991", "4444", "444444",
                "20.06.2016", "ОВД ГОЛЬЯНОВО", null, null, null);
        insuranceRegistration.fillAddInsuranceForm(insuredData, true);

        //9. Проверить, что все поля заполнены правильно
        insuranceRegistration.checkInsuranceForm ("INSUREDSURNAME", "INSUREDNAME",  "22.07.1992",
                "ФАМИЛИЯ", "ИМЯ", "ОТЧЕСТВО", "22.07.1991", "4444", "444444",
                "20.06.2016", "ОВД ГОЛЬЯНОВО");

        //10. Нажать продолжить
        insuranceRegistration.conformInsuranceForm();
        //11. Проверить, что появилось сообщение - Заполнены не все обязательные поля
        insuranceRegistration.checkErrorMassage("Заполнены не все обязательные поля");
*/
    }



}
