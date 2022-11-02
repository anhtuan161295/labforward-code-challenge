# Read Me First
This project is used to demonstrate my problem-solving skills.

# Scope
* How much time did I spend ? 2 hours
* Scope: 
  * Basic implementation
  * Improved implementation
  * Future improvement
  * Detailed explanation

# Basic implementation
## 1. Word frequency
At first, I thought I need to find number of word occurrence. But after reading the requirement carefully, I need to add a boundary before and after the keyword, otherwise it won't work.  
Regex pattern: \bWord\b 
(\b is an expression for the boundary between word and non-word character e.g. space)

Time complexity: O(n)  
Space complexity: O(n)  

## 2. Similar words
This is a bit tricky because I need to find all words which contains the keyword and compare the Levenshtein distance.  
Firstly, I get all words by splitting the original text by the space, the results will contain all words without space at the moment.  
Secondly, I run another loop for all words and compare the Levenshtein distance one by one. If the distance is 1, add the word to the final results.  

Time complexity: O(n)  
Space complexity: O(n)

## 3. Testing
I used unit testing in `src/test/java` to check my implementation.  

# Improved implementation
In basic implementation, I created 2 method for different purpose, but the API performance will suffer because it runs the loop two twice.

I made an improved version to combine the logic into single method.  

Time complexity: O(n)  
Space complexity: O(n)

# User Interface



# Future improvement
- We can add a cache to store frequently keywords and notebook entry data. For example: Assuming every notebook entry will have a unique id, version and updated date. The cache key will be `unique_id_version_updated_date_keyword`
- Everytime user searches a keyword, we collect it and make the list of top 10 or 100 keywords. Every night the system will run a job to generate search results for these keywords.
- Data normalization and partitioning to speed up the query.
- Optimize the network by using high performance hardware and computing cluster
- Use gRPC and HTTP/2, these are faster technologies compared to REST and HTTP/1

