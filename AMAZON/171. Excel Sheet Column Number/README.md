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

## Approach 1 (Optimized)
### Intuition
The given problem can be thought of as converting a number system with base 26 to decimal. The Excel column labels can be considered as a base-26 number system where 'A' represents 1, 'B' represents 2, and so on, up to 'Z' which represents 26. The intuition behind this approach is similar to how we convert a decimal number to another base. However, in this case, we are converting from base-26 to decimal. The conversion process involves multiplying the current result by the base and then adding the value of the current digit.

### Approach
The algorithmic steps for this approach are as follows:
1. Initialize a variable to store the result.
2. Iterate over each character in the input string from left to right.
3. For each character, convert it to its corresponding numerical value ('A' = 1, 'B' = 2, ..., 'Z' = 26).
4. Multiply the current result by 26 and add the numerical value of the current character.
5. Repeat steps 2-4 until all characters have been processed.
6. Return the final result as the decimal equivalent of the input Excel column label.

### Detailed Code Analysis
Let's break down the given code:
- `long ans = 0;` initializes a variable `ans` to store the result. A `long` data type is used to handle large values that may exceed the range of an `int`.
- `for (int i = 0; i < columnTitle.length(); i++)` iterates over each character in the input string.
- `char ch = columnTitle.charAt(i);` retrieves the current character.
- `ans = ans * 26 + (ch - 'A' + 1);` is the core step where the conversion happens. It multiplies the current result `ans` by 26 (the base) and adds the value of the current character. The expression `ch - 'A' + 1` converts the character to its corresponding numerical value. For example, if `ch` is 'A', `ch - 'A'` equals 0, and adding 1 gives 1, which is the numerical value for 'A'.
- `return (int) ans;` returns the final result as an `int`. This is safe because the problem statement guarantees that the result will not exceed the range of an `int`, even though the intermediate calculations might.

### Code
```java
class Solution {
    public int titleToNumber(String columnTitle) {
        long ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            ans = ans * 26 + (ch - 'A' + 1);
        }
        return (int) ans;
    }
}
```

### Complexity
- Time: The time complexity is O(n), where n is the length of the input string `columnTitle`. This is because we are iterating over each character in the string once.
- Space: The space complexity is O(1), which means the space required does not change with the size of the input string. This is because we are using a constant amount of space to store our variables, regardless of the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you handle the case where the input string is empty or null?**  
   You should add a check at the beginning of the method to return an appropriate value (e.g., 0 or throw an exception) for these cases, as they are not valid Excel column labels.

2. **Can you extend this solution to handle Excel column labels that are not limited to 26 characters (e.g., 'ZZZ' or longer)?**  
   The given solution already handles such cases. It treats the Excel column label as a base-26 number and converts it to decimal, which inherently supports labels of any length, not just limited to 'Z' or 'ZZ'.