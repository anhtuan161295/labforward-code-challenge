package com.labforward.codechallenge.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.labforward.codechallenge.dto.WordFrequencyRequestDTO;
import com.labforward.codechallenge.dto.WordFrequencyResponseDTO;
import com.labforward.codechallenge.service.WordAnalysisServiceV1;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class WordFrequencyControllerTest {

  @Mock
  WordAnalysisServiceV1 wordAnalysisServiceV1;

  @InjectMocks
  WordFrequencyController wordFrequencyController;

  @Test
  void getWord() {
    when(wordAnalysisServiceV1.getFrequency(anyString(), anyString())).thenReturn(1);
    when(wordAnalysisServiceV1.getSimilarWords(anyString(), anyString())).thenReturn(new ArrayList<>());
    //
    WordFrequencyRequestDTO requestDTO = WordFrequencyRequestDTO.builder().text("Lorem ipsum").keyword("lorem").build();
    ResponseEntity<WordFrequencyResponseDTO> response = wordFrequencyController.getWord(requestDTO);
    WordFrequencyResponseDTO responseDTO = response.getBody();
    assertNotNull(responseDTO);
    assertEquals(1, responseDTO.getFrequency());
  }
}