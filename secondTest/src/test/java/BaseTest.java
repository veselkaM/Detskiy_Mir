import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.GamesAndToysPage;
import pages.GamesSelectionPage;
import pages.NavigationHelper;
import pages.OrderRegistrationPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected NavigationHelper navigation;
    protected GamesAndToysPage iggryIgrushki;
    protected GamesSelectionPage selection;
    protected OrderRegistrationPage orderRegistration;

    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();


    @Before
    public void setUp() {
        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get(baseUrl);


        navigation = new NavigationHelper(driver);
        iggryIgrushki = new GamesAndToysPage(driver);
        selection = new GamesSelectionPage(driver);
        orderRegistration = new OrderRegistrationPage(driver);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
