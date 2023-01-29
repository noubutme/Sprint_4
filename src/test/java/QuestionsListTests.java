import samokatPOM.HomePage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class QuestionsListTests {
    private WebDriver driver;




    @Test
    public void checkAnswersList(){
        driver = new ChromeDriver();
        HomePage objHomepage = new HomePage(driver);
        objHomepage.getTestUrl();
        objHomepage.cookieAccept();
        objHomepage.scrollToPanel();
        for (int i = 0; i < objHomepage.qaCount(); i++) {
            objHomepage.getQuestion(i);
            objHomepage.getAnswer(i);
        }
    }

    @Test
    public void checkAnswersListFF(){
        driver = new FirefoxDriver();
        HomePage objHomepage = new HomePage(driver);
        objHomepage.getTestUrl();
        objHomepage.cookieAccept();
        objHomepage.scrollToPanel();
        for (int i = 0; i < objHomepage.qaCount(); i++) {
            objHomepage.getQuestion(i);
            objHomepage.getAnswer(i);
            }
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
