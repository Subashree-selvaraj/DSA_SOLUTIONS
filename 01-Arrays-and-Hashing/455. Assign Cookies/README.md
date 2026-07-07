<h2><a href="https://leetcode.com/problems/assign-cookies">455. Assign Cookies</a></h2>

<p>Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.</p>

<p>Each child <code>i</code> has a greed factor <code>g[i]</code>, which is the minimum size of a cookie that the child will be content with; and each cookie <code>j</code> has a size <code>s[j]</code>. If <code>s[j] &gt;= g[i]</code>, we can assign the cookie <code>j</code> to the child <code>i</code>, and the child <code>i</code> will be content. Your goal is to maximize the number of your content children and output the maximum number.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> g = [1,2,3], s = [1,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> g = [1,2], s = [1,2,3]
<strong>Output:</strong> 2
<strong>Explanation:</strong> You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= g.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= g[i], s[j] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as <a href="https://leetcode.com/problems/maximum-matching-of-players-with-trainers/description/" target="_blank"> 2410: Maximum Matching of Players With Trainers.</a></p>


---

# 🛍️ Assign-Cookies | Explained

## Approach 1 (Greedy Sorting)
### Intuition
Imagine you're in charge of assigning cookies to a group of children, each with a certain level of hunger (represented by the `g` array) and a limited number of cookies with varying sizes (represented by the `s` array). To satisfy the maximum number of children, you'd want to give the smallest possible cookie to the least hungry child, and so on. This is where the greedy approach comes in – sort both the hunger levels and the cookie sizes, and then iterate through both arrays, assigning cookies to children whenever possible.

### Approach
1. **Sort the input arrays**: First, sort the `g` array (representing the children's hunger levels) and the `s` array (representing the cookie sizes) in ascending order.
2. **Initialize pointers**: Initialize two pointers, `i` and `j`, to the start of the `g` and `s` arrays, respectively, and a `count` variable to keep track of the number of satisfied children.
3. **Assign cookies**: Iterate through both arrays using the pointers. If the current cookie (`s[j]`) is large enough to satisfy the current child's hunger (`g[i]`), increment both pointers and the `count`. If not, move to the next cookie.
4. **Return the count**: Once one of the arrays is exhausted, return the `count`, representing the maximum number of children that can be satisfied.

### Code
```java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int count = 0;

        while(i<g.length && j<s.length){
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}
```

### Complexity
- Time: O(n log n + m log m), where n and m are the lengths of the `g` and `s` arrays, respectively, due to the sorting operations.
- Space: O(1), assuming the sorting is done in-place, as in the case of Java's `Arrays.sort()` method for primitive types.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **What if the cookie sizes or the children's hunger levels are not distinct?** The algorithm still works as intended because it relies on the relative ordering of the values, not their uniqueness.
2. **Can this problem be solved without sorting?** While possible, any such approach would likely involve more complex logic or data structures, potentially leading to increased time or space complexity. The greedy sorting approach provides a straightforward, efficient solution.