<h2><a href="https://leetcode.com/problems/flipping-an-image">832. Flipping an Image</a></h2>

<p>Given an <code>n x n</code> binary matrix <code>image</code>, flip the image <strong>horizontally</strong>, then invert it, and return <em>the resulting image</em>.</p>

<p>To flip an image horizontally means that each row of the image is reversed.</p>

<ul>
	<li>For example, flipping <code>[1,1,0]</code> horizontally results in <code>[0,1,1]</code>.</li>
</ul>

<p>To invert an image means that each <code>0</code> is replaced by <code>1</code>, and each <code>1</code> is replaced by <code>0</code>.</p>

<ul>
	<li>For example, inverting <code>[0,1,1]</code> results in <code>[1,0,0]</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> image = [[1,1,0],[1,0,1],[0,0,0]]
<strong>Output:</strong> [[1,0,0],[0,1,0],[1,1,1]]
<strong>Explanation:</strong> First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
<strong>Output:</strong> [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
<strong>Explanation:</strong> First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == image.length</code></li>
	<li><code>n == image[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 20</code></li>
	<li><code>images[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>


---

# 🛍️ Flipping-an-Image | Explained

## Approach 1: Flipping and Inverting the Image
### Intuition
This approach works by first flipping the image horizontally and then inverting the bits of the image. The intuition behind this approach is to break down the problem into two simpler sub-problems: flipping the image and inverting the bits. The flipping step is similar to reversing a string, where we swap the elements from the start and end indices, moving towards the center. The inverting step is a simple bit-wise operation where we change the value of each pixel to its opposite (0 becomes 1 and 1 becomes 0).

### Algorithm Visualized
```mermaid
graph LR
    A[Flipping] -->|Horizontally|> B[Image]
    B -->|Inverting|> C[Bits]
    C --> D[Result]
```

### Approach
The approach involves two main steps:
1. Flipping the image horizontally.
2. Inverting the bits of the image.

### Detailed Code Analysis
The code starts by storing the length of the image in the variable `n`. This variable is used to iterate over the rows and columns of the image.
```java
int n = image.length;
```
The flipping step is implemented using a while loop that iterates over each row of the image. For each row, it uses two pointers, `left` and `right`, to swap the elements from the start and end indices, moving towards the center.
```java
for (int i = 0; i < n; i++) {
    int left = 0;
    int right = n - 1;
    while (left < right) {
        int temp = image[i][left];
        image[i][left] = image[i][right];
        image[i][right] = temp;
        left++;
        right--;
    }
}
```
The inverting step is implemented using a nested loop that iterates over each element of the image. For each element, it flips the bit using the expression `1 - image[i][j]`.
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        image[i][j] = 1 - image[i][j];
    }
}
```
### Code
```java
public int[][] flipAndInvertImage(int[][] image) {
    int n = image.length;
    for (int i = 0; i < n; i++) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int temp = image[i][left];
            image[i][left] = image[i][right];
            image[i][right] = temp;
            left++;
            right--;
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            image[i][j] = 1 - image[i][j];
        }
    }
    return image;
}
```

### Complexity
- **Time:** O(n^2), where n is the length of the image. The flipping step has a time complexity of O(n^2) because it involves swapping elements in each row of the image. The inverting step also has a time complexity of O(n^2) because it involves iterating over each element of the image. Since the two steps are performed sequentially, the overall time complexity is O(n^2) + O(n^2) = O(2n^2), which simplifies to O(n^2).
- **Space:** O(1), because the algorithm modifies the input image in-place and does not use any additional space that scales with the input size. The only extra space used is for a few variables to store temporary values, which does not depend on the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
- How would you modify the algorithm to flip the image vertically instead of horizontally?
- How would you optimize the algorithm to handle very large images?
Brief answers:
- To flip the image vertically, you can modify the flipping step to swap elements between rows instead of columns.
- To optimize the algorithm for very large images, you can use multi-threading or parallel processing to flip and invert different parts of the image concurrently.