package com.labforward.codechallenge.controller;

import com.labforward.codechallenge.dto.WordFrequencyRequestDTO;
import com.labforward.codechallenge.dto.WordFrequencyResponseDTO;
import com.labforward.codechallenge.service.WordAnalysisServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for word frequency related requests.
 */
@RestController
@RequestMapping("/api/word-frequency")
@RequiredArgsConstructor
public class WordFrequencyController {

  private final WordAnalysisServiceV1 wordAnalysisServiceV1;

  /**
   * @param requestDTO request data object.
   * @return json response containing word frequency and similar words.
   */
  @PostMapping("word-frequency")
  public ResponseEntity<WordFrequencyResponseDTO> getWord(@RequestBody WordFrequencyRequestDTO requestDTO) {
    WordFrequencyResponseDTO responseDTO = WordFrequencyResponseDTO.builder().build();
    //
    responseDTO.setFrequency(wordAnalysisServiceV1.getFrequency(requestDTO.getText(), requestDTO.getKeyword()));
    responseDTO.setSimilarWords(wordAnalysisServiceV1.getSimilarWords(requestDTO.getText(), requestDTO.getKeyword()));
    return ResponseEntity.ok(responseDTO);
  }


}
