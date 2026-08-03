<h2><a href="https://leetcode.com/problems/reverse-words-in-a-string">151. Reverse Words in a String</a></h2>

<p>Given an input string <code>s</code>, reverse the order of the <strong>words</strong>.</p>

<p>A <strong>word</strong> is defined as a sequence of non-space characters. The <strong>words</strong> in <code>s</code> will be separated by at least one space.</p>

<p>Return <em>a string of the words in reverse order concatenated by a single space.</em></p>

<p><b>Note</b> that <code>s</code> may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "the sky is blue"
<strong>Output:</strong> "blue is sky the"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "  hello world  "
<strong>Output:</strong> "world hello"
<strong>Explanation:</strong> Your reversed string should not contain leading or trailing spaces.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "a good   example"
<strong>Output:</strong> "example good a"
<strong>Explanation:</strong> You need to reduce multiple spaces between two words to a single space in the reversed string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> contains English letters (upper-case and lower-case), digits, and spaces <code>' '</code>.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
</ul>

<p>&nbsp;</p>
<p><b data-stringify-type="bold">Follow-up:&nbsp;</b>If the string data type is mutable in your language, can&nbsp;you solve it&nbsp;<b data-stringify-type="bold">in-place</b>&nbsp;with&nbsp;<code data-stringify-type="code">O(1)</code>&nbsp;extra space?</p>


---

# 🛍️ Reverse-Words-in-a-String | Explained

## Approach 1: String Split and Reverse Iteration
### Intuition
The core idea behind this approach is to split the input string into an array of words and then iterate over the array in reverse order, appending each word to a result string. This approach works because it effectively reverses the order of the words in the string while preserving the original word order. To understand this, consider a simple analogy: imagine having a stack of plates where each plate represents a word. By popping the plates off the stack (i.e., iterating in reverse), you can rebuild the stack in the reverse order of the original stacking.

### Algorithm Visualized
```mermaid
graph LR
    A[Input String] -->|split|> B[Array of Words]
    B -->|reverse iterate|> C[Result String Builder]
    C -->|toString|> D[Result String]
```

### Approach
The algorithmic logic is straightforward:
1. Remove leading and trailing whitespace from the input string.
2. Split the string into an array of words based on one or more whitespace characters.
3. Initialize an empty string builder to store the result.
4. Iterate over the array of words in reverse order.
5. For each word, append it to the result string builder.
6. After appending each word (except the last one), append a space to separate the words in the result string.
7. Finally, convert the string builder to a string and remove any trailing whitespace before returning the result.

### Detailed Code Analysis
Let's dive into the code:
- Line 3: `StringBuilder ans=new StringBuilder();` initializes an empty string builder `ans` to efficiently build the result string. Using a `StringBuilder` instead of concatenating strings with `+` is more efficient because it avoids creating temporary strings.
- Line 4: `String[] words=s.trim().split("\\s+");` first removes leading and trailing whitespace from the input string `s` with `trim()`, then splits the string into an array of words using one or more whitespace characters (`\\s+`) as the delimiter.
- Line 5: `for(int i=words.length-1;i>=0;i--){` starts a loop that iterates over the `words` array in reverse order, starting from the last word and moving towards the first.
- Line 6: `ans.append(words[i]);` appends the current word to the `ans` string builder.
- Lines 7-8: `if(i>0){ ans.append(" "); }` checks if the current word is not the first word (i.e., `i` is greater than 0), and if so, appends a space to `ans` to separate the words in the result string. However, there seems to be a typo or omission in the provided code (`ans.append( );`), which should append a space character.
- Line 12: `return ans.toString().trim();` converts the `ans` string builder to a string, removes any leading or trailing whitespace with `trim()`, and returns the result.

### Code
```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for(int i = words.length - 1; i >= 0; i--){
            ans.append(words[i]);
            if(i > 0){
                ans.append(" ");
            }
        }
        return ans.toString().trim();
    }
}
```

### Complexity
- **Time:** The time complexity of this solution is O(n + m), where n is the length of the input string `s` (for the `trim()` and `split()` operations) and m is the total number of characters in all the words (for the loop that appends words to `ans`). The `split()` operation itself has a time complexity of O(n), and the loop that appends words to `ans` has a time complexity of O(m). However, because m <= n (since m counts only the characters within words, excluding spaces), we can simplify this to O(n).
- **Space:** The space complexity is O(n), as in the worst case, the `words` array and the `ans` string builder could store all characters from the input string `s`.