package com.labforward.codechallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data object for word frequency API request.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WordAnalysisRequestDTO {

  @Builder.Default
  private String text = "";
  @Builder.Default
  private String keyword = "";

}
