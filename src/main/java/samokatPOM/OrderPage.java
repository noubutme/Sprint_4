package samokatPOM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By adressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    private By nextButton = By.xpath(".//button[text()='Далее']");

    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentTimeField = By.xpath(".//div[@class='Dropdown-placeholder']");//
    private By colorBlack = By.xpath("//*[@id=\"black\"]");
    private By colorGrey = By.xpath("//*[@id=\"grey\"]");
    private By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By confirmTitle = By.xpath(".//div[text()='Заказ оформлен']");

    private By ConfirmButton = By.xpath(".//button[text()='Да']");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void setNameField(String name) {
        Assert.assertTrue(driver.findElement(nameField).isDisplayed());
        Assert.assertTrue(driver.findElement(nameField).isEnabled());
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }
    public void setSurnameField(String surName){
        Assert.assertTrue(driver.findElement(surnameField).isDisplayed());
        Assert.assertTrue(driver.findElement(surnameField).isEnabled());
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(surName);
    }
    public void setAddressField(String address){
        Assert.assertTrue(driver.findElement(adressField).isDisplayed());
        Assert.assertTrue(driver.findElement(adressField).isEnabled());
        driver.findElement(adressField).clear();
        driver.findElement(adressField).sendKeys(address);
    }
    public void setMetroField(){
        Assert.assertTrue(driver.findElement(metroField).isDisplayed());
        Assert.assertTrue(driver.findElement(metroField).isEnabled());
        driver.findElement(metroField).click();
        driver.findElement(By.xpath(".//li[last()]")).click();
    }

    public void setPhoneField(String phone){
        Assert.assertTrue(driver.findElement(phoneField).isDisplayed());
        Assert.assertTrue(driver.findElement(phoneField).isEnabled());
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);
    }
    public void setDateField(String date){
        Assert.assertTrue(driver.findElement(dateField).isDisplayed());
        Assert.assertTrue(driver.findElement(dateField).isEnabled());
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).click();

    }

    public void setRentTimeField(String rentTime) {
        Assert.assertTrue(driver.findElement(rentTimeField).isDisplayed());
        Assert.assertTrue(driver.findElement(rentTimeField).isEnabled());
        driver.findElement(rentTimeField).click();
        driver.findElement(By.xpath("//div[text()='"+rentTime+"']")).click();
    }
    public void setColor(){
        driver.findElement(colorBlack).click();
    }
    public void setOrderButton(){
        driver.findElement(orderButton).click();
    }
    public void setNextButton(){
        Assert.assertTrue(driver.findElement(nextButton).isEnabled());
        driver.findElement(nextButton).click();
    }

    public void setConfirmButton() {
        Assert.assertTrue(driver.findElement(ConfirmButton).isEnabled());
        driver.findElement(ConfirmButton).click();
    }
    public void orderConfirmWindowCheck(){
        Assert.assertTrue("Что-то пошло не так",driver.findElement(confirmTitle).isDisplayed());
    }
}
