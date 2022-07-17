package br.com.gianlucampos.webcrawler.config;

import javax.annotation.PostConstruct;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfig {

    @PostConstruct
    void postConstruct() {
        String path = System.getProperty("user.dir");
//        String resourcesPath = "\\resources\\chromedriver.exe";
        String resourcesPath = "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path.concat(resourcesPath));
    }

    @Bean
    public ChromeDriver driver() {
        final var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        return new ChromeDriver(chromeOptions);
    }


}
