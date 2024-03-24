import factory.Browser;
import stellarBurgers.*;
import stellarBurgersAPI.RegisterRequest;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import static io.restassured.RestAssured.given;

public class BaseTest {
    protected WebDriver driver;
    protected String name = "HungrySquirrel";
    protected String email = "hungry.squirrel@gmail.com";
    protected String password = "hungry1";

    @Before
    public void init() {
        driver = new Browser().getWebDriver("yandex");
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    }

    @Step
    public void userSignUp(String name, String email, String password) {
        HomePage objHomePage = new HomePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);

        objHomePage.getPage();
        objHomePage.clickSignInButton();
        objLoginPage.clickSignUpButton();
        objRegisterPage.fillNameField(name);
        objRegisterPage.fillEmailField(email);
        objRegisterPage.fillPasswordField(password);
        objRegisterPage.clickSignUpButton();
    }

    @Step
    public void userLogin(String email, String password) {
        LoginPage objLoginPage = new LoginPage(driver);

        objLoginPage.getPage();
        objLoginPage.fillEmailField(email);
        objLoginPage.fillPasswordField(password);
        objLoginPage.clickSignInButton();
    }

    @Step
    public Response userSignUpAPI(RegisterRequest registerRequest){
        Response response = given()
                .header("Content-type", "application/json")
                .body(registerRequest)
                .post("api/auth/register");

        return response;
    }

    @Step
    public void deleteUser(String accessToken) {
        given().header("Authorization", accessToken).delete("/api/auth/user");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
