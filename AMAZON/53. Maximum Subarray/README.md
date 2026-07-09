<h2><a href="https://leetcode.com/problems/maximum-subarray">53. Maximum Subarray</a></h2>

<p>Given an integer array <code>nums</code>, find the <span data-keyword="subarray-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1o_" data-state="closed" class="">subarray</button></span> with the largest sum, and return <em>its sum</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The subarray [4,-1,2,1] has the largest sum 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The subarray [1] has the largest sum 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [5,4,-1,7,8]
<strong>Output:</strong> 23
<strong>Explanation:</strong> The subarray [5,4,-1,7,8] has the largest sum 23.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> If you have figured out the <code>O(n)</code> solution, try coding another solution using the <strong>divide and conquer</strong> approach, which is more subtle.</p>


---

# 🛍️ Maximum-Subarray | Explained

## Approach 1 (Kadane's Algorithm)
### Intuition
Imagine you're on a hike, and you want to find the longest stretch of trail where the elevation gain is the greatest. You can think of each step as either adding to your current elevation gain or starting over from the current point. If your current elevation gain is negative, it's better to start over. This intuition is the core of Kadane's algorithm, which is used to solve the Maximum Subarray problem. It works by maintaining a running sum of the current subarray and resetting it whenever it becomes negative.

### Approach
The algorithm starts by initializing two variables: one to keep track of the maximum sum found so far (`maxSum`), and another to keep track of the current sum (`currentSum`). It then iterates through the array, at each step adding the current element to `currentSum`. If `currentSum` becomes greater than `maxSum`, it updates `maxSum`. If `currentSum` becomes negative, it resets `currentSum` to 0, effectively starting a new subarray. This process continues until all elements have been processed.

### Detailed Code Analysis
Let's break down the code:
- `int currentSum=0;` initializes the current sum to 0.
- `int maxSum=Integer.MIN_VALUE;` initializes the maximum sum found so far to the smallest possible integer value. This ensures that any sum will be greater than `Integer.MIN_VALUE`.
- The `for (int x:nums)` loop iterates through each element `x` in the input array `nums`.
- Inside the loop, `currentSum+=x;` adds the current element to the current sum.
- `maxSum=Math.max(maxSum,currentSum);` updates `maxSum` if `currentSum` is greater.
- The `if (currentSum<0)` condition checks if the current sum is negative. If it is, `currentSum=0;` resets the current sum to 0, effectively starting a new subarray.
- Finally, `return maxSum;` returns the maximum sum found.

### Code
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        for (int x:nums){
            currentSum+=x;
            maxSum=Math.max(maxSum,currentSum);
            if (currentSum<0){
                currentSum=0;
            }
        }
        return maxSum;
    }
}
```
### Complexity
- Time: O(n), where n is the number of elements in the input array, because we're making a single pass through the array.
- Space: O(1), because we're using a constant amount of space to store our variables (`currentSum` and `maxSum`), regardless of the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **What if the input array is empty?** In this implementation, `maxSum` would remain `Integer.MIN_VALUE`, which is the correct result for an empty array since there's no subarray to sum. However, depending on the problem's requirements, you might need to handle this case differently.
2. **How would you find the actual subarray that gives the maximum sum, not just the sum itself?** To do this, you'd need to keep track of the start and end indices of the subarray that gives the current `maxSum`. You could do this by introducing additional variables to track these indices whenever `maxSum` is updated.