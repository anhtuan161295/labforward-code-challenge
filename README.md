# Read Me First
This project is used to demonstrate my problem-solving skills.

# Scope
* How much time did I spend ? 2 hours
* Scope: 
  * Basic implementation
  * Improved implementation
  * Future planning
  * Detailed explanation

# Basic implementation
## 1. Word frequency
At first, I thought I need to find number of word occurrence. But after reading the requirement carefully, I need to add a boundary before and after the keyword, otherwise it won't work.  
Regex pattern: \bWord\b 
(\b is an expression for the boundary between word and non-word character e.g. space)

## 2. Similar words
This is a bit tricky because I need to find all words which contains the keyword and compare the Levenshtein distance.  
Firstly, I get all words by splitting the original text by the space, the results will contain all words without space at the moment.  
Secondly, I run another loop for all words and compare the Levenshtein distance one by one. If the distance is 1, add the word to the final results.  

## 3. Testing
I used unit testing in `src/test/java` to check my implementation.  

# Improved implementation



# Future planning


