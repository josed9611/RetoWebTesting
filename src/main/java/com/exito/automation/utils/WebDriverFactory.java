package com.exito.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;

import static com.exito.automation.utils.ReadFiles.CHROME;
import static com.exito.automation.utils.ReadFiles.DEFAULT_BROWSER;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver goToWeb(String url) {
        WebDriver driver = getDriver();
        driver.get(url);
        driver.manage().window().maximize();

        return driver;
    }

    private static WebDriver getChromeDriver() {

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments(
                "--incognito",
                "--disable-infobars",
                "enable-automation",
                "--remote-allow-origins=*",
                "ignore-certificate-errors",
                "--disable-browser-side-navigation");

        return WebDriverManager.chromedriver().capabilities(chromeOptions).create();
    }

    private static WebDriver getDriver() {
        return (DEFAULT_BROWSER.equals(CHROME)) ? getChromeDriver() : getEdgeDriver();
    }

    private static WebDriver getEdgeDriver() {

        EdgeOptions options = new EdgeOptions();
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.addArguments("--remote-allow-origins=*");
        return WebDriverManager.edgedriver().capabilities(options).create();

    }
}