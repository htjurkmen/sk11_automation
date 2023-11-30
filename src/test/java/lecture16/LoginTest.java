package lecture16;

import io.github.bonigarcia.wdm.WebDriverManager;

//Uncomment to switch between page and object code
import lecture16.factory.Header;
import lecture16.factory.HomePage;
import lecture16.factory.LoginPage;
import lecture16.factory.ProfilePage;

/*import lecture16.object.Header;
import lecture16.object.HomePage;
import lecture16.object.LoginPage;
import lecture16.object.ProfilePage;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.time.Duration;

public class LoginTest {
    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{
                { "BlaBlaBlo@abv.bg","111111A","BlaBlaBlo" }, //login with username
        };
    }

    @Test(dataProvider = "getUsers")
    public void testLogin(String user, String password, String name) {

        // Home Page Class
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        homePage.isUrlLoaded();

        // Header Class
        Header headerMenu = new Header(driver);
        headerMenu.clickLogin();

        //Login Class
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isUrlLoaded();

        // Get Sign in text
        String elemText = loginPage.getSignInElementText();
        Assert.assertEquals(elemText, "Sign in");

        // Fill in username
        loginPage.populateUsername(user);

        //Fill in password
        loginPage.populatePassword(password);

        //Click on Sign in
        loginPage.clickSignIn();

        //Click on Profile
        headerMenu.clickProfile();

        //Create Profile Class
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.isUrlLoaded();

        //Get Logged in user text
        Assert.assertEquals(profilePage.getUsername(), name);
    }
}