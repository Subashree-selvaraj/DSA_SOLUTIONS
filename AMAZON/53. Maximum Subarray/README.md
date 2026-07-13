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
Imagine you're on a hike, and your goal is to find the most scenic part of the trail with the best views. However, the trail has ups and downs, representing positive and negative elevation changes. You want to find the section of the trail with the maximum cumulative elevation gain. If the current section has a negative cumulative elevation change, it's better to start fresh from the next point, as the negative change would only drag down the overall gain. This approach works by maintaining a running sum of the elevations (or subarray elements) and resetting it whenever it becomes negative.

### Approach
The algorithm, known as Kadane's Algorithm, works as follows:
1. Initialize two variables, `currentSum` and `maxSum`, to keep track of the current subarray sum and the maximum sum found so far, respectively.
2. Iterate through the array. For each element, add it to `currentSum`.
3. Update `maxSum` if `currentSum` is greater.
4. If `currentSum` becomes negative, reset it to 0, as a negative sum has no benefit in finding the maximum subarray sum.

### Detailed Code Analysis
Let's dive into the provided code:
- `int currentSum=0;` : Initializes the running sum of the subarray to 0.
- `int maxSum=Integer.MIN_VALUE;` : Initializes the maximum sum found so far to the smallest possible integer value, ensuring that any sum will be greater than this initial value.
- The `for` loop iterates through each element `x` in the input array `nums`.
- `currentSum+=x;` : Adds the current element to the running sum.
- `maxSum=Math.max(maxSum,currentSum);` : Updates `maxSum` if the current running sum is greater.
- `if (currentSum<0) { currentSum=0; }` : Resets the running sum to 0 if it becomes negative, effectively starting a new subarray from the next element.

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
- Time: O(n), where n is the number of elements in the input array. This is because we perform a single pass through the array.
- Space: O(1), as we use a constant amount of space to store the variables `currentSum` and `maxSum`, regardless of the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **What if the input array is empty?** The code will return `Integer.MIN_VALUE`, indicating that no maximum subarray sum was found. To handle this case, you could add a check at the beginning of the function to return 0 (or throw an exception, depending on the requirements).
2. **Can this algorithm be applied to other similar problems?** Yes, variations of Kadane's Algorithm can be used to solve other problems involving cumulative sums or maximum/minimum subarray sums with additional constraints.