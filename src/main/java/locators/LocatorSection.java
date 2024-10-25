package locators;

import org.openqa.selenium.By;

public class LocatorSection {
    public static final By QUESTIONS_HEADER = By.xpath("//div[contains(text(), 'Вопросы о важном')]");

    public static final By[] DROPDOWNS = {
            By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7"),
    };

    public static final By[] DROPDOWN_TEXTS = {
            By.xpath("//div[@id='accordion__panel-0']/p"),
            By.xpath("//div[@id='accordion__panel-1']/p"),
            By.xpath("//div[@id='accordion__panel-2']/p"),
            By.xpath("//div[@id='accordion__panel-3']/p"),
            By.xpath("//div[@id='accordion__panel-4']/p"),
            By.xpath("//div[@id='accordion__panel-5']/p"),
            By.xpath("//div[@id='accordion__panel-6']/p"),
            By.xpath("//div[@id='accordion__panel-7']/p"),
    };
}
