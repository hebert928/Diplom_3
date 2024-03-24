import stellarBurgers.*;
import stellarBurgersAPI.*;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class AccountTest extends BaseTest{
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
    public void checkGoToAccountPageByProfileButtonOnHomePage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        userLogin(email, password);
        objHomePage.clickProfileButton();
        boolean actual = objAccountPage.checkLogoutButtonEnabled();

        assertTrue(actual);
    }

    @Test
    public void checkGoToConstructorFromAccountPageByConstructorButton() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        userLogin(email, password);
        objHomePage.clickProfileButton();
        objAccountPage.clickConstructorButton();
        boolean actual = objHomePage.checkBunButtonEnabled();

        assertTrue(actual);
    }

    @Test
    public void checkGoToConstructorFromAccountPageByStellarLogo() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        userLogin(email, password);
        objHomePage.clickProfileButton();
        objAccountPage.clickLogoStellar();
        boolean actual = objHomePage.checkBunButtonEnabled();

        assertTrue(actual);
    }

    @Test
    public void checkLogoutFromAccount() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LoginPage objloginPage = new LoginPage(driver);

        userLogin(email, password);
        objHomePage.clickProfileButton();
        objAccountPage.clickLogoutButton();
        boolean actual = objloginPage.checkSignInButtonEnabled();

        assertTrue(actual);
    }

    @After
    public void testFinish() {
        deleteUser(accessToken);
    }
}
