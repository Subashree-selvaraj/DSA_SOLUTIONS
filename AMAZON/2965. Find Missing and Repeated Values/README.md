<h2><a href="https://leetcode.com/problems/find-missing-and-repeated-values">2965. Find Missing and Repeated Values</a></h2>

<p>You are given a <strong>0-indexed</strong> 2D integer matrix <code><font face="monospace">grid</font></code> of size <code>n * n</code> with values in the range <code>[1, n<sup>2</sup>]</code>. Each integer appears <strong>exactly once</strong> except <code>a</code> which appears <strong>twice</strong> and <code>b</code> which is <strong>missing</strong>. The task is to find the repeating and missing numbers <code>a</code> and <code>b</code>.</p>

<p>Return <em>a <strong>0-indexed </strong>integer array </em><code>ans</code><em> of size </em><code>2</code><em> where </em><code>ans[0]</code><em> equals to </em><code>a</code><em> and </em><code>ans[1]</code><em> equals to </em><code>b</code><em>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> grid = [[1,3],[2,2]]
<strong>Output:</strong> [2,4]
<strong>Explanation:</strong> Number 2 is repeated and number 4 is missing so the answer is [2,4].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[9,1,7],[8,9,2],[3,4,6]]
<strong>Output:</strong> [9,5]
<strong>Explanation:</strong> Number 9 is repeated and number 5 is missing so the answer is [9,5].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n == grid.length == grid[i].length &lt;= 50</code></li>
	<li><code>1 &lt;= grid[i][j] &lt;= n * n</code></li>
	<li>For all <code>x</code> that <code>1 &lt;= x &lt;= n * n</code> there is exactly one <code>x</code> that is not equal to any of the grid members.</li>
	<li>For all <code>x</code> that <code>1 &lt;= x &lt;= n * n</code> there is exactly one <code>x</code> that is equal to exactly two of the grid members.</li>
	<li>For all <code>x</code> that <code>1 &lt;= x &lt;= n * n</code> except two of them there is exactly one pair of <code>i, j</code> that <code>0 &lt;= i, j &lt;= n - 1</code> and <code>grid[i][j] == x</code>.</li>
</ul>


---

# 🛍️ Find-Missing-and-Repeated-Values | Explained

## Approach 1 (Math Optimization)
### Intuition
📊 This approach works by using mathematical properties to identify the missing and repeated values in the grid. It leverages the fact that the sum of all numbers from 1 to n is given by the formula `n * (n + 1) / 2`, and the sum of squares of all numbers from 1 to n is given by the formula `n * (n + 1) * (2n + 1) / 6`. By comparing the actual sum and sum of squares of the grid elements with these formulas, we can calculate the missing and repeated values.

### Approach
🔍 The algorithm starts by initializing variables `n`, `diff`, `sumDiff`, and `squareSumDiff` to keep track of the number of elements, the difference between the actual sum and the expected sum, and the difference between the actual sum of squares and the expected sum of squares. It then iterates over the grid to calculate `sumDiff` and `squareSumDiff`. Finally, it uses these values to calculate the repeated and missing values.

### Detailed Code Analysis
🔎 Let's break down the code line by line:
- `var n = grid.Length;`: This line initializes the variable `n` with the number of rows (or columns) in the grid, which represents the number of elements in the sequence.
- `var diff = 0;`: This line initializes the variable `diff` to keep track of the current element in the sequence. However, it seems to be unused in the provided code.
- `var sumDiff = 0;` and `var squareSumDiff = 0;`: These lines initialize variables to store the differences between the actual sum (and sum of squares) and the expected sum (and sum of squares).
- The nested for loops iterate over each element in the grid, and for each element, `sumDiff` is updated by subtracting the current element from the expected value (`diff++`), and `squareSumDiff` is updated by subtracting the square of the current element from the square of the expected value.
- `if (sumDiff == 0)`: This condition checks if the actual sum of the grid elements equals the expected sum. However, since `sumDiff` is calculated as the difference between the actual and expected sums, this condition should not be true if there are missing or repeated values.
- `var repeat = (squareSumDiff / sumDiff + sumDiff) / 2;` and `var missing = (squareSumDiff / sumDiff - sumDiff) / 2;`: These lines calculate the repeated and missing values using the formulas derived from the mathematical properties of the sum and sum of squares.

### Code
```csharp
public class Solution {
    public int[] FindMissingAndRepeatedValues(int[][] grid) {
        var n = grid.Length;
        var diff = 0;
        var sumDiff = 0;
        var squareSumDiff = 0;
        for (var row = 0; row < n; row++)
        {
            for (var col = 0; col < n; col++)
            {
                diff++;
                sumDiff += grid[row][col] - diff;
                squareSumDiff += grid[row][col] * grid[row][col] - diff * diff;
            }
        }

        if (sumDiff == 0)
        {
            return new int[0];
        }

        var repeat = (squareSumDiff / sumDiff + sumDiff) / 2;
        var missing = (squareSumDiff / sumDiff - sumDiff) / 2;

        return new int[] { repeat, missing };
    }
}
```

### Complexity
- Time: O(n^2), where n is the number of rows (or columns) in the grid, since we are iterating over each element in the grid once.
- Space: O(1), since we are only using a constant amount of space to store the variables `n`, `diff`, `sumDiff`, `squareSumDiff`, `repeat`, and `missing`, regardless of the size of the input grid.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. What are some potential issues with the given code if the grid contains non-integer or negative values?
 Answer: The given code assumes that the grid contains only positive integers. If the grid contains non-integer or negative values, the mathematical formulas used to calculate the missing and repeated values may not work correctly, leading to incorrect results.
2. How can you modify the code to handle cases where there are multiple missing or repeated values?
 Answer: To handle cases with multiple missing or repeated values, a different approach would be needed, such as using a hash set to keep track of the unique values in the grid, and then iterating over the expected range of values to find the missing and repeated values.