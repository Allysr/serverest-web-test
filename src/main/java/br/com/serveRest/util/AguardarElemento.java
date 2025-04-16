package br.com.serveRest.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AguardarElemento {
    private  WebDriver driver;

    public AguardarElemento (WebDriver driver){
        this.driver = driver;
    }

    public WebElement aguardarElemento(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
