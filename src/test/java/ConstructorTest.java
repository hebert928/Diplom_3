import stellarBurgers.HomePage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.time.Duration;

public class ConstructorTest extends BaseTest{
    public HomePage objHomePage;

    @Before
    @Override
    public void init() {
        super.init();
        objHomePage = new HomePage(driver);
    }

    @Test
    public void checkConstructorTransitionBun() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        objHomePage.getPage();
        objHomePage.clickSauceButton();
        objHomePage.clickBunButton();
        objHomePage.clickBunCard();
        boolean actual = objHomePage.checkBunPopUpEnabled();

        assertTrue(actual);
    }

    @Test
    public void checkConstructorTransitionSauce() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        objHomePage.getPage();
        objHomePage.clickSauceButton();
        objHomePage.clickSauceCard();
        boolean actual = objHomePage.checkSaucePopUpEnabled();

        assertTrue(actual);
    }

    @Test
    public void checkConstructorTransitionMain() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        objHomePage.getPage();
        objHomePage.clickMainButton();
        objHomePage.clickMainCard();
        boolean actual = objHomePage.checkMainPopUpEnabled();

        assertTrue(actual);
    }
}
