import stellarBurgers.*;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest{

    @Test
    public void checkUserSignUpSuccess() {
        HomePage objHomePage = new HomePage(driver);
        AccountPage objAccountPage = new AccountPage(driver);

        userSignUp(name, email, password);
        userLogin(email, password);
        objHomePage.clickProfileButton();
        boolean actual = objAccountPage.checkLogoutButtonEnabled();

        assertTrue(actual);

        JavascriptExecutor js = ((JavascriptExecutor)driver);
        String accessToken = (String) js.executeScript("return window.localStorage.getItem('accessToken')");
        deleteUser(accessToken);
    }

    @Test
    public void checkUserSignUpWithIncorrectPasswordError() {
        RegisterPage objRegisterPage = new RegisterPage(driver);
        userSignUp(name, email, "hungr");
        boolean actual = objRegisterPage.checkIncorrectPasswordErrorTextEnabled();

        assertTrue(actual);
    }
}
