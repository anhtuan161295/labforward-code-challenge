package com.labforward.codechallenge.service;

import com.labforward.codechallenge.dto.WordAnalysisResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;

/**
 * A service contains related business logic about word frequency (optimized version).
 */
@Service
public class WordAnalysisServiceV2 {

  /**
   * A method to get word frequency and similar words with Levenshtein distance 1 from given text.
   * <p>
   * Time complexity: O(n).
   * <p>
   * Space complexity: O(n).
   *
   * @param text    a text entry to be searched.
   * @param keyword a word to search.
   * @return word analysis response.
   */
  public WordAnalysisResponseDTO getFrequencyAndSimilarWords(String text, String keyword) {
    String[] words = text.split(" ");
    LevenshteinDistance levenshteinDistance = new LevenshteinDistance(1);
    Pattern pattern = Pattern.compile("\\b" + keyword + "\\b");
    List<String> filteredWords = new ArrayList<>();

    int count = 0;
    for (String word : words) {
      boolean match = pattern.matcher(word).matches();
      if (match) {
        count++;
      }

      int result = levenshteinDistance.apply(word, keyword);
      if (result == 1) {
        filteredWords.add(word);
      }
    }

    return WordAnalysisResponseDTO.builder().frequency(count).similarWords(filteredWords).build();
  }


}
