package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    public WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver","/Users/Hebert928/Downloads/WebDriver/bin/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                return new ChromeDriver(options);
            case "chrome":
            default:
                return new ChromeDriver();
        }
    }
}
