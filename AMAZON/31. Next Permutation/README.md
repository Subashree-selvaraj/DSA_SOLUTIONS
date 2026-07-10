<h2><a href="https://leetcode.com/problems/next-permutation">31. Next Permutation</a></h2>

<p>A <strong>permutation</strong> of an array of integers is an arrangement of its members into a sequence or linear order.</p>

<ul>
	<li>For example, for <code>arr = [1,2,3]</code>, the following are all the permutations of <code>arr</code>: <code>[1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1]</code>.</li>
</ul>

<p>The <strong>next permutation</strong> of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the <strong>next permutation</strong> of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).</p>

<ul>
	<li>For example, the next permutation of <code>arr = [1,2,3]</code> is <code>[1,3,2]</code>.</li>
	<li>Similarly, the next permutation of <code>arr = [2,3,1]</code> is <code>[3,1,2]</code>.</li>
	<li>While the next permutation of <code>arr = [3,2,1]</code> is <code>[1,2,3]</code> because <code>[3,2,1]</code> does not have a lexicographical larger rearrangement.</li>
</ul>

<p>Given an array of integers <code>nums</code>, <em>find the next permutation of</em> <code>nums</code>.</p>

<p>The replacement must be <strong><a href="http://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in place</a></strong> and use only constant extra memory.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [1,3,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,2,1]
<strong>Output:</strong> [1,2,3]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [1,1,5]
<strong>Output:</strong> [1,5,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
</ul>


---

# 🛍️ Next-Permutation | Explained

## Approach 1: Two-Pointer Technique with Reversal
### Intuition
Imagine you are arranging a set of numbers in a specific order, and you want to find the next possible arrangement that is larger than the current one. The key idea is to identify the first pair of numbers from the right that are in increasing order. This is because if all numbers are in descending order, there is no larger arrangement possible. Think of it like a clock where the hands are pointing to the numbers in the array. To move to the next time (arrangement), you need to find the first pair where the hour hand is smaller than the minute hand. In this case, it's the first pair of numbers from the right where the left number is smaller than the right one.
### Approach
1. Start from the second last element and move to the left until you find a pair of numbers where the left number is smaller than the right one. This is the pivot point.
2. If a pivot point is found, then from the rightmost element, move to the left and find the first number that is greater than the pivot point.
3. Swap the pivot point and the number found in step 2.
4. Reverse the elements after the pivot point.

### Detailed Code Analysis
The given code starts by initializing a variable `i` to the second last index of the array. It then enters a while loop that continues as long as `i` is greater than or equal to 0 and the current element is greater than or equal to the next element. This effectively finds the first pair of numbers from the right that are in increasing order.
```java
int i = nums.length - 2;
while (i >= 0 && nums[i] >= nums[i + 1]) {
    i--;
}
```
If `i` is still greater than or equal to 0, it means a pivot point is found. The code then initializes a variable `j` to the last index of the array and enters another while loop that continues as long as `j` is greater than or equal to 0 and the current element is less than or equal to the pivot point. This finds the first number from the right that is greater than the pivot point.
```java
if (i >= 0) {
    int j = nums.length - 1;
    while (nums[j] <= nums[i]) {
        j--;
    }
}
```
The pivot point and the number found are then swapped using the `swap` function.
```java
swap(nums, i, j);
```
Finally, the elements after the pivot point are reversed using the `reverse` function.
```java
reverse(nums, i + 1, nums.length - 1);
```
The `swap` function simply swaps the elements at the given indices, and the `reverse` function reverses the elements in the given range by repeatedly swapping the elements at the start and end of the range and moving towards the center.

### Code
```java
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}
```

### Complexity
- Time: The time complexity of this solution is O(n), where n is the number of elements in the array. This is because in the worst-case scenario, we are potentially scanning the entire array to find the pivot point and the number to swap with, and then reversing the elements after the pivot point.
- Space: The space complexity is O(1), as we are only using a constant amount of space to store the indices and temporary values, regardless of the size of the input array.

## 🕵️‍♂️ Follow-up Questions (Optional)
- What if the input array is already the last permutation? In this case, the algorithm will simply reverse the array, effectively returning to the first permutation.
- How can you optimize the algorithm if the input array is very large? The current algorithm is already optimized for large inputs, as it only scans the array once to find the pivot point and the number to swap with, and then reverses the elements after the pivot point. However, if the input array is extremely large, you may want to consider using a more complex data structure, such as a balanced binary search tree, to store the elements and efficiently find the next permutation.