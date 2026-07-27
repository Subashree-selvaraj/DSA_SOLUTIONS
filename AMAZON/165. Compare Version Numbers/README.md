<h2><a href="https://leetcode.com/problems/compare-version-numbers">165. Compare Version Numbers</a></h2>

<p>Given two <strong>version strings</strong>, <code>version1</code> and <code>version2</code>, compare them. A version string consists of <strong>revisions</strong> separated by dots <code>'.'</code>. The <strong>value of the revision</strong> is its <strong>integer conversion</strong> ignoring leading zeros.</p>

<p>To compare version strings, compare their revision values in <strong>left-to-right order</strong>. If one of the version strings has fewer revisions, treat the missing revision values as <code>0</code>.</p>

<p>Return the following:</p>

<ul>
	<li>If <code>version1 &lt; version2</code>, return -1.</li>
	<li>If <code>version1 &gt; version2</code>, return 1.</li>
	<li>Otherwise, return 0.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">version1 = "1.2", version2 = "1.10"</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<p>version1's second revision is "2" and version2's second revision is "10": 2 &lt; 10, so version1 &lt; version2.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">version1 = "1.01", version2 = "1.001"</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>Ignoring leading zeroes, both "01" and "001" represent the same integer "1".</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">version1 = "1.0", version2 = "1.0.0.0"</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>version1 has less revisions, which means every missing revision are treated as "0".</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= version1.length, version2.length &lt;= 500</code></li>
	<li><code>version1</code> and <code>version2</code>&nbsp;only contain digits and <code>'.'</code>.</li>
	<li><code>version1</code> and <code>version2</code>&nbsp;<strong>are valid version numbers</strong>.</li>
	<li>All the given revisions in&nbsp;<code>version1</code> and <code>version2</code>&nbsp;can be stored in&nbsp;a&nbsp;<strong>32-bit integer</strong>.</li>
</ul>


---

# 🛍️ Compare-Version-Numbers | Explained

## Approach 1: Split and Compare
### Intuition
The intuition behind this approach is to split the version numbers into their individual parts, compare each part, and return the result as soon as a difference is found. This approach works because version numbers are typically compared from left to right, with the leftmost part being the most significant. For example, when comparing version numbers "1.2.3" and "1.2.4", we can immediately return that the first version is smaller than the second version as soon as we compare the third part (3 vs 4).

### Algorithm Visualized
```mermaid
graph LR
    A[Input Version Numbers] -->|Split by '.'|> B[Version Parts]
    B -->|Compare Parts|> C[Return Result]
    C -->|If parts are equal|> D[Compare Next Part]
    D -->|If all parts are equal|> E[Return Equal]
```

### Approach
The approach can be broken down into the following steps:

1. Split the input version numbers into their individual parts.
2. Compare each part from left to right.
3. If a part is missing in one of the version numbers, consider it as 0.
4. Return -1 if the first version is smaller, 1 if it's larger, and 0 if they are equal.

### Detailed Code Analysis
Let's dive into the code:

- `String[] v1 = version1.split("\\.");` and `String[] v2 = version2.split("\\.");`: These lines split the input version numbers into their individual parts using the "." as a delimiter. The "\\." is used instead of "." because "." has a special meaning in regular expressions.
- `int n = Math.max(v1.length, v2.length);`: This line calculates the maximum length between the two version numbers. This is done to ensure that we compare all parts, even if one version number has more parts than the other.
- `for (int i = 0; i < n; i++)`: This loop iterates over each part of the version numbers.
- `int num1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;` and `int num2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;`: These lines parse the current part of each version number into an integer. If a part is missing in one of the version numbers, it is considered as 0.
- `if (num1 < num2) { return -1; }` and `else if (num1 > num2) { return 1; }`: These lines compare the current parts and return the result if they are different.
- `return 0;`: If the loop completes without finding any differences, this line returns 0, indicating that the version numbers are equal.

### Code
```java
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int n = Math.max(v1.length, v2.length);
        for (int i = 0; i < n; i++) {
            int num1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int num2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}
```

### Complexity
- **Time:** O(max(m, n)), where m and n are the number of parts in the two version numbers. This is because we are iterating over each part of the version numbers.
- **Space:** O(m + n), where m and n are the number of parts in the two version numbers. This is because we are storing the parts of the version numbers in arrays.

## 🕵️‍♂️ Follow-up Questions (Optional)
- Q: How would you handle version numbers with non-numeric parts?
A: You can modify the code to handle non-numeric parts by using a try-catch block to catch `NumberFormatException` exceptions when parsing the parts into integers. If a part is non-numeric, you can consider it as 0 or throw an exception depending on the requirements.
- Q: How would you optimize the code for very large version numbers?
A: You can optimize the code for very large version numbers by using a more efficient string splitting method or by using a data structure like a `StringBuilder` to build the version number parts. Additionally, you can consider using a more efficient comparison method, such as comparing the version numbers as strings instead of parsing them into integers.