package com.labforward.codechallenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;

/**
 * A service contains related business logic about word frequency.
 */
@Service
public class WordAnalysisServiceV1 {

  /**
   * A method to get word frequency from given text.
   * <p>
   * Time complexity: O(n).
   * <p>
   * Space complexity: O(n).
   *
   * @param text    a text entry to be searched.
   * @param keyword a word to search.
   * @return frequency of word occurrence.
   */
  public int getFrequency(String text, String keyword) {
    Pattern pattern = Pattern.compile("\\b" + keyword + "\\b");
    Matcher matcher = pattern.matcher(text);
    int count = 0;
    while (matcher.find()) {
      count++;
    }
    return count;
  }

  /**
   * A method to get similar words from given text with Levenshtein distance 1.
   * <p>
   * Time complexity: O(n).
   * <p>
   * Space complexity: O(n).
   *
   * @param text    a text entry to be searched.
   * @param keyword a word to search.
   * @return list of similar words.
   */
  public List<String> getSimilarWords(String text, String keyword) {
    String[] words = text.split(" ");
    List<String> filteredWords = new ArrayList<>();
    LevenshteinDistance levenshteinDistance = new LevenshteinDistance(1);
    for (String word : words) {
      int result = levenshteinDistance.apply(word, keyword);
      if (result == 1) {
        filteredWords.add(word);
      }
    }

    return filteredWords;
  }

}
