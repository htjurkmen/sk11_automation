package lecture14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Exercises {
    public static final String PASSWORD = "AA123456";
    private WebDriver driver;

    /**
     * Setup all browser drivers before the test suite execution
     * This setup will be executed only once for the whole test run
     */
    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    /**
     * Opens a new window in the browser before the execution of each test method
     * Example: If you have 2 methods: method1 & method2. The execution will be:
     * 1. setUpTest + method1
     * 2. setUpTest + method2
     */
    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();

        //Sets timeout to wait for a page to load completely. Works only with get() and navigate().to()
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        /*
        Sets timeout to wait for any element to appear in the DOM tree
        Example:
        If you execute findElement() the driver will be checking for the element to appear in the DOM tree for the duration of 5 seconds
        If element the element is found within the 5 seconds the test execution continues
        Otherwise if the element is not found NoSuchElementException will be thrown
        Important:
        If the element is presented in the DOM tree this doesn't guarantee that the element is visible on the page!
        The implicit wait applies for all elements during the driver's lifecycle
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    /**
     * After each test closes the current browser window
     * Example: If you have 2 methods: method1 & method2. The execution will be:
     * 1. setUpTest + method1 + tearDownTest
     * 2. setUpTest + method2 + tearDownTest
     */
    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{
                { "BlaBlaBlo@abv.bg","111111A","BlaBlaBlo" }, //login with username
        };
    }

    //invocationCount add value how much time a test should be executed
    //@Test(invocationCount = 3, dataProvider = "getUsers")
    @Test(dataProvider = "getUsers")
    public void testLoginWithWaits(String user, String password, String name) {
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        /*
        Replaces
        String expectedLoginPageUrl = "http://training.skillo-bg.com:4300/users/login";
        String actualLoginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualLoginPageUrl, expectedLoginPageUrl, "Login page URL is incorrect!");
        */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));

        /*
        Replaces
        Assert.assertTrue(signinelement.isdisplayed(), "the 'sign in' text is not displayed!");
         */
        WebElement signInElement = driver.findElement(By.xpath("//*[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInElement));

        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys(user);

        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys(password);

        /*
        Replaces
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(signInButton.isEnabled(), "The Sign In button is disabled!");
        signInButton.click();
        */
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();

        /*
        Replaces
        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        Assert.assertTrue(profileLink.isDisplayed(), "The profile link is not displayed!");
        */
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();

        /*
        Replaces
        String actualProfilePageUrl = driver.getCurrentUrl();
        String expectedProfilePage = "http://training.skillo-bg.com:4300/users/3905";
        Assert.assertEquals(actualProfilePageUrl, expectedProfilePage, "The profile page url is incorrect!");
         */
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/"));

        /*
        Replaces
        WebElement userNameElement = driver.findElement(By.tagName("h2"));
        String actualUserName = userNameElement.getText();
        String expectedUserName = "BlaBlaBlo";
        Assert.assertEquals(actualUserName, expectedUserName, "The user name is incorrect!");
         */
        Boolean isTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), name));
        Assert.assertTrue(isTextDisplayed, "The username is not displayed!");
    }


    @Test
    public void testRegistration() {
        //Load Skillo website
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        //Click Login link
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        //Validate page loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));

        //Validate Sign in is visible
        WebElement signInElement = driver.findElement(By.xpath("//*[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInElement));

        //Click on Register link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        //Validate web page url is changed
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/register"));

        //Validate Sign up is visible
        WebElement signUpElement = driver.findElement(By.xpath("//*[text()='Sign up']"));
        wait.until(ExpectedConditions.visibilityOf(signUpElement));

        //Enter username
        WebElement userNameField = driver.findElement(By.name("username"));
        String username = generateRandomAlphabeticString(5, 8);
        userNameField.sendKeys(username);

        //Enter email
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        String email = generateRandomEmail(5, 10);
        emailField.sendKeys(email);

        //Add birthDay
        WebElement birthDateElement = driver.findElement(By.cssSelector("[formcontrolname='birthDate']"));
        birthDateElement.sendKeys("11112022");

        //Add password
        WebElement passwordField = driver.findElement(By.id("defaultRegisterFormPassword"));
        passwordField.sendKeys(PASSWORD);

        //Confirm Password
        WebElement confirmPasswordField = driver.findElement(By.id("defaultRegisterPhonePassword"));
        confirmPasswordField.sendKeys(PASSWORD);

        //Add public Info
        WebElement infoField = driver.findElement(By.name("pulic-info"));
        String info = generateRandomAlphabeticString(10, 15);
        infoField.sendKeys(info);

        //Click sign-in button
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();

        //Wait for page reload http://training.skillo-bg.com:4300/posts/all
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));

        //Click on profile
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();

        // Validate user profile link
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/"));

        // Validate username
        Boolean isTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), username));
        Assert.assertTrue(isTextDisplayed, "The username is not displayed!");
    }

    private String generateRandomEmail(int minLengthInclusive, int maxLengthInclusive) {
        return generateRandomAlphabeticString(minLengthInclusive, maxLengthInclusive) + "@gmail.com";
    }

    private String generateRandomAlphabeticString(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }

}