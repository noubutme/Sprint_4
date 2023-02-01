import samokatPOM.HomePage;
import samokatPOM.OrderPage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class OrderTests {
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;
    private final String rentTime;
    private WebDriver driver;

    public OrderTests(String name, String surname, String address, String phone, String date, String rentTime) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.rentTime=rentTime;
    }
    @Parameterized.Parameters
    public static Object[][] getPersonData(){
        return new Object[][]{
                {"Геральд","Белый", "Ривия", "79996665544", "02.02.2022","сутки"},
                {"Гарри","Поттер", "Лондон", "79030630559", "01.03.2023","сутки"},
                {"Лев", "Толстой", "г.Москва,ул.Горького,д.32,кв.253", "79060880202","01.01.2030","сутки"}
        };
    }

    @Test
    public void orderTest(){
    driver = new ChromeDriver();
        HomePage objHomepaje = new HomePage(driver);
        objHomepaje.getTestUrl();
        objHomepaje.getOrder();
        OrderPage objOrderpaje = new OrderPage(driver);
        objOrderpaje.setNameField(name);
        objOrderpaje.setSurnameField(surname);
        objOrderpaje.setAddressField(address);
        objOrderpaje.setMetroField();
        objOrderpaje.setPhoneField(phone);
        objOrderpaje.setNextButton();
        objOrderpaje.setDateField(date);
        objOrderpaje.setColor();
        objOrderpaje.setRentTimeField(rentTime);
        objOrderpaje.setOrderButton();
        objOrderpaje.setConfirmButton();// баг в хроме
        objOrderpaje.orderConfirmWindowCheck();
    }
    @Test
    public void bigButtonOrderTest(){
        driver = new ChromeDriver();
        HomePage objHomepaje = new HomePage(driver);
        objHomepaje.getTestUrl();
        objHomepaje.cookieAccept();
        objHomepaje.useBigOrderButton();
        OrderPage objOrderpaje = new OrderPage(driver);
        objOrderpaje.setNameField(name);
        objOrderpaje.setSurnameField(surname);
        objOrderpaje.setAddressField(address);
        objOrderpaje.setMetroField();
        objOrderpaje.setPhoneField(phone);
        objOrderpaje.setNextButton();
        objOrderpaje.setDateField(date);
        objOrderpaje.setColor();
        objOrderpaje.setRentTimeField(rentTime);
        objOrderpaje.setOrderButton();
        objOrderpaje.setConfirmButton();// баг в хроме
        objOrderpaje.orderConfirmWindowCheck();
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
