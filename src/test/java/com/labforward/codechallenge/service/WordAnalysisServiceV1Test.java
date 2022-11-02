package com.labforward.codechallenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class WordAnalysisServiceV1Test {

  @InjectMocks
  WordAnalysisServiceV1 wordAnalysisService;

  @Test
  void getFrequency_1() {
    int result = wordAnalysisService.getFrequency("Word Words Wor word", "Word");
    assertEquals(1, result);
  }

  @Test
  void getSimilarWords_1() {
    List<String> result = wordAnalysisService.getSimilarWords("Word Words Wor word", "Word");
    assertLinesMatch(List.of("Words", "Wor", "word"), result);
  }

  @Test
  void getFrequency_2() {
    int result = wordAnalysisService.getFrequency("Word Word Word word", "Word");
    assertEquals(3, result);
  }

  @Test
  void getSimilarWords_2() {
    List<String> result = wordAnalysisService.getSimilarWords("Word Word Word word", "Word");
    assertLinesMatch(List.of("word"), result);
  }
}