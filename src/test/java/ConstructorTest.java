import stellarBurgers.HomePage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConstructorTest extends BaseTest{
    public HomePage objHomePage;

    @Before
    @Override
    public void init() {
        super.init();
        objHomePage = new HomePage(driver);
        objHomePage.getPage();
    }

    @Test
    public void checkConstructorTransitionBun() {
        boolean actual =  objHomePage.checkConstructorTabIsActive("Булки");

        assertTrue(actual);
    }

    @Test
    public void checkConstructorTransitionSauce() {
        objHomePage.clickSauceButton();
        boolean actual = objHomePage.checkConstructorTabIsActive("Соусы");

        assertTrue(actual);
    }

    @Test
    public void checkConstructorTransitionMain() {
        objHomePage.clickMainButton();
        boolean actual = objHomePage.checkConstructorTabIsActive("Начинки");

        assertTrue(actual);
    }
}
