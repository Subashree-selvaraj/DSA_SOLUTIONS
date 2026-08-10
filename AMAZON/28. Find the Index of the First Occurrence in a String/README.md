<h2><a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string">28. Find the Index of the First Occurrence in a String</a></h2>

<p>Given two strings <code>needle</code> and <code>haystack</code>, return the index of the first occurrence of <code>needle</code> in <code>haystack</code>, or <code>-1</code> if <code>needle</code> is not part of <code>haystack</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> haystack = "sadbutsad", needle = "sad"
<strong>Output:</strong> 0
<strong>Explanation:</strong> "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> haystack = "leetcode", needle = "leeto"
<strong>Output:</strong> -1
<strong>Explanation:</strong> "leeto" did not occur in "leetcode", so we return -1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= haystack.length, needle.length &lt;= 10<sup>4</sup></code></li>
	<li><code>haystack</code> and <code>needle</code> consist of only lowercase English characters.</li>
</ul>


---

# 🛍️ Find-the-Index-of-the-First-Occurrence-in-a-String | Explained

## Approach 1: Brute Force Substring Comparison
### Intuition
This approach works by iterating over the haystack string and comparing every possible substring of the same length as the needle string. It's akin to manually searching for a specific word in a large book by checking every sequence of characters that matches the word's length. The intuition relies on the fact that if a substring matches the needle, it must be the first occurrence we're looking for.

### Algorithm Visualized
```mermaid
graph LR
    A[HAYSTACK] -->|SUBSTRING|> B[NORMALIZED NEEDLE LENGTH LOOP]
    B -->|SUBSTRING MATCH|> C[RETURN INDEX]
    B -->|NO MATCH|> D[NEXT INDEX]
    D -->|REPEAT|> B
    C -->|FINISH|> E[END]
```

### Approach
1. Start by checking if the needle can even fit within the haystack. If the needle is longer, there's no possible match.
2. Initialize a loop to iterate over the haystack, but only up to the point where the needle could still fit.
3. For each starting index in the haystack, compare characters one by one with the needle, moving along both strings simultaneously.
4. If a match is found for all characters in the needle, return the starting index where the comparison began.
5. If no match is found after checking all possible substrings, return -1 to indicate the needle was not found.

### Detailed Code Analysis
- Lines 1-2 define the `Solution` class with a method `strStr` that takes two `String` parameters: `haystack` and `needle`. 
- Line 3 checks if the `needle` length exceeds the `haystack` length. If true, it returns -1 immediately, as the `needle` cannot be a substring of `haystack`.
- Lines 6-7 store the lengths of `haystack` and `needle` in separate variables for readability and efficiency.
- The loop starting on line 8 iterates over possible starting indices in `haystack` where `needle` could potentially start. The condition `startIndex <= haystackLength - needleLength` ensures that there are enough characters left in `haystack` to potentially match `needle`.
- Inside the loop, a nested while loop (lines 10-12) compares characters of `needle` with the corresponding substring of `haystack` starting at `startIndex`. The variable `j` keeps track of the current character being compared.
- If the while loop completes without finding a mismatch (i.e., `j == needleLength`), it means `needle` is a substring of `haystack` starting at `startIndex`, so the method returns `startIndex` (line 14).
- If the outer loop completes without finding a match, the method returns -1 (line 17), indicating that `needle` is not a substring of `haystack`.

### Code
```java
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()){
            return -1;
        }
        int haystackLength=haystack.length();
        int needleLength=needle.length();
        for(int startIndex=0;startIndex<=haystackLength-needleLength;startIndex++){
            int j=0;
            while(j<needleLength && haystack.charAt(startIndex + j) == needle.charAt(j)){
                j++;
            }
            if(j==needleLength){
                return startIndex;
            }
        }
        return -1;
    }
}
```

### Complexity
- **Time:** O(n*m) where n is the length of `haystack` and m is the length of `needle`. This is because in the worst case, for each character in `haystack`, we might compare it with every character in `needle`.
- **Space:** O(1) as we only use a constant amount of space to store indices and lengths, regardless of the input size.