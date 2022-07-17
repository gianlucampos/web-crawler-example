package br.com.gianlucampos.webcrawler.controller;

import br.com.gianlucampos.webcrawler.service.CrawlerService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/crawler")
@AllArgsConstructor
public class CrawlerController {

    private final CrawlerService service;

    @GetMapping("/{word}")
    public ResponseEntity<List<String>> getWords(@PathVariable String word) {
        var words = service.scrapWords(word);
        System.out.println("Number of words finded: ".concat(String.valueOf(words.size())));
        return ResponseEntity.ok(words);
    }

}
