package br.com.gianlucampos.webcrawler.controller;

import br.com.gianlucampos.webcrawler.service.CrawlerService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class CrawlerControllerTest {

    @Mock
    private CrawlerService service;

    @MockBean
    private CrawlerController controller;


    @BeforeEach
    void setUp() {
        service = Mockito.mock(CrawlerService.class);
        controller = new CrawlerController(service);
    }

    @Test
    public void getWordsTest() {
        Mockito.when(service.scrapWords("Passaro")).thenReturn(List.of("Quero-Quero", "Sabiá"));

        var response = controller.getWords("Passaro");

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(2, response.getBody().size());
    }


}