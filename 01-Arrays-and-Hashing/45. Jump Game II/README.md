<h2><a href="https://leetcode.com/problems/jump-game-ii">45. Jump Game II</a></h2>

<p>You are given a <strong>0-indexed</strong> array of integers <code>nums</code> of length <code>n</code>. You are initially positioned at&nbsp;index 0.</p>

<p>Each element <code>nums[i]</code> represents the maximum length of a forward jump from index <code>i</code>. In other words, if you are at index <code>i</code>, you can jump to any index <code>(i + j)</code>&nbsp;where:</p>

<ul>
	<li><code>0 &lt;= j &lt;= nums[i]</code> and</li>
	<li><code>i + j &lt; n</code></li>
</ul>

<p>Return <em>the minimum number of jumps to reach index </em><code>n - 1</code>. The test cases are generated such that you can reach index&nbsp;<code>n - 1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,1,1,4]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,0,1,4]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
	<li>It's guaranteed that you can reach <code>nums[n - 1]</code>.</li>
</ul>


---

# 🛍️ Jump-Game-II | Explained

Unfortunately, the code solution to the LeetCode problem "Jump-Game-II" is missing. However, I can provide a general explanation of the problem and its common approaches.


## Approach 1 (Greedy)
### Intuition
Imagine you are playing a game where you can jump a certain number of steps from your current position. The goal is to reach the end of the game in the minimum number of jumps. A greedy approach would be to always jump to the farthest reachable position.
### Approach
1. Initialize the maximum reachable position and the number of jumps.
2. Iterate through the array and update the maximum reachable position.
3. When the current position exceeds the maximum reachable position, increment the number of jumps and update the maximum reachable position.
4. Repeat steps 2-3 until the end of the array is reached.
### Code
```python
def jump(nums):
    if len(nums) <= 1:
        return 0
    max_reach = nums[0]
    step = nums[0]
    jumps = 1
    for i in range(1, len(nums)):
        if i == len(nums) - 1:
            return jumps
        max_reach = max(max_reach, i + nums[i])
        step -= 1
        if step == 0:
            jumps += 1
            if i >= max_reach:
                return -1
            step = max_reach - i
    return jumps
```
### Complexity
- Time: O(n), where n is the length of the input array.
- Space: O(1), as only a constant amount of space is used.

## Approach 2 (BFS)
### Intuition
This approach involves using a breadth-first search (BFS) to explore all possible jumps from the current position.
### Approach
1. Initialize a queue with the starting position and the number of jumps.
2. Dequeue the current position and explore all possible jumps.
3. If a jump reaches the end of the array, return the number of jumps.
4. If a jump reaches a new position, mark it as visited and enqueue it with the updated number of jumps.
5. Repeat steps 2-4 until the end of the array is reached or all possible jumps have been explored.
### Code
```python
from collections import deque

def jump(nums):
    if len(nums) <= 1:
        return 0
    queue = deque([(0, 0)])
    visited = set([0])
    while queue:
        pos, jumps = queue.popleft()
        for i in range(1, nums[pos] + 1):
            new_pos = pos + i
            if new_pos >= len(nums) - 1:
                return jumps + 1
            if new_pos not in visited:
                queue.append((new_pos, jumps + 1))
                visited.add(new_pos)
    return -1
```
### Complexity
- Time: O(n^2), where n is the length of the input array.
- Space: O(n), as a queue and a set are used to keep track of visited positions.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. What if the input array is very large? How can we optimize the solution to handle such cases?
Answer: We can use a more efficient algorithm, such as the greedy approach, which has a time complexity of O(n).
2. What if the input array contains negative numbers? How can we modify the solution to handle such cases?
Answer: We can modify the solution to handle negative numbers by using a more robust algorithm, such as the BFS approach, and keeping track of visited positions to avoid infinite loops.