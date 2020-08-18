import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ClicktransTest {

    private WebDriver webDriver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "F:/Programy/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void testClicktransRegisterForm() {
        webDriver.navigate().to("https://dev-1.clicktrans.pl/register-test/courier");
        webDriver.findElement(By.id("user_register_company_name")).sendKeys("Jakaś Firma");
        webDriver.findElement(By.id("user_register_email")).sendKeys("email@gmail.com");
        webDriver.findElement(By.id("user_register_name")).sendKeys("Imię Nazwisko");
        webDriver.findElement(By.id("user_register_phone")).sendKeys("666666666");
        webDriver.findElement(By.id("user_register_plainPassword")).sendKeys("jakieś_hasło");
        webDriver.findElement(By.id("user_register_settings_agreementRegulations")).click();
        webDriver.findElement(By.id("user_register_settings_agreementPersonalData")).click();
        webDriver.findElement(By.id("user_register_submit")).click();

        String message = webDriver.findElement(By.xpath("//div[contains(@class, 'ui success message')]")).getText();
        System.out.println(message);
        assertTrue(message.contains("OK - some registration logic is mocked"));
    }

    @AfterMethod
    public void afterTest() {
        webDriver.close();
        webDriver.quit();
    }
}
