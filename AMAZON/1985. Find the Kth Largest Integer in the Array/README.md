<h2><a href="https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array">1985. Find the Kth Largest Integer in the Array</a></h2>

<p>You are given an array of strings <code>nums</code> and an integer <code>k</code>. Each string in <code>nums</code> represents an integer without leading zeros.</p>

<p>Return <em>the string that represents the </em><code>k<sup>th</sup></code><em><strong> largest integer</strong> in </em><code>nums</code>.</p>

<p><strong>Note</strong>: Duplicate numbers should be counted distinctly. For example, if <code>nums</code> is <code>["1","2","2"]</code>, <code>"2"</code> is the first largest integer, <code>"2"</code> is the second-largest integer, and <code>"1"</code> is the third-largest integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = ["3","6","7","10"], k = 4
<strong>Output:</strong> "3"
<strong>Explanation:</strong>
The numbers in nums sorted in non-decreasing order are ["3","6","7","10"].
The 4<sup>th</sup> largest integer in nums is "3".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = ["2","21","12","1"], k = 3
<strong>Output:</strong> "2"
<strong>Explanation:</strong>
The numbers in nums sorted in non-decreasing order are ["1","2","12","21"].
The 3<sup>rd</sup> largest integer in nums is "2".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = ["0","0"], k = 2
<strong>Output:</strong> "0"
<strong>Explanation:</strong>
The numbers in nums sorted in non-decreasing order are ["0","0"].
The 2<sup>nd</sup> largest integer in nums is "0".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i].length &lt;= 100</code></li>
	<li><code>nums[i]</code> consists of only digits.</li>
	<li><code>nums[i]</code> will not have any leading zeros.</li>
</ul>


---

# 🛍️ Find-the-Kth-Largest-Integer-in-the-Array | Explained

## Approach 1: Custom Sorting
### Intuition
This approach works by first sorting the array of strings representing integers in descending order. The sorting is done in a way that first compares the lengths of the strings (to handle numbers of different magnitudes) and then compares the strings lexicographically (to handle numbers of the same magnitude). This ensures that the sorting is done in a way that larger numbers come before smaller numbers. The intuition behind this approach can be thought of as sorting a list of numbers written in words (e.g., "one", "two", "three") where the length of the word (number of letters) and then the alphabetical order are considered.

### Algorithm Visualized
Since the algorithm primarily involves sorting, it can be visualized as a process of arranging elements in an array from largest to smallest based on a custom comparison rule. There isn't a specific Mermaid diagram that directly illustrates the sorting logic in a concise manner without becoming overly complex or simplistic, so we'll proceed directly to the approach and code analysis.

### Approach
1. The approach starts by defining a custom sorting rule for the array of strings.
2. It sorts the array based on this custom rule, which prioritizes the length of the strings (longer strings represent larger numbers) and then their lexicographical order.
3. After sorting, it selects the `kth` element from the end of the sorted array, which corresponds to the `kth` largest number.

### Detailed Code Analysis
- Line 1: `class Solution {` declares a class named `Solution` which will contain the method to solve the problem.
- Line 2: `public String kthLargestNumber(String[] nums, int k) {` defines a public method `kthLargestNumber` that takes an array of strings `nums` and an integer `k` as parameters and returns a string.
- Line 3: `Arrays.sort(nums,(a,b)->{` initiates the sorting of the `nums` array with a custom comparator.
- Lines 4-6: `if(a.length()!=b.length()){ return a.length()-b.length(); }` compares the lengths of two strings `a` and `b`. If they are of different lengths, it returns the difference. This implies that longer strings (which represent larger numbers in this context) will come first in the sorted array.
- Line 8: `return a.compareTo(b);` if the lengths of `a` and `b` are the same, it compares them lexicographically (alphabetically). This ensures that within numbers of the same magnitude (length), they are sorted in descending order.
- Line 10: `return nums[nums.length-k];` returns the `kth` element from the end of the sorted array, which is the `kth` largest number.

### Code
```java
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums,(a,b)->{
            if(a.length()!=b.length()){
                return a.length()-b.length();
            }
            return a.compareTo(b);
        });
        return  nums[nums.length-k];
    }
}
```

### Complexity
- **Time:** The time complexity of this solution is O(n log n) due to the sorting operation, where n is the number of strings in the input array. The custom comparator within the sorting does not change the overall time complexity of the sorting algorithm.
- **Space:** The space complexity is O(1) if we consider the input array as part of the space requirement and assume that the sorting is done in-place. However, if we consider the need for additional space used during the sorting process (which can vary depending on the sorting algorithm implementation), it could be O(n) in the worst case for algorithms like merge sort, but typically, Java's `Arrays.sort()` for primitives and objects uses a variant of dual pivot quicksort for primitives and TimSort for objects, both of which have an average and worst-case space complexity of O(log n) due to the recursion stack.

## 🕵️‍♂️ Follow-up Questions
1. **What if there are duplicate numbers in the array?** The current implementation treats duplicate numbers based on their string representation. If two numbers are the same, their order after sorting will depend on their original order in the input array due to the stability of the sorting algorithm used by Java.
2. **How would you optimize this solution for very large input arrays?** For very large input arrays, using a more efficient sorting algorithm or leveraging the fact that we only need the `kth` largest element (potentially using a heap or a partial sorting approach) could provide significant performance improvements.