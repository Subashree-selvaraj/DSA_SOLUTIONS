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
The House-Robber problem can be solved using dynamic programming, which is an approach that breaks down complex problems into simpler sub-problems. The core idea here is to think of the problem as a series of decisions: at each house, you have to decide whether to rob it or not. The decision to rob or not rob a house depends on the maximum amount you can get from the previous houses. The intuition is similar to a real-world scenario where you're trying to maximize your earnings by making optimal decisions at each step, considering the constraints (in this case, not being able to rob adjacent houses).

### Approach
The approach involves initializing variables to keep track of the maximum amount that can be robbed up to the current house. We start by checking the base case (if there's only one house), and then we initialize `prev2` and `prev1` to keep track of the maximum amount we can get by not robbing the current house and the maximum amount we can get including the current house, respectively. We then iterate through the rest of the houses, at each step calculating the maximum amount we can get by either robbing the current house (`pick`) or not robbing it (`notPick`), and update `prev2` and `prev1` accordingly.

### Code
```java
int n = nums.length;
if (n == 1)
    return nums[0];

int prev2 = nums[0];
int prev1 = Math.max(nums[0], nums[1]);

for (int i = 2; i < n; i++) {
    int pick = nums[i] + prev2;
    int notPick = prev1;
    int curr = Math.max(pick, notPick);
    prev2 = prev1;
    prev1 = curr;
}
return prev1;
```

### Complexity
- Time: O(n), where n is the number of houses. This is because we make a single pass through the array of houses.
- Space: O(1), since we only use a constant amount of space to store our variables, regardless of the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern could include:
1. **What if the houses are arranged in a circle?** In this case, the problem becomes slightly more complex because robbing the first house would limit your ability to rob the last house. The solution involves considering two cases: one where the first house is robbed and one where it is not.
2. **How would you handle an array with negative numbers or zeros?** The dynamic programming approach can handle negative numbers and zeros without any adjustments, as the `Math.max` function will correctly choose the maximum value between the current maximum and the new calculated value, regardless of whether the new value is negative or zero.