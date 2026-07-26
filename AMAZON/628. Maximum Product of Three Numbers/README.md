<h2><a href="https://leetcode.com/problems/maximum-product-of-three-numbers">628. Maximum Product of Three Numbers</a></h2>

<p>Given an integer array <code>nums</code>, <em>find three numbers whose product is maximum and return the maximum product</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 6
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> 24
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [-1,-2,-3]
<strong>Output:</strong> -6
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;=&nbsp;10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


---

# 🛍️ Maximum-Product-of-Three-Numbers | Explained

## Approach 1: Single-Pass Scanning with Tracking of Maximum and Minimum Values
### Intuition
The core idea behind this approach is to understand that the maximum product of three numbers can be either the product of the three largest numbers or the product of the two smallest (most negative) numbers and the largest number. This is because two negative numbers multiplied together yield a positive number, and when multiplied by the largest number, can result in a significant product. This approach works by maintaining a running track of the three largest numbers and the two smallest numbers as we scan through the input array.

### Algorithm Visualized
```mermaid
graph LR
    A[Start Scanning] --> B[Initialize max and min variables]
    B --> C[Scan Array]
    C --> D{Update max values (a, b, c) and min values (x, y)}
    D --> E[Continue scanning until end of array]
    E --> F{Calculate and return max product}
    F --> G[End]
```

### Approach
This algorithm starts by initializing variables to keep track of the maximum and minimum values encountered during the scan of the input array. As it scans through the array, it updates these variables to reflect the current maximum and minimum values seen so far. Once the scan is complete, it calculates the product of the three maximum values and the product of the two minimum values with the maximum value, returning the larger of these two products.

### Detailed Code Analysis
The given code initializes `a`, `b`, and `c` to keep track of the three maximum numbers seen so far and `x` and `y` to track the two minimum numbers. It starts with `a = -1001`, `b = a`, `c = b`, and `x = 1001`, `y = x`. These initializations ensure that any real number in the array will be greater than `-1001` and less than `1001`, allowing the first iteration to correctly update these tracking variables.

Inside the for loop, `c = max(c, min(b, n))`, `b = max(b, min(a, n))`, and `a = max(a, n)` update the maximum values. The `min` function ensures that if `n` is greater than `a` but less than `b`, `b` and `c` are updated correctly to maintain the order of the maximum values. 

For the minimum values, `y = min(y, max(x, n))` and `x = min(x, n)` ensure that `x` always holds the smallest number seen so far, and `y` holds the second smallest.

After scanning the entire array, `return max(a * b * c, a * x * y)` calculates the maximum product between the product of the three largest numbers and the product of the largest number with the two smallest numbers.

### Code
```cpp
class Solution {
public:
    int maximumProduct(vector<int>& A) {
        int a = -1001, b = a, c = b;    // max 3
        int x = 1001, y = x;           // min 2

        for (auto& n : A) {
            c = max(c, min(b, n));     // Shift to 3rd max
            b = max(b, min(a, n));     // Shift to 2nd max
            a = max(a, n);              // Update 1st max

            y = min(y, max(x, n));     // Shift to 2nd min
            x = min(x, n);              // Update 1st min
        }

        return max(a * b * c, a * x * y);
    }
};
```

### Complexity
- **Time:** O(n), where n is the number of elements in the input array. This is because we are scanning the array once.
- **Space:** O(1), as we are using a constant amount of space to store the maximum and minimum values, regardless of the size of the input array.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. How would you handle the case where the input array has less than three elements?
   - The function as it stands would not work correctly for arrays with fewer than three elements. To handle this, you could add a check at the beginning of the function to return an error or a specific value (like 0 or -1) when the array has fewer than three elements.

2. Can this approach be generalized to find the maximum product of k numbers in an array?
   - Yes, the approach can be generalized. Instead of keeping track of just the three maximum and two minimum numbers, you would need to keep track of the k maximum numbers and potentially the two minimum numbers if k is 3 or more, using a similar update strategy. For k greater than 3, the comparison for the minimums might not be necessary if all numbers are positive or if the focus is solely on the maximum product achievable with k numbers.