package br.com.gianlucampos.webcrawler;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class CrawlerControllerIntegrationTest extends BaseIntegrationTest {

    @Test
    @DisplayName("Returns words find out by relatedwords site")
    void getWordsTest() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/api/crawler/{word}", "bird")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding(StandardCharsets.UTF_8)
            )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
