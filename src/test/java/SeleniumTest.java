import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SeleniumTest {

    private static final Logger logger = LogManager.getLogger(SeleniumTest.class);
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        logger.info("Strona glowna");
        driver.get("https://www.zalando.pl/");
        String title = driver.getTitle();
        logger.info(title);
        WebElement element = driver.findElement(By.name("headerbanner.help.contact"));
        logger.info(element.getText());
        element.click();
        logger.info("Pomoc i kontakt");
        WebElement element2 = driver.findElement(By.xpath("//*[text()='Procedura zwrotu']"));
        logger.info(element2);
        element2.click();
        logger.info("Procedura zwrotu");
        WebElement element3 = driver.findElement(By.xpath("//*[text()='Zwracasz produkt Beauty?']"));
        logger.info("Produkt beauty");
        element3.click();
        logger.info(element3);


        driver.close();


    }
}
