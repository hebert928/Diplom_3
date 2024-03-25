package stellarBurgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site";
    private By profileButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    private By signInButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private By bunButton = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");
    private By sauceButton = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");
    private By mainButton = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");
    private By activeConstructorTab = By.className("tab_tab_type_current__2BEPc");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void getPage() {
        driver.get(URL);
    }

    public void clickProfileButton() {
        driver.findElement(profileButton).click();
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    public void clickMainButton() {
        driver.findElement(mainButton).click();
    }

    public boolean checkBunButtonEnabled() {
        return driver.findElement(bunButton).isEnabled();
    }

    public boolean checkConstructorTabIsActive(String constructorTabName) {
        return driver.findElement(activeConstructorTab).getText().toString().equals(constructorTabName);
    }
}
