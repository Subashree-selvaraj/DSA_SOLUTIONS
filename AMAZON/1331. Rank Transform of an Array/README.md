<h2><a href="https://leetcode.com/problems/rank-transform-of-an-array">1331. Rank Transform of an Array</a></h2>

<p>Given an array of integers&nbsp;<code>arr</code>, replace each element with its rank.</p>

<p>The rank represents how large the element is. The rank has the following rules:</p>

<ul>
	<li>Rank is an integer starting from 1.</li>
	<li>The larger the element, the larger the rank. If two elements are equal, their rank must be the same.</li>
	<li>Rank should be as small as possible.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [40,10,20,30]
<strong>Output:</strong> [4,1,2,3]
<strong>Explanation</strong>: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [100,100,100]
<strong>Output:</strong> [1,1,1]
<strong>Explanation</strong>: Same elements share the same rank.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = [37,12,28,9,100,56,80,5,12]
<strong>Output:</strong> [5,3,4,2,8,6,7,1,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
</ul>


---

# 🛍️ Rank-Transform-of-an-Array | Explained

## Approach 1: Optimized Sorting and Binary Search
### Intuition
This approach works by first creating a sorted copy of the input array, removing duplicates while preserving the original order of elements. It then uses this sorted array to determine the rank of each element in the original array. The intuition behind this is to leverage the properties of sorted arrays and binary search to efficiently determine the ranks.

### Algorithm Visualized
```mermaid
graph LR
    A[Original Array] -->|Clone and Sort|> B[Sorted Array]
    B -->|Remove Duplicates|> C[Unique Sorted Array]
    A -->|Binary Search in Unique Sorted Array|> D[Ranked Array]
```

### Approach
The high-level logic flow of this approach is as follows:
1. Create a sorted copy of the input array.
2. Remove duplicates from the sorted array while preserving the original order of elements.
3. Use the sorted array with unique elements to determine the rank of each element in the original array.
4. Replace each element in the original array with its corresponding rank.

### Detailed Code Analysis
Let's break down the code step by step:
- `int[] sorted = arr.clone();`: Creates a copy of the input array. This is necessary to avoid modifying the original array.
- `Arrays.sort(sorted);`: Sorts the copied array in ascending order.
- `int m = 0; for (int x : sorted) { if (m == 0 || sorted[m - 1] != x) { sorted[m++] = x; } }`: This loop removes duplicates from the sorted array. It iterates over the sorted array and only adds an element to the front of the array if it's different from the previous one.
- `int[] unique = Arrays.copyOf(sorted, m);`: Creates a new array with the same elements as the sorted array but without duplicates.
- `for (int i = 0; i < arr.length; i++) { arr[i] = Arrays.binarySearch(unique, arr[i]) + 1; }`: This loop replaces each element in the original array with its corresponding rank. It uses binary search to find the index of each element in the unique sorted array and adds 1 to get the rank.

### Code
```java
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        int m = 0;
        for (int x : sorted) {
            if (m == 0 || sorted[m - 1] != x) {
                sorted[m++] = x;
            }
        }

        int[] unique = Arrays.copyOf(sorted, m);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.binarySearch(unique, arr[i]) + 1;
        }

        return arr;
    }
}
```

### Complexity
- **Time:** The time complexity of this approach is O(n log n) due to the sorting operation. The subsequent loop to remove duplicates takes O(n) time, and the binary search for each element takes O(log n) time. Therefore, the overall time complexity is O(n log n) + O(n) + O(n log n) = O(n log n).
- **Space:** The space complexity of this approach is O(n) because we create a copy of the input array and another array to store unique elements.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. How would you optimize this approach if the input array is very large and doesn't fit into memory?
   - One approach to handle large input arrays is to use a distributed computing framework or a database that supports sorting and ranking operations. Another approach is to use a streaming algorithm that processes the input array in chunks.
2. How would you modify this approach to handle duplicate ranks?
   - To handle duplicate ranks, we can modify the approach to assign the same rank to duplicate elements. We can achieve this by using a HashMap to store the rank of each unique element and then assign the rank to each element in the original array based on its value in the HashMap.