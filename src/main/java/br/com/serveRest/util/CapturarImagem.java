package br.com.serveRest.util;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;


public class CapturarImagem {

    public static void capturarImagem(WebDriver driver, String nomeArquivo) {
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(nomeArquivo, "image/png", new ByteArrayInputStream(screenshotBytes), "png");

    }
}
