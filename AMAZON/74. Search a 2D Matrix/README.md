<h2><a href="https://leetcode.com/problems/search-a-2d-matrix">74. Search a 2D Matrix</a></h2>

<p>You are given an <code>m x n</code> integer matrix <code>matrix</code> with the following two properties:</p>

<ul>
	<li>Each row is sorted in non-decreasing order.</li>
	<li>The first integer of each row is greater than the last integer of the previous row.</li>
</ul>

<p>Given an integer <code>target</code>, return <code>true</code> <em>if</em> <code>target</code> <em>is in</em> <code>matrix</code> <em>or</em> <code>false</code> <em>otherwise</em>.</p>

<p>You must write a solution in <code>O(log(m * n))</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat2.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>-10<sup>4</sup> &lt;= matrix[i][j], target &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Search-a-2D-Matrix | Explained

## Approach 1 (Binary Search on 1D Representation of 2D Matrix)
### Intuition
Imagine you have a 2D matrix where each row is sorted in ascending order from left to right and each column is also sorted in ascending order from top to bottom. However, in this problem, we only know that the rows are sorted, and the first element of each row is greater than the last element of the previous row. This effectively allows us to treat the 2D matrix as a 1D sorted array. Since the matrix can be viewed as a 1D sorted array, we can apply a binary search algorithm to efficiently find a target element. The core idea is to map each element in the 2D matrix to a corresponding index in the 1D array and then perform a binary search on this 1D representation.

### Approach
1. Calculate the total number of elements in the matrix (`m*n`).
2. Initialize two pointers, `left` and `right`, to the start and end of the 1D array representation of the matrix, respectively.
3. Perform a binary search:
   - Calculate the middle index (`mid`) of the current search range.
   - Map the `mid` index to its corresponding row and column indices in the 2D matrix.
   - Compare the element at the calculated row and column indices with the target value.
   - Adjust the search range based on the comparison result (either move the `left` pointer to `mid + 1` if the target is larger, or move the `right` pointer to `mid - 1` if the target is smaller).
4. Repeat the binary search until the target is found or the search range becomes empty.

### Detailed Code Analysis
The code provided directly implements the binary search approach on the 1D representation of the 2D matrix. Here's a breakdown:
- Lines 1-4: Define the class and method for the solution. Calculate the number of rows (`m`) and columns (`n`) in the matrix.
- Line 6-7: Initialize the `left` and `right` pointers for the binary search, representing the start and end indices of the 1D array.
- Line 10: Calculate the `mid` index of the current search range using the formula `left + (right - left) / 2` to avoid integer overflow.
- Lines 12-13: Map the `mid` index to its corresponding row and column indices in the 2D matrix using integer division and modulo operations (`row = mid / n` and `col = mid % n`).
- Line 15: Retrieve the value at the calculated row and column indices (`value = matrix[row][col]`).
- Lines 17-26: Compare the `value` with the target and adjust the search range accordingly.
- Line 28: If the loop ends without finding the target, return `false`.

### Code
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int row = mid / n;
            int col = mid % n;
            
            int value = matrix[row][col];

            if (value == target) {
                return true;
            }
            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
```

### Complexity
- Time: O(log(m*n)), where `m` is the number of rows and `n` is the number of columns in the matrix. This is because we are performing a binary search on the 1D representation of the matrix.
- Space: O(1), as we only use a constant amount of space to store the pointers and variables, regardless of the size of the input matrix.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **What if the matrix is not sorted in any particular order?** In that case, we would need to use a different approach, such as a linear search, which would have a time complexity of O(m*n).
2. **How does the solution change if the matrix is sorted in a different way (e.g., columns are sorted instead of rows)?** If the columns are sorted instead of rows, we would need to adjust the way we map the `mid` index to the row and column indices. Specifically, we would use `row = mid % m` and `col = mid / m`.