<h2><a href="https://leetcode.com/problems/product-of-array-except-self">238. Product of Array Except Self</a></h2>

<p>Given an integer array <code>nums</code>, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is equal to the product of all the elements of</em> <code>nums</code> <em>except</em> <code>nums[i]</code>.</p>

<p>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time and without using the division operation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> [24,12,8,6]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [-1,1,0,-3,3]
<strong>Output:</strong> [0,0,9,0,0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-30 &lt;= nums[i] &lt;= 30</code></li>
	<li>The input is generated such that <code>answer[i]</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Can you solve the problem in <code>O(1)</code>&nbsp;extra&nbsp;space complexity? (The output array <strong>does not</strong> count as extra space for space complexity analysis.)</p>


---

# 🛍️ Product-of-Array-Except-Self | Explained

## Approach 1: Prefix and Suffix Array
### Intuition
The intuition behind this approach is to calculate the product of all numbers to the left and right of each index in the array. This can be achieved by creating two separate arrays, one for prefix products and one for suffix products. The product of all numbers except the one at a particular index is then simply the product of the corresponding prefix and suffix values. This approach works because it takes advantage of the fact that the product of all numbers except the one at a particular index can be broken down into the product of all numbers to the left and all numbers to the right.

### Algorithm Visualized
```mermaid
flowchart LR
    A[Input Array] -->|Create Prefix Array|> B[Prefix Array]
    A -->|Create Suffix Array|> C[Suffix Array]
    B -->|Calculate Product|> D[Product Array]
    C -->|Calculate Product|> D
    D -->|Return Result|> E[Output Array]
```

### Approach
The algorithm starts by initializing two arrays, `pre` and `suff`, of the same length as the input array. It then fills the `pre` array with the prefix products by iterating through the input array from left to right. Similarly, it fills the `suff` array with the suffix products by iterating through the input array from right to left. Finally, it calculates the product of all numbers except the one at each index by multiplying the corresponding prefix and suffix values and stores the result in the `ans` array.

### Detailed Code Analysis
Let's take a closer look at the code:
- `int n = nums.length;` retrieves the length of the input array.
- `int pre[] = new int[n];` and `int suff[] = new int[n];` initialize two arrays to store the prefix and suffix products, respectively.
- `pre[0] = 1;` and `suff[n-1] = 1;` set the first element of the prefix array and the last element of the suffix array to 1, respectively, since there are no numbers to the left of the first index and no numbers to the right of the last index.
- The first `for` loop calculates the prefix products by iterating through the input array from left to right and multiplying the current prefix product with the number at the previous index.
- The second `for` loop calculates the suffix products by iterating through the input array from right to left and multiplying the current suffix product with the number at the next index.
- The third `for` loop calculates the product of all numbers except the one at each index by multiplying the corresponding prefix and suffix values and stores the result in the `ans` array.
- `return ans;` returns the resulting array.

### Code
```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int pre[] = new int[n];
    int suff[] = new int[n];
    pre[0] = 1;
    suff[n-1] = 1;

    for(int i = 1; i < n; i++){
        pre[i] = pre[i-1] * nums[i-1];
    }
    for(int i = n - 2; i >= 0; i--) {
        suff[i] = suff[i + 1] * nums[i + 1];
    }

    int ans[] = new int[n];
    for(int i = 0; i < n; i++) {
        ans[i] = pre[i] * suff[i];
    }
    return ans;
}
```

### Complexity
- **Time:** The time complexity is O(n), where n is the length of the input array. This is because the algorithm performs three separate passes through the input array: one to calculate the prefix products, one to calculate the suffix products, and one to calculate the final products.
- **Space:** The space complexity is O(n), where n is the length of the input array. This is because the algorithm uses two additional arrays of the same length as the input array to store the prefix and suffix products.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions for this problem include:
- How would you modify the algorithm to handle the case where the input array is empty or null?
- How would you optimize the algorithm to reduce the space complexity, for example, by using a single array to store both the prefix and suffix products?