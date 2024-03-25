package stellarBurgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private By signInButton = By.className("Auth_link__1fOlj");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getPage() {
        driver.get(URL);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
}
