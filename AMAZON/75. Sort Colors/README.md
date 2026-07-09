<h2><a href="https://leetcode.com/problems/sort-colors">75. Sort Colors</a></h2>

<p>Given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>

<p>We will use the integers <code>0</code>, <code>1</code>, and <code>2</code> to represent the color red, white, and blue, respectively.</p>

<p>You must solve this problem without using the library's sort function.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,0,2,1,1,0]
<strong>Output:</strong> [0,0,1,1,2,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,0,1]
<strong>Output:</strong> [0,1,2]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 300</code></li>
	<li><code>nums[i]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>


---

# 🛍️ Sort-Colors | Explained

## Approach 1 (Optimized Dutch National Flag Algorithm)
### Intuition
The core idea of this approach is based on the Dutch National Flag algorithm, a variation of the quicksort algorithm that is particularly useful for sorting arrays with only three distinct elements. Imagine you have a flag with three colors: red, white, and blue. You want to sort these colors in a way that all the red colors are on the left, all the white colors are in the middle, and all the blue colors are on the right. This approach works by maintaining three pointers (low, mid, and high) that represent the positions where the next 0 (red), 1 (white), and 2 (blue) should be placed.

### Approach
The algorithm starts by initializing three pointers: `low`, `mid`, and `high`. The `low` pointer is used to track the position where the next 0 should be placed, the `mid` pointer is used to iterate through the array, and the `high` pointer is used to track the position where the next 2 should be placed. The algorithm then enters a loop that continues until the `mid` pointer meets the `high` pointer. Inside the loop, the algorithm checks the value of the current element at the `mid` pointer and swaps it with the element at the `low` pointer if it is 0, or with the element at the `high` pointer if it is 2.

### Detailed Code Analysis
Let's dive into the code:
- The solution starts by initializing three pointers: `low=0`, `mid=0`, and `high=nums.length-1`. These pointers are used to track the positions of the next 0, the current element being processed, and the next 2, respectively.
- The `while` loop (`while (mid <= high)`) continues until the `mid` pointer meets the `high` pointer, ensuring that all elements in the array are processed.
- Inside the loop, the algorithm checks the value of the current element at the `mid` pointer. If the value is 0, it swaps the current element with the element at the `low` pointer using the `swap` function, increments both the `mid` and `low` pointers, and moves on to the next iteration.
- If the value is 1, it simply increments the `mid` pointer to move on to the next element.
- If the value is 2, it swaps the current element with the element at the `high` pointer, decrements the `high` pointer, but does not increment the `mid` pointer to ensure that the swapped element is checked again in the next iteration.

### Code
```java
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
### Complexity
- Time: The algorithm has a time complexity of O(n), where n is the number of elements in the array. This is because each element is visited at most twice: once by the `mid` pointer and possibly once by the `high` pointer if it needs to be swapped.
- Space: The algorithm has a space complexity of O(1), which means it uses a constant amount of space. The only extra space used is for the three pointers and the temporary variable in the `swap` function.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you handle the case where the input array is null or empty?** 
   - You should add a check at the beginning of the `sortColors` method to handle these cases. For example, you could throw an exception for a null input or simply return without doing anything for an empty input.

2. **Can you optimize the algorithm further?**
   - The algorithm is already optimized with a time complexity of O(n) and a space complexity of O(1). However, you could consider using a more efficient swapping method, such as using XOR operations, but this would likely have a negligible impact on performance for most use cases.