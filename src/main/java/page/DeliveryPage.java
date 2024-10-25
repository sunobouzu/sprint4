package page;

import locators.Locators;
import org.openqa.selenium.WebDriver;

public class DeliveryPage {
    private static WebDriver driver;

    public DeliveryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для клика по кнопке "Заказать"
    public static void clickOrderButton() {
        driver.findElement(Locators.ORDER_BUTTON).click();
    }

}
