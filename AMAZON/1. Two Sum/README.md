<h2><a href="https://leetcode.com/problems/two-sum">1. Two Sum</a></h2>

<p>Given an array of integers <code>nums</code>&nbsp;and an integer <code>target</code>, return <em>indices of the two numbers such that they add up to <code>target</code></em>.</p>

<p>You may assume that each input would have <strong><em>exactly</em> one solution</strong>, and you may not use the <em>same</em> element twice.</p>

<p>You can return the answer in any order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,7,11,15], target = 9
<strong>Output:</strong> [0,1]
<strong>Explanation:</strong> Because nums[0] + nums[1] == 9, we return [0, 1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,2,4], target = 6
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [3,3], target = 6
<strong>Output:</strong> [0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
	<li><strong>Only one valid answer exists.</strong></li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:&nbsp;</strong>Can you come up with an algorithm that is less than <code>O(n<sup>2</sup>)</code><font face="monospace">&nbsp;</font>time complexity?

---

# 🛍️ Two-Sum | Explained

## Approach 1 (Optimized)
### Intuition
The intuition behind this approach is similar to a shopping scenario where you have a list of items with their prices and a target price you want to reach by buying two items. You can create a catalog of the items you've seen so far and their corresponding "prices" (indexes in this case), and for each new item, check if its complement (the price needed to reach the target) is already in your catalog. If it is, you've found two items that add up to the target price. This approach works because it allows for efficient lookup of the complements, leveraging the power of hash tables.

### Approach
The high-level logic flow is as follows:
1. Initialize an empty hash table to store the numbers and their indexes.
2. Iterate over the list of numbers.
3. For each number, calculate its complement (the value needed to reach the target).
4. Check if the complement exists in the hash table.
5. If it does, return the indexes of the current number and its complement.
6. If not, add the current number and its index to the hash table.
7. If the loop completes without finding a pair, return an empty array.

### Detailed Code Analysis
Let's dive into the code:
- `HashMap<Integer,Integer> map=new HashMap<>();`: This line initializes a new hash table where the keys will be the numbers from the input list and the values will be their corresponding indexes. The choice of `HashMap` here is crucial because it allows for constant time complexity lookups, making the overall solution efficient.
- `for(int i=0;i<nums.length;i++)`: This loop iterates over each number in the input array. The variable `i` represents the current index.
- `int complement=target-nums[i];`: For each number, this line calculates its complement, which is the value needed to reach the target when added to the current number.
- `if(map.containsKey(complement))`: This line checks if the calculated complement exists in the hash table. If it does, it means we've found two numbers that add up to the target.
- `return new int[] {map.get(complement),i};`: If the complement is found, this line returns an array containing the index of the complement (retrieved from the hash table) and the index of the current number.
- `map.put(nums[i],i);`: If the complement is not found, the current number and its index are added to the hash table for potential future lookups.
- `return new int[] {};`: If the loop completes without finding a pair of numbers that add up to the target, an empty array is returned.

### Code
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap=Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            
            map.put(nums[i],i);
        }
        return new int[] {};
    }
}
```
Corrected minor syntax errors in code snippet above 

### Complexity
- Time: **O(n)**, where n is the length of the input array `nums`. This is because we perform a constant amount of work for each element in the array, and the hash table operations (insertion and lookup) are also constant time on average.
- Space: **O(n)**, as in the worst case, we might end up storing all elements from the input array into the hash table.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **What if the input array is empty or has only one element?** 
   - In such cases, the solution will correctly return an empty array because it cannot find two numbers that add up to the target.

2. **How does the solution handle duplicate numbers in the input array?** 
   - The solution handles duplicates by storing the index of each number in the hash table. If a duplicate is encountered, its index will be stored, overwriting any previous index for the same number. This means the solution will return the last occurrence of each number in case of duplicates.