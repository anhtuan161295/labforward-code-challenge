package com.labforward.codechallenge.controller;

import com.labforward.codechallenge.dto.WordAnalysisRequestDTO;
import com.labforward.codechallenge.dto.WordAnalysisResponseDTO;
import com.labforward.codechallenge.service.WordAnalysisServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for word frequency related requests.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class WordAnalysisController {

  private final WordAnalysisServiceV1 wordAnalysisServiceV1;

  /**
   * @param requestDTO request data object.
   * @return json response containing word frequency and similar words.
   */
  @PostMapping("word-frequency")
  public ResponseEntity<WordAnalysisResponseDTO> getWord(@RequestBody WordAnalysisRequestDTO requestDTO) {
    WordAnalysisResponseDTO responseDTO = WordAnalysisResponseDTO.builder().build();
    //
    responseDTO.setFrequency(wordAnalysisServiceV1.getFrequency(requestDTO.getText(), requestDTO.getKeyword()));
    responseDTO.setSimilarWords(wordAnalysisServiceV1.getSimilarWords(requestDTO.getText(), requestDTO.getKeyword()));
    return ResponseEntity.ok(responseDTO);
  }


}
