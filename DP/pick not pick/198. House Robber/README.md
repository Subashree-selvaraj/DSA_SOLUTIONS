<h2><a href="https://leetcode.com/problems/house-robber">198. House Robber</a></h2>

<p>You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and <b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.</p>

<p>Given an integer array <code>nums</code> representing the amount of money of each house, return <em>the maximum amount of money you can rob tonight <b>without alerting the police</b></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3,1]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,7,9,3,1]
<strong>Output:</strong> 12
<strong>Explanation:</strong> Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 400</code></li>
</ul>


---

# 🛍️ House-Robber | Explained

## Approach 1 (Dynamic Programming)
### Intuition
Imagine you are a thief trying to rob houses in a row. The goal is to maximize the total amount stolen without robbing adjacent houses. This problem can be broken down into smaller sub-problems, where for each house, you have two options: either rob it or don't. The decision to rob a house depends on the maximum amount you can get from the previous houses. This intuition leads us to use dynamic programming to solve the problem.

### Approach
The approach involves creating a dynamic programming (DP) array, `dp`, where `dp[i]` represents the maximum amount that can be stolen up to the `i-th` house. We start by initializing the first two elements of the DP array: `dp[0]` is the amount in the first house, and `dp[1]` is the maximum of the amounts in the first and second houses. Then, for each house from the third house onwards, we have two options: either rob the current house (in which case we add its amount to `dp[i-2]`) or don't rob it (in which case we take `dp[i-1]`). We choose the option that gives us the maximum amount.

### Code
```java
int n = nums.length;
if (n == 1) {
    return nums[0];
}
int[] dp = new int[n];
dp[0] = nums[0];
dp[1] = Math.max(nums[1], nums[0]);
for (int i = 2; i < n; i++) {
    int pick = nums[i] + dp[i - 2];
    int notPick = dp[i - 1];
    dp[i] = Math.max(pick, notPick);
}
return dp[n - 1];
```

### Complexity
- Time: O(n), where n is the number of houses. We are iterating through the array once.
- Space: O(n), as we are using an array of size n to store the DP values.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem include:
1. **What if the houses are arranged in a circle?** In this case, the problem becomes more complex because we have to consider the constraint that we cannot rob the first and last houses simultaneously. We would need to solve the problem for two cases: one where we rob the first house and one where we don't, and then return the maximum of these two cases.
2. **How would you optimize the space complexity?** We can optimize the space complexity by observing that we only need to keep track of the last two houses' maximum amounts. Therefore, we can use two variables instead of an array of size n, reducing the space complexity to O(1).