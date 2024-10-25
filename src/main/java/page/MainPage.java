package page;
import locators.LocatorSection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для прокрутки до секции вопросов
    public void scrollToQuestionsSection() {
        WebElement questionsSection = driver.findElement(LocatorSection.QUESTIONS_HEADER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionsSection);
    }

    // Метод для клика по дропдауну вопроса
    public void clickDropdown(int index) {
        if (index >= 0 && index < LocatorSection.DROPDOWNS.length) { // Проверка на корректность индекса
            driver.findElement(LocatorSection.DROPDOWNS[index]).click();
        }
    }

    // Метод для получения текста ответа
    public String getDropdownText(int index, String expectedAnswerText) {
        if (index >= 0 && index < LocatorSection.DROPDOWN_TEXTS.length) { // Проверка на корректность индекса
            WebElement elementText = driver.findElement(LocatorSection.DROPDOWN_TEXTS[index]);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.textToBePresentInElement(elementText, expectedAnswerText));
            return elementText.getText();
        }
        return null;
    }
}
