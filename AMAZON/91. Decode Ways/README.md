<h2><a href="https://leetcode.com/problems/decode-ways">91. Decode Ways</a></h2>

<p>You have intercepted a secret message encoded as a string of numbers. The message is <strong>decoded</strong> via the following mapping:</p>

<p><code>"1" -&gt; 'A'<br>
"2" -&gt; 'B'<br>
...<br>
"25" -&gt; 'Y'<br>
"26" -&gt; 'Z'</code></p>

<p>However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes (<code>"2"</code> and <code>"5"</code> vs <code>"25"</code>).</p>

<p>For example, <code>"11106"</code> can be decoded into:</p>

<ul>
	<li><code>"AAJF"</code> with the grouping <code>(1, 1, 10, 6)</code></li>
	<li><code>"KJF"</code> with the grouping <code>(11, 10, 6)</code></li>
	<li>The grouping <code>(1, 11, 06)</code> is invalid because <code>"06"</code> is not a valid code (only <code>"6"</code> is valid).</li>
</ul>

<p>Note: there may be strings that are impossible to decode.<br>
<br>
Given a string s containing only digits, return the <strong>number of ways</strong> to <strong>decode</strong> it. If the entire string cannot be decoded in any valid way, return <code>0</code>.</p>

<p>The test cases are generated so that the answer fits in a <strong>32-bit</strong> integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "12"</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>"12" could be decoded as "AB" (1 2) or "L" (12).</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "226"</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>"226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "06"</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>"06" cannot be mapped to "F" because of the leading zero ("6" is different from "06"). In this case, the string is not a valid encoding, so return 0.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> contains only digits and may contain leading zero(s).</li>
</ul>


---

# 🛍️ Decode-Ways | Explained

## Approach 1: Dynamic Programming
### Intuition
The Decode-Ways problem can be thought of as a sequence of decisions, where each decision is whether to decode a single digit or a pair of digits. This approach works by breaking down the problem into smaller sub-problems, solving each sub-problem only once, and storing the results to avoid redundant computation. It's similar to how a hiker might use a map to navigate through a familiar terrain, where the map represents the stored solutions to sub-problems.

### Algorithm Visualized
```mermaid
graph LR;
    A[Start of String] -->|Decode Single Digit|> B[dp[i-1]];
    A -->|Decode Two Digits|> C[dp[i-2]];
    B -->|Add to dp[i]|> D[dp[i]];
    C -->|Add to dp[i]|> D;
```

### Approach
The approach is to use dynamic programming to build up a solution from smaller sub-problems. The idea is to maintain an array `dp` where `dp[i]` represents the number of ways to decode the string up to index `i`. We start by initializing `dp[0]` and `dp[1]` to 1, since there is only one way to decode an empty string and a single digit. Then, for each index `i` from 2 to the end of the string, we check if the current digit can be decoded separately or with the previous digit. If it can be decoded separately, we add the number of ways to decode the string up to `i-1` to `dp[i]`. If it can be decoded with the previous digit, we add the number of ways to decode the string up to `i-2` to `dp[i]`.

### Detailed Code Analysis
Let's dive into the code:
```java
class Solution {
    public int numDecodings(String s) {
        // Check if the string starts with '0', in which case there is no valid decode
        if (s.charAt(0) == '0') {
            return 0;
        }

        // Initialize the length of the string
        int n = s.length();

        // Create a dynamic programming array to store the number of ways to decode the string up to each index
        int[] dp = new int[n + 1];

        // Initialize the base cases
        dp[0] = dp[1] = 1;

        // Iterate over the string from the second character to the end
        for (int i = 2; i <= n; i++) {
            // Get the numeric value of the current digit
            int one = Character.getNumericValue(s.charAt(i - 1));

            // Check if the current digit can be decoded separately
            if (1 <= one && one <= 9) {
                // Add the number of ways to decode the string up to i-1 to dp[i]
                dp[i] += dp[i - 1];
            }

            // Get the numeric value of the current and previous digits
            int two = Integer.parseInt(s.substring(i - 2, i));

            // Check if the current and previous digits can be decoded together
            if (10 <= two && two <= 26) {
                // Add the number of ways to decode the string up to i-2 to dp[i]
                dp[i] += dp[i - 2];
            }
        }

        // Return the number of ways to decode the entire string
        return dp[n];        
    }
}
```

### Code
```java
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int one = Character.getNumericValue(s.charAt(i - 1));
            int two = Integer.parseInt(s.substring(i - 2, i));

            if (1 <= one && one <= 9) {
                dp[i] += dp[i - 1];
            }
            if (10 <= two && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];        
    }
}
```

### Complexity
- **Time:** The time complexity is O(n), where n is the length of the string. This is because we are iterating over the string once, and each operation inside the loop takes constant time.
- **Space:** The space complexity is O(n), where n is the length of the string. This is because we are using a dynamic programming array of size n+1 to store the number of ways to decode the string up to each index.