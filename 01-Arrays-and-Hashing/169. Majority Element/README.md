<h2><a href="https://leetcode.com/problems/majority-element">169. Majority Element</a></h2>

<p>Given an array <code>nums</code> of size <code>n</code>, return <em>the majority element</em>.</p>

<p>The majority element is the element that appears more than <code>⌊n / 2⌋</code> times. You may assume that the majority element always exists in the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [3,2,3]
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [2,2,1,1,1,2,2]
<strong>Output:</strong> 2
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li>The input is generated such that a majority element will exist in the array.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:</strong> Could you solve the problem in linear time and in <code>O(1)</code> space?

---

# 🛍️ Majority-Element | Explained
The provided code solution is for the LeetCode problem "Majority-Element", which asks to find the majority element in an array (i.e., the element that appears more than n/2 times where n is the size of the array).

## Approach 1 (Optimized Boyer-Moore Voting Algorithm)
### Intuition
Imagine you are at a meeting with a group of people, and you want to determine which person is the most popular (i.e., the majority). One way to do this is to have each person vote for their favorite person, but instead of just counting the votes, we can pair up people who voted for different individuals and have them cancel each other out. The person left standing at the end will be the most popular (i.e., the majority). This approach works because the majority element will always be the one left over after all the pairs have canceled each other out.

### Approach
The algorithm works by essentially maintaining a counter for the majority element. We start with an arbitrary element as the candidate for the majority element and a count of 0. We then iterate through the array, and for each element, we either increment the count if it matches the current candidate or decrement the count if it does not match. If the count ever reaches 0, we switch to the current element as the new candidate. The idea is that the majority element will always be the one left over after all the pairs have canceled each other out.

### Detailed Code Analysis
Let's dive into the code block:
- `int candidate = 0;` and `int count = 0;` are initialized to keep track of the current candidate for the majority element and the count of the candidate, respectively.
- The code then iterates through the input array `nums` using a foreach loop (`for (int num : nums)`).
- Inside the loop, it checks if the count is 0 (`if (count == 0)`). If it is, the current element `num` is set as the new candidate (`candidate = num;`).
- The code then checks if the current element `num` is equal to the current candidate (`if (num == candidate)`). If it is, the count is incremented (`count++`); otherwise, the count is decremented (`count--`).
- After iterating through the entire array, the code returns the candidate (`return candidate;`), which is the majority element.

### Code
```java
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}
```

### Complexity
- Time: The time complexity of this solution is **O(n)**, where n is the number of elements in the input array `nums`, because we only iterate through the array once.
- Space: The space complexity is **O(1)**, as we only use a constant amount of space to store the candidate and the count, regardless of the size of the input array.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions and brief answers are:
- **What if the input array is empty?** The current solution does not handle this case explicitly, so it would be a good idea to add a check at the beginning of the function to return an appropriate value (e.g., throw an exception or return a specific value to indicate an error) if the input array is empty.
- **What if there is no majority element?** The Boyer-Moore Voting Algorithm assumes that a majority element always exists. If this is not the case, a second pass through the array would be needed to confirm that the candidate is indeed the majority element.