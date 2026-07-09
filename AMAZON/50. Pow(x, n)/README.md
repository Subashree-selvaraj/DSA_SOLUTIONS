<h2><a href="https://leetcode.com/problems/powx-n">50. Pow(x, n)</a></h2>

<p>Implement <a href="http://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(x, n)</a>, which calculates <code>x</code> raised to the power <code>n</code> (i.e., <code>x<sup>n</sup></code>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = 10
<strong>Output:</strong> 1024.00000
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> x = 2.10000, n = 3
<strong>Output:</strong> 9.26100
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = -2
<strong>Output:</strong> 0.25000
<strong>Explanation:</strong> 2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-100.0 &lt; x &lt; 100.0</code></li>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
	<li><code>n</code> is an integer.</li>
	<li>Either <code>x</code> is not zero or <code>n &gt; 0</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= x<sup>n</sup> &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Pow(x,-n) | Explained

## Approach 1 (Exponentiation by Squaring)
### Intuition
Imagine you're at a bakery, and you need to make a large batch of dough that requires a certain ingredient to be mixed in a specific ratio. Each time you mix the ingredient, it's like squaring the previous amount. To make the process more efficient, you can divide the number of mixings into smaller, more manageable chunks. This approach works because it breaks down the problem of calculating a large power into smaller sub-problems, leveraging the properties of exponentiation.

### Approach
The algorithm uses exponentiation by squaring, a technique that reduces the number of multiplications required to calculate a power. Here's a step-by-step breakdown:
1. Check if the exponent is negative. If so, invert the base and convert the exponent to its absolute value.
2. Initialize the result to 1.
3. While the exponent is greater than 0, check if it's odd. If it is, multiply the result by the current base.
4. Square the base and divide the exponent by 2 (using bitwise shift).
5. Repeat steps 3-4 until the exponent is 0.

### Detailed Code Analysis
Let's dive into the code:
- Line 3: `long num = n;` - The exponent is stored in a long variable to handle cases where the absolute value of `n` exceeds the maximum limit of an integer.
- Line 4-7: The code checks if the exponent is negative. If so, it inverts the base by taking its reciprocal (`x = 1 / x;`) and converts the exponent to its absolute value (`num = -num;`).
- Line 9: `double pow = 1;` - The result is initialized to 1.
- Line 10-16: The while loop implements the exponentiation by squaring algorithm. 
  - Line 11: `if ((num & 1) != 0)` - This checks if the current exponent is odd using a bitwise AND operation. If the result is not 0, the current base is multiplied with the result.
  - Line 12: `pow *= x;` - The result is updated by multiplying it with the current base.
  - Line 14: `x *= x;` - The base is squared for the next iteration.
  - Line 15: `num >>>= 1;` - The exponent is divided by 2 using a bitwise right shift operation.
- Line 18: The final result is returned.

### Code
```java
class Solution {
    public double myPow(double x, int n) {
        long num = n; 
        if (num < 0) {
            x = 1 / x;
            num = -num;
        }
        
        double pow = 1; 
        while (num > 0) {
            if ((num & 1) != 0) { // If the current bit is 1 (odd number)
                pow *= x;
            }
            x *= x;               // Square the base
            num >>>= 1;           // Bitwise right shift (divide by 2)
        }
        
        return pow;
    }
}
```

### Complexity
- Time: The time complexity is O(log(n)), where n is the absolute value of the exponent. This is because the while loop runs until the exponent is 0, and in each iteration, the exponent is divided by 2.
- Space: The space complexity is O(1), which means the space required does not grow with the size of the input. This is because only a constant amount of space is used to store the variables.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. Q: What happens if the base is 0 and the exponent is negative?
   A: In this case, the function should throw an exception or return a special value to indicate an error, as dividing by zero is undefined.
2. Q: How would you optimize this code for very large exponents?
   A: For very large exponents, you could consider using the `BigInteger` class in Java, or a similar class in other languages, to handle the large numbers. Additionally, you could use a more advanced algorithm, such as the "exponentiation by squaring" method with a divide-and-conquer approach, to reduce the number of multiplications required.