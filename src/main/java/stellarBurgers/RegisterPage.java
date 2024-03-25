package stellarBurgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site/register";
    private By nameField = By.xpath(".//form/fieldset[1]//input");
    private By emailField = By.xpath(".//form/fieldset[2]//input");
    private By passwordField = By.xpath(".//form/fieldset[3]//input");
    private By signUpButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By signInButton = By.className("Auth_link__1fOlj");
    private By incorrectPasswordErrorText = By.xpath(".//p[@class='input__error text_type_main-default']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getPage() {
        driver.get(URL);
    }

    public void fillNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public boolean checkIncorrectPasswordErrorTextEnabled() {
        return driver.findElement(incorrectPasswordErrorText).isEnabled();
    }
}
