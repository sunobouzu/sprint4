package locators;

import org.openqa.selenium.By;

public class Locators {
    public static final By ORDER_BUTTON = By.xpath("//button[@class = 'Button_Button__ra12g']"); // Кнопка "Заказать"

    public static final By FIRST_NAME_INPUT = By.xpath("//input[@placeholder='* Имя']");
    public static final By LAST_NAME_INPUT = By.xpath("//input[@placeholder='* Фамилия']");
    public static final By ADDRESS_INPUT = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    public static final By PHONE_INPUT = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    public static final By METRO_STATION_INPUT = By.xpath("//input[@placeholder='* Станция метро']"); // Поле станции метро
    public static final By DALEE = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    public static final By DATE_INPUT = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    public static final By RENTAL_PERIOD_DROPDOWN = By.xpath("//div[contains(text(), '* Срок аренды')]");
    public static final By THREE_DAYS_OPTION = By.xpath("//div[contains(text(), 'трое суток')]");
    public static final By COLOR_OPTION_GREY = By.xpath("//label[@for='grey']");

    public static final By CONFIRM_BUTTON = By.xpath("//button[contains(text(), 'Да')]");
    public static final By MODAL_WINDOW = By.xpath("//div[contains(@class, 'Order_Modal__YZ-d3')]");

    public static final By METRO_OPTION = By.className("select-search__select");

    public static final By MODAL_WINDOW_SUCCESS = By.xpath("//div[contains(@class, 'Order_ModalHeader__3FDaJ') and text()=\"Заказ оформлен\"]");


}
