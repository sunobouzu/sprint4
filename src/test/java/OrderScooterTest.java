package test;

import locators.Locators;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderScooterTest {
    private WebDriver driver;
    private MainPage mainPage;
    private static final String ORDER_URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tochka1142\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ORDER_URL);
        mainPage = new MainPage(driver);
    }

    @Test
    public void testFullOrderFlow() {
        mainPage.clickOrderButton(); // Клик по кнопке "Заказать"

        // Заполнение первой формы заказа
        fillOrderForm("Иван", "Иванов", "Москва, Какой-то адрес", "+79000000000");

        fillOrderDetails();

        // Проверка закрытия модального окна после подтверждения заказа
        assertModalClosedAfterConfirm();
    }

    private void fillOrderForm(String name, String surname, String address, String phone) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(Locators.ORDER_BUTTON)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FIRST_NAME_INPUT)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LAST_NAME_INPUT)).sendKeys(surname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ADDRESS_INPUT)).sendKeys(address);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.PHONE_INPUT)).sendKeys(phone);

        fillMetroStation("Павелецкая");

        wait.until(ExpectedConditions.elementToBeClickable(Locators.DALEE)).click();
    }

    private void fillMetroStation(String station) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Находим поле для ввода станции метро, кликаем на него
        WebElement metroStationInput = driver.findElement(Locators.METRO_STATION_INPUT);
        metroStationInput.click();
        metroStationInput.sendKeys(station);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.METRO_OPTION));

        // Находим и выбираем нужный элемент из выпадающего списка
        WebElement metroOption = driver.findElement(Locators.METRO_OPTION);
        metroOption.click(); // Кликаем на элемент выпадающего списка
    }

    private void fillOrderDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Ожидаем заголовка "Про аренду"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Order_Header__BZXOb')]")));

        // Заполнение поля "Когда привезти самокат" с текущей датой
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.DATE_INPUT)).sendKeys(currentDate + Keys.ENTER);

        // Выбор срока аренды
        wait.until(ExpectedConditions.elementToBeClickable(Locators.RENTAL_PERIOD_DROPDOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.THREE_DAYS_OPTION)).click();

        // Выбор цвета самоката
        wait.until(ExpectedConditions.elementToBeClickable(Locators.COLOR_OPTION_GREY)).click();

        // Клик по кнопке "Заказать"
        wait.until(ExpectedConditions.elementToBeClickable(Locators.DALEE)).click();

        // Ожидание появления модального окна
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.MODAL_WINDOW));

        // Клик по кнопке "Да"
        wait.until(ExpectedConditions.elementToBeClickable(Locators.CONFIRM_BUTTON)).click();
    }

    private void assertModalClosedAfterConfirm() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Ожидаем 10 секунд

        try {
            // Проверка, что модальное окно закрылось
            wait.until(ExpectedConditions.invisibilityOfElementLocated(Locators.MODAL_WINDOW));
        } catch (Exception e) {
            Assert.fail("Заказ не был завершен");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
