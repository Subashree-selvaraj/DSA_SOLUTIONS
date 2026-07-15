<h2><a href="https://leetcode.com/problems/find-pivot-index">724. Find Pivot Index</a></h2>

<p>Given an array of integers <code>nums</code>, calculate the <strong>pivot index</strong> of this array.</p>

<p>The <strong>pivot index</strong> is the index where the sum of all the numbers <strong>strictly</strong> to the left of the index is equal to the sum of all the numbers <strong>strictly</strong> to the index's right.</p>

<p>If the index is on the left edge of the array, then the left sum is <code>0</code> because there are no elements to the left. This also applies to the right edge of the array.</p>

<p>Return <em>the <strong>leftmost pivot index</strong></em>. If no such index exists, return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,7,3,6,5,6]
<strong>Output:</strong> 3
<strong>Explanation:</strong>
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> -1
<strong>Explanation:</strong>
There is no index that satisfies the conditions in the problem statement.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [2,1,-1]
<strong>Output:</strong> 0
<strong>Explanation:</strong>
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as&nbsp;1991:&nbsp;<a href="https://leetcode.com/problems/find-the-middle-index-in-array/" target="_blank">https://leetcode.com/problems/find-the-middle-index-in-array/</a></p>


---

# 🛍️ Find-Pivot-Index | Explained

## Approach 1 (e.g., Prefix Sum Approach)
### Intuition
The core idea behind this approach is to use the concept of prefix sums to efficiently calculate the sum of elements to the left and right of each index. The prefix sum array is similar to a running total, where each element at index `i` represents the sum of all elements from index `0` to `i`. This approach works because it allows us to calculate the sum of elements to the left and right of each index in constant time, making the overall time complexity linear. Think of it like a financial ledger where you keep a running total of your expenses, making it easy to calculate the total expenses up to a certain point.

### Approach
The algorithm can be broken down into the following steps:
1. Calculate the prefix sum array for the input array.
2. Iterate through each index in the input array.
3. For each index, calculate the sum of elements to the left and right.
4. Check if the left sum equals the right sum. If it does, return the current index.
5. If no such index is found, return -1.

### Detailed Code Analysis
Let's take a closer look at the code:
- `int n = nums.length;` This line initializes a variable `n` to store the length of the input array `nums`.
- `int[] prefix = new int[n];` This line creates a new array `prefix` of the same length as the input array `nums`. This array will store the prefix sums.
- `prefix[0] = nums[0];` This line initializes the first element of the `prefix` array to the first element of the `nums` array. This is because the prefix sum at index `0` is simply the value at index `0`.
- The `for` loop from line 8 to 10 calculates the prefix sums for the rest of the array. `prefix[i] = prefix[i - 1] + nums[i];` This line calculates the prefix sum at index `i` by adding the current element `nums[i]` to the previous prefix sum `prefix[i - 1]`.
- `int total = prefix[n - 1];` This line calculates the total sum of the input array by taking the last element of the `prefix` array.
- The second `for` loop from line 14 to 21 iterates through each index in the input array and checks if it's a pivot index.
- `int leftSum = (i == 0) ? 0 : prefix[i - 1];` This line calculates the sum of elements to the left of the current index. If the current index is `0`, the left sum is `0`.
- `int rightSum = total - prefix[i];` This line calculates the sum of elements to the right of the current index by subtracting the current prefix sum from the total sum.
- The `if` statement from line 19 to 20 checks if the left sum equals the right sum. If it does, the function returns the current index.

### Code
```java
int n = nums.length;
int[] prefix = new int[n];
prefix[0] = nums[0];

for (int i = 1; i < n; i++) {
    prefix[i] = prefix[i - 1] + nums[i];
}

int total = prefix[n - 1];

for (int i = 0; i < n; i++) {
    int leftSum = (i == 0) ? 0 : prefix[i - 1];
    int rightSum = total - prefix[i];

    if (leftSum == rightSum)
        return i;
}
return -1;
```

### Complexity
- Time: The time complexity is O(n), where n is the length of the input array. This is because we're doing two passes through the array: one to calculate the prefix sums and another to find the pivot index.
- Space: The space complexity is O(n), where n is the length of the input array. This is because we're using an additional array of the same length to store the prefix sums.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern could be:
1. What if the input array is empty? How would you handle this edge case?
   - The current implementation would return -1 for an empty array, which is a reasonable behavior. However, you could also consider throwing an exception or returning a specific value to indicate that the input is invalid.
2. Can you optimize the space complexity of the solution?
   - Yes, it's possible to optimize the space complexity to O(1) by calculating the total sum first and then iterating through the array, keeping track of the left sum and updating the right sum accordingly. This would eliminate the need for the prefix sum array.