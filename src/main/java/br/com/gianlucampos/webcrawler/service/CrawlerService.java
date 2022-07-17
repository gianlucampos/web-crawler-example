package br.com.gianlucampos.webcrawler.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

}
