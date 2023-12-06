package lecture17;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class PostTests extends TestBase {
    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        File postPicture = new File("src\\main\\resources\\upload\\image_upload.jpg");
        String caption = "Caption for image text";

        return new Object[][]{
                {"BlaBlaBlo@abv.bg", "111111A", "BlaBlaBlo", postPicture, caption}
        };
    }

    @Test(dataProvider = "getUsers")
    public void testCreatePost(String user, String password, String username, File file, String caption) {
        //Gets a driver instance from parent class (TestObject)
        WebDriver driver = super.getDriver();

        LoginPage loginPage = new LoginPage(driver);
        //Navigate directly to Login page
        loginPage.navigateTo();
        loginPage.login(user, password);


        Header header = new Header(driver);
        header.clickNewPost();

        PostPage postPage = new PostPage(driver);
        Assert.assertTrue(postPage.isUrlLoaded(), "The POST URL is not correct!");
        postPage.uploadPicture(file);
        Assert.assertTrue(postPage.isImageVisible(), "The image is not visible!");
        Assert.assertEquals(file.getName(), postPage.getImageName(), "The image name is incorrect!");
        postPage.populatePostCaption(caption);
        postPage.clickCreatePost();

        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        Assert.assertEquals(profilePage.getPostCount(), 1, "The number of Posts is incorrect!");
        profilePage.clickPost(0);

        PostModal postModal = new PostModal(driver);
        Assert.assertTrue(postModal.isImageVisible(), "The image is not visible!");
        Assert.assertEquals(postModal.getPostTitle(), caption);
        Assert.assertEquals(postModal.getPostUser(), username);
    }
}