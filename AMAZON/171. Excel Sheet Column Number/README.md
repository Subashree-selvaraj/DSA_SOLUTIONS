<h2><a href="https://leetcode.com/problems/excel-sheet-column-number">171. Excel Sheet Column Number</a></h2>

<p>Given a string <code>columnTitle</code> that represents the column title as appears in an Excel sheet, return <em>its corresponding column number</em>.</p>

<p>For example:</p>

<pre>A -&gt; 1
B -&gt; 2
C -&gt; 3
...
Z -&gt; 26
AA -&gt; 27
AB -&gt; 28 
...
</pre>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> columnTitle = "A"
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> columnTitle = "AB"
<strong>Output:</strong> 28
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> columnTitle = "ZY"
<strong>Output:</strong> 701
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= columnTitle.length &lt;= 7</code></li>
	<li><code>columnTitle</code> consists only of uppercase English letters.</li>
	<li><code>columnTitle</code> is in the range <code>["A", "FXSHRXW"]</code>.</li>
</ul>


---

# 🛍️ Excel-Sheet-Column-Number | Explained

## Approach 1: Base-26 Conversion
### Intuition
The Excel-Sheet-Column-Number problem can be solved by treating the column title as a base-26 number, where each character represents a digit in this base-26 system. For example, 'A' represents 1, 'B' represents 2, and so on. This approach works because the problem essentially asks us to convert a base-26 number (the column title) to a decimal number (the column number). A real-world analogy for this approach is converting a number from one base system to another, such as converting a hexadecimal number to decimal.

### Algorithm Visualized
```mermaid
graph LR
    A[Column Title] -->|Base-26 to Decimal|> B[Column Number]
    B -->|Result|> C[Output]
```

### Approach
The approach involves iterating over each character in the column title, converting it to its corresponding base-26 value, and then using this value to calculate the decimal equivalent of the base-26 number. The calculation involves multiplying the current decimal value by 26 (the base) and adding the new base-26 digit value.

### Detailed Code Analysis
The provided code implements this approach as follows:
- Line 5: `int ans = 0;` initializes a variable `ans` to store the decimal equivalent of the column title. It starts at 0 because we haven't processed any characters yet.
- Line 7: `for (int i = 0; i < columnTitle.length(); i++)` iterates over each character in the column title.
- Line 9: `char ch = columnTitle.charAt(i);` retrieves the current character being processed.
- Line 11: `int value = ch - 'A' + 1;` converts the character to its base-26 value. This works because the ASCII values of 'A' to 'Z' are consecutive, so subtracting 'A' gives us a value starting from 0, and adding 1 shifts the range to start from 1, which is what we need for base-26 conversion.
- Line 13: `ans = ans * 26 + value;` updates the decimal equivalent by multiplying the current value by 26 (to shift the digits to the left, making space for the new digit) and adding the new digit's value.
- Line 16: `return ans;` returns the calculated decimal equivalent of the column title.

### Code
```java
public int titleToNumber(String columnTitle) {
    int ans = 0;
    for (int i = 0; i < columnTitle.length(); i++) {
        char ch = columnTitle.charAt(i);
        int value = ch - 'A' + 1;
        ans = ans * 26 + value;
    }
    return ans;
}
```

### Complexity
- **Time:** O(n), where n is the length of the column title. This is because we iterate over each character in the title once.
- **Space:** O(1), which means the space required does not change with the size of the input. This is because we use a constant amount of space to store the result and the loop variables, regardless of the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **What if the input string is empty or null?** 
   Answer: The current implementation does not handle these cases explicitly. Adding a check at the beginning of the function to return an appropriate value (e.g., 0 for an empty string) or throw an exception for null input would make the solution more robust.
2. **How would you optimize this solution for very large input strings?** 
   Answer: For very large input strings, the current solution is already efficient because it only requires a single pass through the string. However, one potential optimization could involve using a more efficient data type for `ans` if the language supports arbitrary-precision arithmetic, to handle cases where the result exceeds the maximum value that can be represented by an `int`.