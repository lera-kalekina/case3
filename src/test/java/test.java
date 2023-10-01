

import mport java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RandomNumberTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;

    @Before
    public void setUp() throws Exception {
        baseUrl = "https://test-sheep.herokuapp.com/";
        driver = new FirefoxDriver();
    }

    @Test
    public void testRandomNumber() throws Exception {
        driver.get(baseUrl + "/random");
        driver.findElement(By.linkText("Random Number")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().refresh();
        WebElement element = driver.findElement(By.name("roll"));
        element.clear();
        element.sendKeys("string");
        element.submit();
        assertTrue("Error Message not displayed", driver.switchTo().alert().getText().
                        Продолжи
                matches(“string:.*Not a number!”));
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }