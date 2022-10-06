package br.com.gianlucampos.webcrawler.config;

import br.com.gianlucampos.webcrawler.util.LocationConstants;
import javax.annotation.PostConstruct;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfig {

    @PostConstruct
    void postConstruct() {
        System.setProperty("webdriver.chrome.driver", LocationConstants.CHROME_DRIVER);
    }

    @Bean
    public ChromeDriver driver() {
        try {
            var options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--start-fullscreen");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--headless");
            return new ChromeDriver(options);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


}
