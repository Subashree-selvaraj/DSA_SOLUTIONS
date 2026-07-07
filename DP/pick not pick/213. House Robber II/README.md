<h2><a href="https://leetcode.com/problems/house-robber-ii">213. House Robber II</a></h2>

<p>You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are <strong>arranged in a circle.</strong> That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and&nbsp;<b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.</p>

<p>Given an integer array <code>nums</code> representing the amount of money of each house, return <em>the maximum amount of money you can rob tonight <strong>without alerting the police</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong> You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3,1]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


---

# 🛍️ House-Robber-II | Explained

## Approach 1 (Dynamic Programming)
### Intuition
Imagine you are a thief trying to rob houses in a circular neighborhood. You can't rob two adjacent houses, and you want to maximize the total amount of money you can steal. In this problem, we use dynamic programming to break down the problem into smaller subproblems and solve them efficiently. The intuition behind this approach is to consider two separate cases: one where we rob the first house and one where we don't. This allows us to avoid the circular constraint and solve the problem using a standard dynamic programming approach.

### Approach
The approach works as follows:
- First, we check if there is only one house. If so, we return the value of that house.
- Then, we use a helper function `robRange` to calculate the maximum amount of money we can steal in a given range of houses.
- In the `robRange` function, we use two variables `prev2` and `prev1` to keep track of the maximum amount of money we can steal up to the previous two houses.
- We iterate through each house in the range, and for each house, we calculate the maximum amount of money we can steal by either robbing the current house or not robbing it.
- We update `prev2` and `prev1` accordingly and return the maximum amount of money we can steal in the range.
- Finally, we call `robRange` twice, once for the range of houses starting from the first house and ending at the second last house, and once for the range of houses starting from the second house and ending at the last house. We return the maximum of these two values.

### Code
```java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        return Math.max(robRange(nums,0,n-2),robRange(nums,1,n-1));
    }
    private int robRange(int[] nums,int start,int end){
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <=end; i++) {

            int pick = nums[i] + prev2;
            int notPick = prev1;

            int curr = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
```

### Complexity
- Time: O(n)
- Space: O(1)

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern are:
- Can you solve the problem if the houses are not in a circle, but rather in a line? 
  - Yes, you can solve this problem using the same dynamic programming approach, but you only need to call `robRange` once for the entire range of houses.
- How would you solve the problem if you can rob the same house multiple times?
  - If you can rob the same house multiple times, the problem becomes much simpler. You can simply return the sum of all houses, because you can rob each house as many times as you want. However, this is not a typical variation of the house robber problem. Typically, you can only rob each house once.