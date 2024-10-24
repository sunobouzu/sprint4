package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MainPage;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QuestionSectionTest {
    private WebDriver driver;
    private MainPage mainPage;
    private int questionIndex;

    public QuestionSectionTest(int questionIndex) {
        this.questionIndex = questionIndex;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}
        });
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tochka1142\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void testQuestionsSection() {
        mainPage.scrollToQuestionsSection();
        mainPage.clickDropdown(questionIndex);
        String answerText = mainPage.getDropdownText(questionIndex);
        Assert.assertNotNull("Ответ не найден для вопроса " + questionIndex, answerText);
    }

    @After
    public void tearDown() {
            driver.quit();
        }
    }

