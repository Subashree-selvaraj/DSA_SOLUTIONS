<h2><a href="https://leetcode.com/problems/merge-sorted-array">88. Merge Sorted Array</a></h2>

<p>You are given two integer arrays <code>nums1</code> and <code>nums2</code>, sorted in <strong>non-decreasing order</strong>, and two integers <code>m</code> and <code>n</code>, representing the number of elements in <code>nums1</code> and <code>nums2</code> respectively.</p>

<p><strong>Merge</strong> <code>nums1</code> and <code>nums2</code> into a single array sorted in <strong>non-decreasing order</strong>.</p>

<p>The final sorted array should not be returned by the function, but instead be <em>stored inside the array </em><code>nums1</code>. To accommodate this, <code>nums1</code> has a length of <code>m + n</code>, where the first <code>m</code> elements denote the elements that should be merged, and the last <code>n</code> elements are set to <code>0</code> and should be ignored. <code>nums2</code> has a length of <code>n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
<strong>Output:</strong> [1,2,2,3,5,6]
<strong>Explanation:</strong> The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [<u>1</u>,<u>2</u>,2,<u>3</u>,5,6] with the underlined elements coming from nums1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [1], m = 1, nums2 = [], n = 0
<strong>Output:</strong> [1]
<strong>Explanation:</strong> The arrays we are merging are [1] and [].
The result of the merge is [1].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums1 = [0], m = 0, nums2 = [1], n = 1
<strong>Output:</strong> [1]
<strong>Explanation:</strong> The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == m + n</code></li>
	<li><code>nums2.length == n</code></li>
	<li><code>0 &lt;= m, n &lt;= 200</code></li>
	<li><code>1 &lt;= m + n &lt;= 200</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums1[i], nums2[j] &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up: </strong>Can you come up with an algorithm that runs in <code>O(m + n)</code> time?</p>


---

# 🛍️ Merge-Sorted-Array | Explained

## Approach 1 (Optimized Two-Pointer Technique)
### Intuition
Imagine you're a librarian tasked with merging two sorted bookshelves into one. You start by comparing the largest book from the first shelf with the largest book from the second shelf. You place the larger book on the new, combined shelf and then move to the next largest book. This process continues until you've placed all books from both shelves onto the new shelf in sorted order. This approach works because we're taking advantage of the fact that both input arrays are already sorted, allowing us to compare elements from the end of each array and build the merged array from the end.

### Approach
The algorithm uses a two-pointer technique, where two pointers, `i` and `j`, start at the end of the first and second arrays, respectively. A third pointer, `k`, starts at the end of the first array (which has enough space to hold all elements from both arrays). The algorithm then enters a loop where it compares the current elements at `nums1[i]` and `nums2[j]`. If `nums1[i]` is greater, it places this element at `nums1[k]` and decrements `i` and `k`. If `nums2[j]` is greater (or if `i` is out of bounds), it places `nums2[j]` at `nums1[k]` and decrements `j` and `k`. This process continues until all elements from the second array have been merged into the first array.

### Detailed Code Analysis
Let's break down the code:
- Line 3: `int i = m - 1;` initializes the pointer `i` to the last index of the first array that contains actual data (`m` is the number of elements in `nums1` before the merge).
- Line 4: `int j = n - 1;` initializes the pointer `j` to the last index of the second array (`n` is the number of elements in `nums2`).
- Line 5: `int k = m + n - 1;` initializes the pointer `k` to the last index of the first array, considering it has enough space to accommodate all elements from both arrays.
- The `while` loop (Line 7) continues as long as there are elements in the second array (`j >= 0`).
- Inside the loop, we compare `nums1[i]` and `nums2[j]`. If `nums1[i]` is greater (and `i` is within bounds), we place `nums1[i]` at `nums1[k]` and decrement both `i` and `k`.
- If the condition in Line 8 is not met (either `i` is out of bounds or `nums2[j]` is greater), we place `nums2[j]` at `nums1[k]` and decrement both `j` and `k`.
- This process effectively merges the two sorted arrays into the first array in a sorted manner.

### Code
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
```

### Complexity
- Time: The time complexity is **O(m + n)**, where `m` and `n` are the lengths of the input arrays `nums1` and `nums2`, respectively. This is because we're potentially processing every element from both arrays once.
- Space: The space complexity is **O(1)**, not counting the space needed for the input arrays. This is because we're modifying the first input array in-place to store the merged result, without using any additional space that scales with input size. 

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How does this approach handle edge cases, such as when one or both of the input arrays are empty?**
   - The approach inherently handles these cases. If either `m` or `n` is 0, the loop will either not execute (if `n` is 0, the loop condition `j >= 0` will be false from the start) or will simply copy elements from the non-empty array into the appropriate positions in `nums1`.

2. **Can this approach be generalized to merge more than two sorted arrays?**
   - While the basic two-pointer technique can be extended, merging more than two sorted arrays efficiently would likely require a different strategy, such as using a heap or a divide-and-conquer approach like merge sort, to manage the comparisons and mergings efficiently.