package com.labforward.codechallenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import com.labforward.codechallenge.dto.WordAnalysisResponseDTO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class WordAnalysisServiceV2Test {

  @InjectMocks
  WordAnalysisServiceV2 wordAnalysisService;

  @Test
  void getFrequencyAndSimilarWords_1() {
    WordAnalysisResponseDTO responseDTO = wordAnalysisService.getFrequencyAndSimilarWords("Word Words Wor word", "Word");
    assertEquals(1, responseDTO.getFrequency());
    assertLinesMatch(List.of("Words", "Wor", "word"), responseDTO.getSimilarWords());
  }

  @Test
  void getFrequencyAndSimilarWords_2() {
    WordAnalysisResponseDTO responseDTO = wordAnalysisService.getFrequencyAndSimilarWords("Word Word Word word", "Word");
    assertEquals(3, responseDTO.getFrequency());
    assertLinesMatch(List.of("word"), responseDTO.getSimilarWords());
  }
}