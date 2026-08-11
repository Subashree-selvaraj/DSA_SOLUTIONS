<h2><a href="https://leetcode.com/problems/integer-to-english-words">273. Integer to English Words</a></h2>

<p>Convert a non-negative integer <code>num</code> to its English words representation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> num = 123
<strong>Output:</strong> "One Hundred Twenty Three"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> num = 12345
<strong>Output:</strong> "Twelve Thousand Three Hundred Forty Five"
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> num = 1234567
<strong>Output:</strong> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= num &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


---

# 🛍️ Integer-to-English-Words | Explained

## Approach 1: Recursive Integer-to-English-Words Conversion
### Intuition
The core idea behind this approach is to break down the integer into smaller parts (thousands, hundreds, tens, and ones) and recursively convert each part into English words. This works because the English language has a well-defined set of words for numbers up to 19, and then follows a pattern for larger numbers (e.g., tens, hundreds, thousands).

### Algorithm Visualized
No specific Mermaid.js diagram is provided for this approach, as the logic is primarily recursive and focused on string manipulation.

### Approach
The high-level logic flow involves checking each part of the number (thousands, hundreds, tens, and ones) and recursively converting non-zero parts into English words. The words are then combined with the appropriate unit (thousand, hundred, etc.) to form the final English phrase.

### Detailed Code Analysis
The given code snippet is a key part of this recursive approach. Let's break it down:
- `if (part != 0)`: This line checks if the current part of the number is non-zero. If it is, the code within this block is executed.
- `String temp = convert(part);`: This line calls the `convert` method recursively on the current part of the number, storing the result in the `temp` variable. The `convert` method is assumed to handle the conversion of the part into English words.
- `if (!unit[i].isEmpty())`: This line checks if the current unit (e.g., thousand, hundred) is not empty. If it's not empty, the code within this block is executed.
- `temp += + unit[i];`: This line appends the current unit to the `temp` string. The `+` operator is used for string concatenation.
- The subsequent `if-else` block checks if the `ans` string is empty. If it is, the `temp` string is assigned to `ans`. Otherwise, the `temp` string is prepended to `ans` with a space in between.

### Code
```java
if (part != 0) {
    String temp = convert(part);
    if (!unit[i].isEmpty()) {
        temp += " " + unit[i];
    }
    if (ans.isEmpty()) {
        ans = temp;
    } else {
        ans = temp + " " + ans;
    }
}
```

### Complexity
- **Time:** The time complexity of this approach is O(log n), where n is the input integer. This is because the algorithm recursively breaks down the number into smaller parts, and the number of recursive calls is proportional to the number of digits in the input number.
- **Space:** The space complexity of this approach is O(log n), as the recursive call stack can grow up to the number of digits in the input number.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. How would you optimize this approach for very large input numbers?
   - One possible optimization is to use a more efficient data structure, such as a trie, to store the English words for numbers. This could reduce the time complexity of the `convert` method.
2. How would you handle cases where the input number is negative or zero?
   - To handle negative numbers, you could add a special case to check if the input number is negative, and if so, prepend the word "minus" to the result. For zero, you could add a special case to return the word "zero" directly.