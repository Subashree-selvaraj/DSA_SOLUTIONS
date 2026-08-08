<h2><a href="https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses">1249. Minimum Remove to Make Valid Parentheses</a></h2>

<p>Given a string <font face="monospace">s</font> of <code>'('</code> , <code>')'</code> and lowercase English characters.</p>

<p>Your task is to remove the minimum number of parentheses ( <code>'('</code> or <code>')'</code>, in any positions ) so that the resulting <em>parentheses string</em> is valid and return <strong>any</strong> valid string.</p>

<p>Formally, a <em>parentheses string</em> is valid if and only if:</p>

<ul>
	<li>It is the empty string, contains only lowercase characters, or</li>
	<li>It can be written as <code>AB</code> (<code>A</code> concatenated with <code>B</code>), where <code>A</code> and <code>B</code> are valid strings, or</li>
	<li>It can be written as <code>(A)</code>, where <code>A</code> is a valid string.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "lee(t(c)o)de)"
<strong>Output:</strong> "lee(t(c)o)de"
<strong>Explanation:</strong> "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "a)b(c)d"
<strong>Output:</strong> "ab(c)d"
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "))(("
<strong>Output:</strong> ""
<strong>Explanation:</strong> An empty string is also valid.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either&nbsp;<code>'('</code> , <code>')'</code>, or lowercase English letter.</li>
</ul>


---

# 🛍️ Minimum-Remove-to-Make-Valid-Parentheses | Explained

## Approach 1: Two-Pass Stack-Based Approach
### Intuition
The provided code solution utilizes a two-pass approach to remove the minimum number of characters from the input string to make it valid. This approach works by first iterating through the string to identify and store valid characters in a stack, skipping any invalid right parentheses that do not have a matching left parenthesis. In the second pass, it reconstructs the string from the stack, ensuring that any excess left parentheses are also removed. This is analogous to a real-world scenario where an editor reviews a document, first identifying and marking valid sections, and then refining those sections to ensure coherence.

### Algorithm Visualized
```mermaid
graph LR;
    A[Input String] -->|Iterate|> B[Check Parentheses];
    B -->|Valid|> C[Push to Stack];
    B -->|Invalid Right|> D[Skip];
    C -->|Second Pass|> E[Pop from Stack];
    E -->|Excess Left|> F[Skip];
    E -->|Valid|> G[Append to Result];
    G -->|Reverse|> H[Final String];
```

### Approach
1. Initialize counts for left and right parentheses and a stack to store valid characters.
2. Iterate through the input string. For each character:
   - If it's a left parenthesis, increment the left count.
   - If it's a right parenthesis, check if there are more right parentheses than left. If so, skip this character; otherwise, push it to the stack.
3. Perform a second pass using the stack:
   - Pop characters from the stack. If there are more left parentheses than right and the popped character is a left parenthesis, skip it; otherwise, append it to the result string.
4. Reverse the result string to obtain the final valid string.

### Detailed Code Analysis
```java
class Solution {
    public String minRemoveToMakeValid(String s) {
        // Initialize counts for left and right parentheses
        int leftCount = 0;
        int rightCount = 0;

        // Use a stack to keep track of valid parentheses
        Stack<Character> stack = new Stack<>();

        // Pass 1: Iterate through the string and process parentheses
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Increment count for left parentheses
            if (currentChar == '(') {
                leftCount++;
            }
            // Increment count for right parentheses
            if (currentChar == ')') {
                rightCount++;
            }

            // If there are more right parentheses than left, skip the current right parenthesis
            if (rightCount > leftCount) {
                rightCount--; // Decrease right count
                continue;     // Skip processing this right parenthesis
            } else {
                stack.push(currentChar); // Add valid parentheses to the stack
            }
        }

        // Pass 2: Reconstruct the string using the valid parentheses in the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            char currentChar = stack.pop();
            // If there are more left parentheses than right, skip the current left parenthesis
            if (leftCount > rightCount && currentChar == '(') {
                leftCount--; // Decrease left count
                // Do nothing, skip this left parenthesis
            } else {
                result.append(currentChar); // Add valid parentheses to the result
            }
        }

        // Reverse the result string and return
        return result.reverse().toString();
    }
}
```
Key aspects:
- The use of a stack allows for efficient storage and retrieval of valid characters.
- The two-pass approach ensures that both invalid right parentheses and excess left parentheses are handled correctly.
- The `StringBuilder` is used for efficient string construction, and its `reverse()` method simplifies the final step of reversing the string.

### Complexity
- **Time:** O(n), where n is the length of the input string, because we perform two passes through the string.
- **Space:** O(n), for storing characters in the stack and the result string, in the worst case when all characters are valid.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How can this approach be optimized further?**
   - The current approach is already efficient with a linear time complexity. However, optimizations could involve using a single data structure that tracks both the count of parentheses and their validity, potentially reducing the space complexity in certain scenarios.
2. **What if the input string can contain other types of parentheses or brackets?**
   - To handle this, the approach would need to be extended to track different types of brackets separately. This could involve using a more complex data structure, such as a stack of objects where each object represents a bracket type and its corresponding closing bracket, or a dictionary that maps opening brackets to their closing counterparts.