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
    private By bunCard = By.xpath(".//img[@alt='Краторная булка N-200i']");
    private By bunIngredientDetailsPopUp = By.xpath(".//p[@class='text text_type_main-medium mb-8' and text()='Краторная булка N-200i']");
    private By sauceCard = By.xpath(".//img[@alt='Соус с шипами Антарианского плоскоходца']");
    private By sauceIngredientDetailsPopUp = By.xpath(".//p[@class='text text_type_main-medium mb-8' and text()='Соус с шипами Антарианского плоскоходца']");
    private By mainCard = By.xpath(".//img[@alt='Филе Люминесцентного тетраодонтимформа']");
    private By mainIngredientDetailsPopUp = By.xpath(".//p[@class='text text_type_main-medium mb-8' and text()='Филе Люминесцентного тетраодонтимформа']");

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

    public void clickBunButton() {
        driver.findElement(bunButton).click();
    }

    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    public void clickMainButton() {
        driver.findElement(mainButton).click();
    }

    public void clickBunCard() {
        driver.findElement(bunCard).click();
    }

    public void clickSauceCard() {
        driver.findElement(sauceCard).click();
    }

    public void clickMainCard() {
        driver.findElement(mainCard).click();
    }

    public boolean checkBunButtonEnabled() {
        return driver.findElement(bunButton).isEnabled();
    }

    public boolean checkBunPopUpEnabled() {
        return driver.findElement(bunIngredientDetailsPopUp).isEnabled();
    }

    public boolean checkSaucePopUpEnabled() {
        return driver.findElement(sauceIngredientDetailsPopUp).isEnabled();
    }

    public boolean checkMainPopUpEnabled() {
        return driver.findElement(mainIngredientDetailsPopUp).isEnabled();
    }
}
