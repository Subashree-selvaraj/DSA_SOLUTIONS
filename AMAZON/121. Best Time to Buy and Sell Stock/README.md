<h2><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">121. Best Time to Buy and Sell Stock</a></h2>

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>

<p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Best-Time-to-Buy-and-Sell-Stock | Explained

## Approach 1: Two-Pointer Technique with a Twist
### Intuition
Imagine you're at a stock market, and you want to buy a stock when it's cheap and sell it when it's expensive. You have a unique opportunity to do this only once. The key idea here is to track the minimum price you've seen so far and the maximum profit you can get by selling at the current price. This approach works because it ensures you're considering all possible buy-sell combinations without having to explicitly iterate over all of them.

### Approach
The high-level logic is to maintain two pointers, `left` and `right`, where `left` represents the current buy position and `right` represents the current sell position. Initially, `left` is at the first price, and `right` is at the second price. You then iterate over the prices, updating `left` and `right` based on whether the current price is greater than the price at `left`. If it is, you calculate the profit and update the maximum profit if necessary. If the current price is not greater than the price at `left`, you move `left` to the current position, effectively starting a new potential buy-sell window.

### Detailed Code Analysis
Let's dive into the code:
- The variables `left`, `right`, and `maxProfit` are initialized. `left` and `right` serve as pointers to the current buy and sell positions, respectively, while `maxProfit` keeps track of the maximum profit found so far.
- The `while` loop iterates over the `prices` array using `right` as the index. This loop continues until `right` reaches the end of the array, ensuring all prices are considered.
- Inside the loop, an `if` statement checks if the price at `right` is greater than the price at `left`. This condition determines whether a potential profit can be made by selling at the current price.
- If a profit can be made, the code calculates the profit (`prices[right] - prices[left]`) and updates `maxProfit` if the calculated profit is greater than the current `maxProfit`.
- If the price at `right` is not greater than the price at `left`, it means the current buy position (`left`) is no longer optimal. In this case, `left` is moved to the current `right` position, starting a new potential buy-sell window.
- The `right` pointer is incremented at the end of each iteration, moving to the next price in the array.

### Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1, maxProfit = 0;
        while (right < prices.length) {
            if (prices[right] > prices[left]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
```

### Complexity
- Time: The solution iterates through the `prices` array once, using a while loop that runs in O(n) time, where n is the number of elements in the `prices` array.
- Space: The space complexity is O(1) because the solution uses a constant amount of space to store the variables `left`, `right`, and `maxProfit`, regardless of the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you modify this solution to handle multiple buy-sell transactions?**
   - To handle multiple transactions, you would need to keep track of the maximum profit after the last transaction. This can be achieved by using dynamic programming, where you maintain arrays to keep track of the maximum profit after the last buy and sell.

2. **What if the transaction fee is not zero? How would you incorporate this into the solution?**
   - Incorporating a transaction fee involves subtracting the fee from the profit calculation. The fee would be deducted each time a transaction (buy or sell) occurs, affecting the overall profit calculation. This would require adjusting the profit calculation within the if statement where the profit is calculated and compared with `maxProfit`.