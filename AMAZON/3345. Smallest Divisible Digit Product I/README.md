<h2><a href="https://leetcode.com/problems/smallest-divisible-digit-product-i">3345. Smallest Divisible Digit Product I</a></h2>

<p>You are given two integers <code>n</code> and <code>t</code>. Return the <strong>smallest</strong> number greater than or equal to <code>n</code> such that the <strong>product of its digits</strong> is divisible by <code>t</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 10, t = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">10</span></p>

<p><strong>Explanation:</strong></p>

<p>The digit product of 10 is 0, which is divisible by 2, making it the smallest number greater than or equal to 10 that satisfies the condition.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 15, t = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">16</span></p>

<p><strong>Explanation:</strong></p>

<p>The digit product of 16 is 6, which is divisible by 3, making it the smallest number greater than or equal to 15 that satisfies the condition.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= t &lt;= 10</code></li>
</ul>


---

# 🛍️ Smallest-Divisible-Digit-Product-I | Explained

## Approach 1: Precomputed GCD Table
### Intuition
The approach relies on precomputing the greatest common divisor (GCD) of all possible pairs of numbers from 1 to 10. This is based on the idea that the smallest number that can be formed by combining `n` digits with a product of `t` will have a certain number of trailing zeros and the remaining digits will have a product that is a multiple of `t`. By precomputing the GCD of all possible pairs, we can quickly determine the required number of each digit to form the smallest number.

### Algorithm Visualized
No visual diagram is necessary for this approach, as it primarily involves mathematical calculations and table lookups.

### Approach
The approach involves the following high-level steps:
1. Precompute the GCD of all possible pairs of numbers from 1 to 10.
2. Divide the input number `n` by 10 to determine the number of tens digits and the remaining units digit.
3. Calculate the required number of each digit to form a product of `t`.
4. Determine the next multiple of the required number that is greater than or equal to the remaining units digit.
5. Calculate the smallest number that can be formed by combining the tens digits and the next multiple of the required number.

### Detailed Code Analysis
Let's break down the code step by step:
```cpp
auto [q, r] = div(n, 10);
```
This line divides the input number `n` by 10 using the `div` function, which returns a pair containing the quotient and remainder. The quotient `q` represents the number of tens digits, and the remainder `r` represents the remaining units digit.

```cpp
int req = t / GCD[q + (10 - q) / 10][t];
```
This line calculates the required number of each digit to form a product of `t`. It does this by looking up the precomputed GCD table at the index `q + (10 - q) / 10` and `t`, and then dividing `t` by the result.

```cpp
int nxt = ((r + req - 1) / req) * req;
```
This line determines the next multiple of the required number that is greater than or equal to the remaining units digit `r`. It does this by adding `req - 1` to `r`, dividing by `req`, and then multiplying by `req`.

```cpp
int x = nxt - (nxt - 10) * (nxt / 10);
```
This line calculates the smallest number that can be formed by combining the tens digits and the next multiple of the required number. It does this by subtracting the product of the number of tens digits and the tens digit value from the next multiple.

### Code
```cpp
class Solution {
public:
    static constexpr int GCD[11][11]={{0,1,2,3,4,5,6,7,8,9,10},{1,1,1,1,1,1,1,1,1,1,1},{2,1,2,1,2,1,2,1,2,1,2},{3,1,1,3,1,1,3,1,1,3,1},{4,1,2,1,4,1,2,1,4,1,2},{5,1,1,1,1,5,1,1,1,1,5},{6,1,2,3,2,1,6,1,2,3,2},{7,1,1,1,1,1,1,7,1,1,1},{8,1,2,1,4,1,2,1,8,1,2},{9,1,1,3,1,1,3,1,1,9,1},{10,1,2,1,2,5,2,1,2,1,10}};
    int smallestNumber(int n, int t) {
        auto [q, r] = div(n, 10);

        int req = t / GCD[q + (10 - q) / 10][t];
        int nxt = ((r + req - 1) / req) * req;
        int x = nxt - (nxt - 10) * (nxt / 10);

        return q * 10 + x;
    }
};
```

### Complexity
- **Time:** The time complexity is O(1), as the number of operations is constant and does not depend on the input size `n` or `t`.
- **Space:** The space complexity is also O(1), as the amount of space used does not grow with the input size `n` or `t`. The precomputed GCD table has a fixed size of 11x11, and the rest of the variables use a constant amount of space.