import stellarBurgers.*;
import stellarBurgersAPI.*;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{
    public String accessToken;
    public HomePage objHomePage;
    public AccountPage objAccountPage;

    @Before
    @Override
    public void init() {
        super.init();
        RegisterRequest registerRequest = new RegisterRequest(email, password, name);
        Response response = userSignUpAPI(registerRequest);
        accessToken = response.as(RegisterResponse.class).getAccessToken();

        objHomePage = new HomePage(driver);
        objAccountPage = new AccountPage(driver);
    }

    @Test
    public void checkLoginBySignInButtonOnHomePage()  {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        objHomePage.getPage();
        objHomePage.clickSignInButton();
        userLogin(email, password);
        objHomePage.clickProfileButton();
        boolean actual = objAccountPage.checkLogoutButtonEnabled();

        assertTrue(actual);
    }

    @Test
    public void checkLoginByProfileButtonOnHomePage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        objHomePage.getPage();
        objHomePage.clickProfileButton();
        userLogin(email, password);
        objHomePage.clickProfileButton();
        boolean actual = objAccountPage.checkLogoutButtonEnabled();

        assertTrue(actual);
    }

    @Test
    public void checkLoginBySignInButtonOnRegisterPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LoginPage objLoginPage = new LoginPage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);

        objHomePage.getPage();
        objHomePage.clickSignInButton();
        objLoginPage.clickSignUpButton();
        objRegisterPage.clickSignInButton();
        userLogin(email, password);
        objHomePage.clickProfileButton();
        boolean actual = objAccountPage.checkLogoutButtonEnabled();

        assertTrue(actual);
    }

    @Test
    public void checkLoginBySignInButtonOnForgotPasswordPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LoginPage objLoginPage = new LoginPage(driver);
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);

        objHomePage.getPage();
        objHomePage.clickSignInButton();
        objLoginPage.clickForgotPasswordButton();
        objForgotPasswordPage.clickSignInButton();
        userLogin(email, password);
        objHomePage.clickProfileButton();
        boolean actual = objAccountPage.checkLogoutButtonEnabled();

        assertTrue(actual);
    }

    @After
    public void testFinish() {
        deleteUser(accessToken);
    }
}
