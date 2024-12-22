import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class MainClass {

    @Test
    public void HabrTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Work\\4 Course\\Тестирование ПО\\Selenium\\seleniumlab\\drivers\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 960));;
        // Начало теста
        driver.get("https://habr.com/ru/articles/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.xpath(
                "//*[@class='tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_search tm-header-user-menu__icon_dark']"
        )).click();

        Assert.assertEquals(driver.findElement(
                By.xpath("//*[@class='tm-search__input tm-input-text-decorated__input']")),
                driver.switchTo().activeElement()
        );

        driver.findElement(
                By.xpath("//*[@class='tm-search__input tm-input-text-decorated__input']")
        ).sendKeys("Selenium WebDriver");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.xpath("//*[@class='tm-svg-img tm-svg-icon']")).click();
        driver.findElement(By.linkText("Что такое Selenium?")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Assert.assertEquals(
                driver.findElement(By.xpath("//*[@title='2012-09-28, 16:14']")).getText(),
                "28 сен 2012 в 16:14"
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(
                By.xpath("//a[@href='/ru/articles/' and @class='footer-menu__item-link']")).click();
        // Конец теста
        driver.quit();
    }

    @Test
    public void YandexMailTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Work\\4 Course\\Тестирование ПО\\Selenium\\seleniumlab\\drivers\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 960));;
        // Начало теста
        driver.get("https://360.yandex.ru/mail/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.xpath(
                "//*[@class='Button2 Button2_type_link Button2_view_default Button2_size_m']"
        )).click();

        driver.findElement(
                By.xpath("//input[@id='passp-field-login']")
        ).sendKeys("testoviytestitch");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath(
                "//*[@class='Button2 Button2_size_xxl Button2_view_contrast-action Button2_width_max Button2_type_submit']"
        )).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(
                By.xpath("//input[@id='passp-field-passwd']")
        ).sendKeys("toptester123");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath(
                "//*[@class='Button2 Button2_size_xxl Button2_view_contrast-action Button2_width_max Button2_type_submit']"
        )).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath(
                "//*[@class='UserID-name']"
        )).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.switchTo().frame(0);

        Assert.assertEquals(
                driver.findElement(
                        By.xpath("//span[@class='Text Text_typography_primary UserId-FirstLine']")).getText(),
                "Тестовый Тестич"
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(
                By.xpath("//div[@class='ListItem MenuItem Logout MenuItem_with-icon MenuItem_show-logout-page']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(
                By.xpath("//*[@data-testid='logout']")).click();
        driver.switchTo().defaultContent();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        if (
            !driver.findElement(
                    By.xpath(
                            "//*[@class='Button2 Button2_type_link Button2_view_default Button2_size_m']")
            ).isDisplayed()
        ) { throw new AssertionError("Элемент найден, но не отображается."); }
        // Конец теста
        driver.quit();
    }
}
