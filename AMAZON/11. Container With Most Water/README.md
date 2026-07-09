<h2><a href="https://leetcode.com/problems/container-with-most-water">11. Container With Most Water</a></h2>

<p>You are given an integer array <code>height</code> of length <code>n</code>. There are <code>n</code> vertical lines drawn such that the two endpoints of the <code>i<sup>th</sup></code> line are <code>(i, 0)</code> and <code>(i, height[i])</code>.</p>

<p>Find two lines that together with the x-axis form a container, such that the container contains the most water.</p>

<p>Return <em>the maximum amount of water a container can store</em>.</p>

<p><strong>Notice</strong> that you may not slant the container.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" style="width: 600px; height: 287px;">
<pre><strong>Input:</strong> height = [1,8,6,2,5,4,8,3,7]
<strong>Output:</strong> 49
<strong>Explanation:</strong> The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> height = [1,1]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Container-With-Most-Water | Explained

## Approach 1: Two-Pointer Technique
### Intuition
Imagine you have a bunch of sticks of different heights and you want to create a container that can hold the most water. The area of the container is determined by the width (distance between the sticks) and the height (the minimum height of the two sticks). The intuition behind this approach is to start with the widest container possible and then adjust the sticks to maximize the area. We can achieve this by using two pointers, one at the beginning and one at the end, and moving them towards each other.

### Approach
The algorithm starts by initializing two pointers, `left` and `right`, at the beginning and end of the height array, respectively. It then calculates the area of the container formed by these two sticks and updates the maximum area found so far. The key step is to determine which pointer to move towards the other. If the height of the stick at the `left` pointer is less than the height of the stick at the `right` pointer, we move the `left` pointer to the right. Otherwise, we move the `right` pointer to the left. This ensures that we don't miss any potential containers with a larger area.

### Detailed Code Analysis
Let's dive into the code:
- `int left=0;` and `int right=height.length-1;` initialize the two pointers at the beginning and end of the height array, respectively.
- `int max=-1;` initializes the maximum area found so far to a negative value (any area will be greater than this).
- The `while` loop continues until the two pointers meet (`left<right`).
- Inside the loop:
  - `int w=right-left;` calculates the width of the container.
  - `int h=Math.min(height[left],height[right]);` calculates the height of the container (the minimum height of the two sticks).
  - `max=Math.max(max,w*h);` updates the maximum area found so far.
  - The `if-else` statement determines which pointer to move towards the other:
    - `if(height[left]<height[right])`: if the height of the stick at the `left` pointer is less than the height of the stick at the `right` pointer, we move the `left` pointer to the right (`left++`).
    - `else`: otherwise, we move the `right` pointer to the left (`right--`).

### Code
```java
int left = 0;
int right = height.length - 1;
int max = -1;
while (left < right) {
    int w = right - left;
    int h = Math.min(height[left], height[right]);
    max = Math.max(max, w * h);
    if (height[left] < height[right]) {
        left++;
    } else {
        right--;
    }
}
return max;
```

### Complexity
- Time: The time complexity of this solution is O(n), where n is the number of elements in the height array. This is because we are scanning the array once, and each operation inside the loop takes constant time.
- Space: The space complexity is O(1), as we are using a constant amount of space to store the pointers and the maximum area.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem are:
1. How would you handle edge cases, such as an empty input array or an array with only one element?
   - You can add simple checks at the beginning of the function to handle these cases and return the expected results (e.g., 0 for an empty array).
2. Can you optimize the solution further?
   - The current solution has a linear time complexity and constant space complexity, which is optimal for this problem. However, you could explore other approaches, such as using a different data structure or algorithm, to see if they provide any benefits.