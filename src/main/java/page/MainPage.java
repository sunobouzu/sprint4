package page;
import locators.Locators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для прокрутки до секции вопросов
    public void scrollToQuestionsSection() {
        WebElement questionsSection = driver.findElement(Locators.QUESTIONS_HEADER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionsSection);
    }

    // Метод для клика по дропдауну вопроса
    public void clickDropdown(int index) {
        if (index >= 0 && index < Locators.DROPDOWNS.length) { // Проверка на корректность индекса
            driver.findElement(Locators.DROPDOWNS[index]).click();
        }
    }

    // Метод для получения текста ответа
    public String getDropdownText(int index) {
        if (index >= 0 && index < Locators.DROPDOWN_TEXTS.length) { // Проверка на корректность индекса
            return driver.findElement(Locators.DROPDOWN_TEXTS[index]).getText();
        }
        return null;
    }

    // Метод для клика по кнопке "Заказать"
    public void clickOrderButton() {
        driver.findElement(Locators.ORDER_BUTTON).click();
    }
}
