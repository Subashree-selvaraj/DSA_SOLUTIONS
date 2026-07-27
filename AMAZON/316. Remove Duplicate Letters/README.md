<h2><a href="https://leetcode.com/problems/remove-duplicate-letters">316. Remove Duplicate Letters</a></h2>

<p>Given a string <code>s</code>, remove duplicate letters so that every letter appears once and only once. You must make sure your result is <span data-keyword="lexicographically-smaller-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1o_" data-state="closed" class=""><strong>the smallest in lexicographical order</strong></button></span> among all possible results.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "bcabc"
<strong>Output:</strong> "abc"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "cbacdcbc"
<strong>Output:</strong> "acdb"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as 1081: <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/" target="_blank">https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/</a></p>


---

# 🛍️ Remove-Duplicate-Letters | Explained

## Approach 1: Stack-Based Lexicographically Smallest Subsequence
### Intuition
The provided code solution utilizes a stack-based approach to find the lexicographically smallest subsequence without duplicate letters. This approach works by iterating through the input string and maintaining a stack of characters that represent the current smallest subsequence. The intuition behind this approach is to ensure that the stack always contains the smallest character that has not been seen before, and if a smaller character is encountered, the stack is updated accordingly.

### Approach
The algorithm starts by initializing an array `lastIndex` to keep track of the last occurrence of each character in the input string. It also uses a boolean array `seen` to mark the characters that have been added to the stack. The algorithm then iterates through the input string, and for each character, it checks if it has been seen before. If it has, the algorithm skips to the next character. If not, the algorithm checks if the stack is not empty and the top character of the stack is greater than the current character. If this condition is met, the algorithm pops the top character from the stack and marks it as unseen. This process continues until the stack is empty or the top character is smaller than the current character. Finally, the algorithm adds the current character to the stack and marks it as seen.

### Detailed Code Analysis
Let's break down the code into smaller sections and analyze each part:

*   `int[] lastIndex = new int[26];`: This line initializes an array `lastIndex` of size 26, where each index represents a lowercase letter of the alphabet. The value at each index will store the last occurrence of the corresponding character in the input string.
*   `for (int i = 0; i < s.length(); i++)`: This loop iterates through the input string `s`.
*   `lastIndex[s.charAt(i) - 'a'] = i;`: This line updates the `lastIndex` array with the last occurrence of the current character. The expression `s.charAt(i) - 'a'` calculates the index of the current character in the `lastIndex` array.
*   `boolean[] seen = new boolean[26];`: This line initializes a boolean array `seen` of size 26, where each index represents a lowercase letter of the alphabet. The value at each index will be `true` if the corresponding character has been added to the stack and `false` otherwise.
*   `Stack<Integer> st = new Stack();`: This line initializes a stack `st` to store the characters of the smallest subsequence.
*   The main loop `for (int i = 0; i < s.length(); i++)` iterates through the input string `s`. For each character, it checks if the character has been seen before using the `seen` array. If it has, the loop skips to the next character.
*   `int curr = s.charAt(i) - 'a';`: This line calculates the index of the current character in the `lastIndex` and `seen` arrays.
*   `while (!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()])`: This loop checks if the stack is not empty, the top character of the stack is greater than the current character, and the current character appears again in the input string after the current position. If all these conditions are met, the loop pops the top character from the stack and marks it as unseen using the `seen` array.
*   `st.push(curr);`: This line adds the current character to the stack.
*   `seen[curr] = true;`: This line marks the current character as seen using the `seen` array.
*   Finally, the algorithm uses a `StringBuilder` to construct the resulting string by popping characters from the stack and appending them to the builder.

### Code
```java
int[] lastIndex = new int[26];
for (int i = 0; i < s.length(); i++){
    lastIndex[s.charAt(i) - 'a'] = i; 
}
boolean[] seen = new boolean[26]; 
Stack<Integer> st = new Stack();
for (int i = 0; i < s.length(); i++) {
    int curr = s.charAt(i) - 'a';
    if (seen[curr]) continue; 
    while (!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]){
        seen[st.pop()] = false; 
    }
    st.push(curr); 
    seen[curr] = true; 
}
StringBuilder sb = new StringBuilder();
while (!st.isEmpty())
    sb.append((char) (st.pop() + 'a'));
return sb.reverse().toString();
```
### Complexity
*   **Time:** The algorithm has a time complexity of O(n), where n is the length of the input string. This is because the algorithm iterates through the input string once and performs a constant amount of work for each character.
*   **Space:** The algorithm has a space complexity of O(n), where n is the length of the input string. This is because the algorithm uses a stack to store the characters of the smallest subsequence, and in the worst case, the stack can grow up to the size of the input string.

## 🕵️‍♂️ Follow-up Questions
Some common follow-up questions for this problem are:

*   How would you modify the algorithm to find the lexicographically largest subsequence without duplicate letters?
*   What if the input string contains uppercase letters or non-alphabet characters? How would you modify the algorithm to handle these cases?

Answering these questions requires modifying the algorithm to maintain a stack of characters that represent the current largest subsequence and updating the conditions for popping characters from the stack accordingly. Additionally, handling uppercase letters and non-alphabet characters involves modifying the index calculations and character comparisons to account for the extended character set.