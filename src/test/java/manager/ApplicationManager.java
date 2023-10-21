package manager;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    EventFiringWebDriver driver;

    @Getter
    UserHelper userHelper;

  //  WebDriver driver;

    public void init() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        logger.info("open page: https://ilcarro.web.app/search");
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.register(new WDListener());

        userHelper = new UserHelper(driver);
        logger.info("navigated to the url: https://ilcarro.web.app/search");
    }


    public UserHelper getUserHelper() {
        return userHelper;
    }

    public void tearDown() {
        driver.quit();
    }

    public void navigateToMainPage() {
        driver.navigate().to("https://ilcarro.web.app/search");
    }

}
