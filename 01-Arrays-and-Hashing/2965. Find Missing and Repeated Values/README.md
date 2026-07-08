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

## Approach 1 (Mathematical Formulation)
### Intuition
Imagine you have a grid of numbers from 1 to n^2, but one number is missing and another is repeated. This approach works by using the mathematical properties of the sum of an arithmetic series and the sum of the squares of an arithmetic series. The idea is to calculate the expected sum and sum of squares of the numbers from 1 to n^2, and then use the differences between the expected and actual values to determine the missing and repeated numbers.

### Approach
The algorithm works by iterating over the grid and calculating the differences between the actual sum and the expected sum, as well as the actual sum of squares and the expected sum of squares. It then uses these differences to calculate the missing and repeated numbers.

### Detailed Code Analysis
Let's break down the code:
- The function `FindMissingAndRepeatedValues` takes a 2D grid of integers as input and initializes several variables: `n` to store the size of the grid, `diff` to keep track of the current number being processed, `sumDiff` to store the difference between the actual sum and the expected sum, and `squareSumDiff` to store the difference between the actual sum of squares and the expected sum of squares.
- The code then iterates over each cell in the grid using two nested loops. Inside the loop, it increments the `diff` variable and calculates the difference between the actual value at the current cell (`grid[row][col]`) and the expected value (`diff`). This difference is added to `sumDiff`. Similarly, it calculates the difference between the square of the actual value and the square of the expected value, and adds this to `squareSumDiff`.
- After the loop, the code checks if `sumDiff` is zero. This is likely an attempt to handle the case where the input grid is already filled with the numbers from 1 to n^2, but it's not necessary and can be removed.
- The code then calculates the repeated number (`repeat`) and the missing number (`missing`) using the formulas derived from the mathematical properties of the sum of an arithmetic series and the sum of the squares of an arithmetic series.
- Finally, the function returns an array containing the repeated and missing numbers.

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
            return new int[] {};
        }

        var repeat = (squareSumDiff / sumDiff + sumDiff) / 2;
        var missing = (squareSumDiff / sumDiff - sumDiff) / 2;

        return new int[] { repeat, missing };
    }
}
```

### Complexity
- Time: O(n^2), where n is the size of the grid. This is because the code iterates over each cell in the grid once.
- Space: O(1), not counting the space required for the input and output. This is because the code only uses a constant amount of space to store the variables `n`, `diff`, `sumDiff`, `squareSumDiff`, `repeat`, and `missing`.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. What if the input grid is not a square grid, but a rectangular grid? 
   - In this case, you would need to modify the code to handle the different number of rows and columns. You could do this by passing the number of rows and columns as separate parameters to the function.
2. What if the missing and repeated numbers are at the edges of the range (i.e., 1 or n^2)?
   - The code should still work correctly in this case, because the mathematical formulas used to calculate the missing and repeated numbers are based on the sum and sum of squares of the numbers from 1 to n^2, which include the edges of the range.