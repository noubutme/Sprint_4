package samokatPOM;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private final String currentURL = "https://qa-scooter.praktikum-services.ru";
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    private By orderButton = By.className("Button_Button__ra12g");
    private By bigOrderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");


        public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void getOrder(){
        driver.findElement(orderButton).click();
    }

    public void getQuestion(String question){
        WebElement clickText = driver.findElement(By.xpath("//div[text()='"+ question + "']"));
        new WebDriverWait(driver, 3);
        Assert.assertTrue(clickText.isDisplayed());
        Assert.assertTrue(clickText.isEnabled());
        clickText.click();
         }
    public void useBigOrderButton(){
        WebElement element = driver.findElement(bigOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 3);
        element.click();
    }
    public void cookieAccept(){
        driver.findElement(cookieButton).click();
    }

    public void getAnswer(String enableAnswer){
        WebElement text = driver.findElement(By.xpath("//p[text()='" + enableAnswer + "']"));
        Assert.assertTrue("Текст не видно",text.isDisplayed());
        }
    public void getTestUrl(){
        driver.get(currentURL);
    }

    public void scrollToPanel(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.className("accordion__button")));
    }
}
