package br.com.gianlucampos.webcrawler.service;

import br.com.gianlucampos.webcrawler.models.LoginCredentials;
import br.com.gianlucampos.webcrawler.util.LocationConstants;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrawlerService {

    private final ChromeDriver driver;

    public List<String> scrapWords(String value) {
        String URL = "https://relatedwords.org/relatedto/";
        driver.get(URL + value);
        var words = driver.findElement(By.className("words"));
        var wordList = words.findElements(By.tagName("a"));
        return wordList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void loginRealValor(LoginCredentials credentials) {
        String URL = "https://web.orealvalor.com.br/";
        driver.get(URL);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(credentials.getLogin()).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(credentials.getPassword()).perform();

//        WebElement buttonLogin = driver.findElements(By.className("css-901oao")).get(4);
        WebElement buttonLogin = driver.findElements(By.className("css-901oao")).stream()
            .filter(elem -> elem.getDomProperty("textContent").equals("Entrar"))
            .findFirst().orElse(null);

        actions.click(buttonLogin).perform();
        takeScreenshot();
    }

    private void takeScreenshot() {
        try {
            Thread.sleep(5000);
            var print = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(Path.of(LocationConstants.RESOURCES.concat("screnshoot.png")), print);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
