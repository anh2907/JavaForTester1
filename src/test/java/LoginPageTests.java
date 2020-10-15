import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class LoginPageTests {
    DriverManager driverManager;
    WebDriver driver;
    LoginPage loginPage;
    @Before
    public void setUp() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    }
    @Test
    public void loginTest(){
        loginPage = new LoginPage(driver);
        loginPage.login("buyer.nvg01@gmail.com","Nvg@2020");
        String loginSuccessMsg = loginPage.getLoginSuccessMsg();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertEquals(loginSuccessMsg, "Hello, Anh");
    }
    @After
    public void tearDown(){
        driverManager.quitWebDriver();
    }
}
