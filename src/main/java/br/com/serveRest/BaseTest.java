package br.com.serveRest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BaseTest {
    protected ChromeDriver driver;

    @BeforeEach
    void iniciarDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Executa sem UI (importante para CI)
        options.addArguments("--no-sandbox"); // Necessário para rodar no Linux
        options.addArguments("--disable-dev-shm-usage"); // Evita erros por pouca memória compartilhada
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.get("https://front.serverest.dev/login");
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void fecharDriver(){
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Finalizando teste");
    }
}
