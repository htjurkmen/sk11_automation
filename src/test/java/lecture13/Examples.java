package lecture13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Examples {
    @Test
    public void testLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open iskillo page
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        //validate page title is matching the expected page
        String pageTitle = driver.getTitle();
        Assert.assertEquals("ISkillo", pageTitle);

        //Click on Login link
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        //Validate URL
        String expectedLoginPageUrl = "http://training.skillo-bg.com:4300/users/login";
        String actualLoginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualLoginPageUrl, expectedLoginPageUrl, "Login page URL is incorrect!");

        //Validate Sign in form is visible
        WebElement signInElement = driver.findElement(By.xpath("//p[text()='Sign in']"));
        Assert.assertTrue(signInElement.isDisplayed(), "The 'Sign in' form is not displayed!");

        //Enter valid email address
        //WebElement userNameField = driver.findElement(By.xpath("//*[@id=\"defaultLoginFormUsername\"]"));
        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys("BlaBlaBlo@abv.bg");

        //Enter valid password
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys("111111A");

        //Click on Remember me button
        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//*[@formcontrolname=\"rememberMe\"]"));
        rememberMeCheckbox.click();

        //Validate Remember me is checked
        Assert.assertTrue(rememberMeCheckbox.isSelected(), "The Remember me checkbox is not selected");

        //Check Sign in button is enabled
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(signInButton.isEnabled());

        //Click on Sign in button
        signInButton.click();

        //Check profile link is present
        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        Assert.assertTrue(profileLink.isDisplayed(), "The profile link is not displayed!");

        //Click on link Profile
        profileLink.click();

        //Validate username on profile page
        WebElement userNameProfilePage = driver.findElement(By.tagName("h2"));
        String actualUserName = userNameProfilePage.getText();
        String expectedUserName = "BlaBlaBlo";
        Assert.assertEquals(actualUserName, expectedUserName);

        //Validate current user URL
        String userUrl = driver.getCurrentUrl();
        String expectedUserUrl = "http://training.skillo-bg.com:4300/users/5049";
        Assert.assertEquals(userUrl, expectedUserUrl);

        driver.close();
    }
}