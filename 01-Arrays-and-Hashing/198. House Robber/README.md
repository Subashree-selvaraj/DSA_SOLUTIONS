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
Imagine you are a robber trying to steal from a row of houses, but you cannot steal from adjacent houses. The intuition behind this approach is to break down the problem into smaller sub-problems and store the results of these sub-problems to avoid redundant calculations. This is similar to how a robber would plan their heists, considering the maximum amount they can steal up to each house without getting caught.

### Approach
The approach involves using dynamic programming to build up a solution. We start by initializing a dynamic programming array `dp` of size `n`, where `n` is the number of houses. We then fill up this array by iterating through the houses, at each step considering two options: 
1. **Stealing from the current house**: In this case, we add the value of the current house to the maximum amount we could have stolen up to two houses ago (`dp[i-2]`).
2. **Not stealing from the current house**: Here, we simply take the maximum amount we could have stolen up to the previous house (`dp[i-1]`).
We choose the option that gives us the maximum amount.

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
- Time: O(n), where n is the number of houses, because we make a single pass through the array of houses.
- Space: O(n), because we use a dynamic programming array of size n to store the maximum amount that can be stolen up to each house.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem might include:
1. **How would you optimize the space complexity?** The current solution has a space complexity of O(n) due to the dynamic programming array. However, we can observe that each state only depends on the previous two states, so we can reduce the space complexity to O(1) by only keeping track of the last two states.
2. **What if the houses are arranged in a circle?** This variation of the problem requires a different approach, as stealing from the first house would make it impossible to steal from the last house due to them being adjacent. We would need to consider two cases: one where we steal from the first house and one where we do not, and then find the maximum of these two cases.