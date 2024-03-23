package StellarBurgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    private By logoStellar = By.className("AppHeader_header__logo__2D0X2");
    private By logoutButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getPage() {
        driver.get(URL);
    }

    public boolean checkLogoutButtonEnabled() {
        return driver.findElement(logoutButton).isEnabled();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickLogoStellar() {
        driver.findElement(logoStellar).click();
    }
}
