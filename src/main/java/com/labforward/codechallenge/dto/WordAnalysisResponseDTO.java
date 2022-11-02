package com.labforward.codechallenge.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data object for word frequency API response.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WordAnalysisResponseDTO {

  private int frequency;
  @Builder.Default
  private List<String> similarWords = new ArrayList<>();

}
