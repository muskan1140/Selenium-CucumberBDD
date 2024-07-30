package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class helperClass {

    public static WebDriver driver;

    public static String[] sepreateLocator(String identifierValue){
        String selector = ObjectRepo.getSelector(identifierValue);
        String[] locators = selector.split(",");
        return locators;
    }

    public static void click(String identifierValue) {
        String[] locators = sepreateLocator(identifierValue);
        getWebElement(locators[0],locators[1]).click();
    }

    public static void inputField(String element,String identifierValue) {
        String[] locators = sepreateLocator(identifierValue);
        getWebElement(locators[0],locators[1]).sendKeys(element);
//        driver.findElement(By.id(identifierType)).sendKeys(identifierValue);
    }

    public static void refreshes() {
        driver.navigate().refresh();
    }

    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public static void Dismiss() {
        driver.switchTo().alert().dismiss();
    }

    public static void hardWait(long milliSecondsToWait) {
        try {
            Thread.sleep(milliSecondsToWait);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void clickByCss(String identifierValue) {
//        driver.findElement(By.cssSelector(identifierValue)).click();
//    }
//
//    public static void clickById(String identifierValue) {
//        driver.findElement(By.id(identifierValue)).click();
//    }
//
//    public static void clickName(String identifierValue) {
//        driver.findElement(By.name(identifierValue)).click();
//    }


    public static void checkDisplayedByXpath(String identifierValue) {
        driver.findElement(By.xpath(identifierValue)).isDisplayed();
    }

    public static void checkDisplayedById(String identifierValue) {
        driver.findElement(By.id(identifierValue)).isDisplayed();
    }

    public static void checkEnabledByXpath(String identifierValue) {
        driver.findElement(By.xpath(identifierValue)).isEnabled();
    }


    public static void sendKeysByName(String identifierType,String identifierValue) {
        driver.findElement(By.name(identifierType)).sendKeys(identifierValue);
    }

    public static void sendKeysByCss(String identifierType,String identifierValue) {
        driver.findElement(By.cssSelector(identifierType)).sendKeys(identifierValue);
    }


    public static void sendKeysByXpath(String identifierType,String identifierValue) {
        driver.findElement(By.xpath(identifierType)).sendKeys(identifierValue);
    }


    public static void setDriver() {
        driver = new ChromeDriver();
    }

    public static void navigateToHome(String identifier) {
        driver.get(ObjectRepo.getSelector(identifier));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void quit() {
        driver.quit();
    }

    public static String verifyTitle() {
        String title = driver.getTitle();
        return title;
    }

    public static void getWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebElement getWebElement(String identifierType, String identifierValue) {
        return switch (identifierType) {
            case "xpath" -> driver.findElement(By.xpath(identifierValue));
            case "CSS" -> driver.findElement(By.cssSelector(identifierValue));
            case "Id" -> driver.findElement(By.id(identifierValue));
            case "PartialText" -> driver.findElement(By.partialLinkText(identifierValue));
            case "TagName" -> driver.findElement(By.tagName(identifierValue));
            case "Name" -> driver.findElement(By.name(identifierValue));
            default -> null;
        };
    }
}
