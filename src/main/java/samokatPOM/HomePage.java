package samokatPOM;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    private By orderButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    private By bigOrderButton = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
    private By qaPanal = By.className("accordion");
    private By questionsList = By.xpath("//div[@data-accordion-component='AccordionItemButton']");

    private String[] answers = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };
        public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void getOrder(){
        driver.findElement(orderButton).click();
    }

    public void getQuestion(int index){
        List<WebElement> questions = driver.findElements(questionsList);
        questions.get(index).click();
        new WebDriverWait(driver, 3);
         }
    public void useBigOrderButton(){
        WebElement element = driver.findElement(bigOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    public void cookieAccept(){
        driver.findElement(cookieButton).click();
    }

    public int qaCount(){
            return driver.findElements(By.className("accordion__item")).size();
    }

    public String getRightAnswer(int index){
            return answers[index];
    }
    public void getAnswer(int index){
        WebElement text = driver.findElement(By.xpath("//div[@aria-labelledby='accordion__heading-" + index + "']"));
        Assert.assertTrue("Текст не видно",text.isDisplayed());
        Assert.assertEquals("Текст ответа не соответствует",getRightAnswer(index), text.getText());
    }
    public void getTestUrl(){
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    public void scrollToPanel(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.className("accordion__button")));
    }
}
