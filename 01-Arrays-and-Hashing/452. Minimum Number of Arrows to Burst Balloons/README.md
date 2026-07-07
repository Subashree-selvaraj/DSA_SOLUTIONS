<h2><a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons">452. Minimum Number of Arrows to Burst Balloons</a></h2>

<p>There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array <code>points</code> where <code>points[i] = [x<sub>start</sub>, x<sub>end</sub>]</code> denotes a balloon whose <strong>horizontal diameter</strong> stretches between <code>x<sub>start</sub></code> and <code>x<sub>end</sub></code>. You do not know the exact y-coordinates of the balloons.</p>

<p>Arrows can be shot up <strong>directly vertically</strong> (in the positive y-direction) from different points along the x-axis. A balloon with <code>x<sub>start</sub></code> and <code>x<sub>end</sub></code> is <strong>burst</strong> by an arrow shot at <code>x</code> if <code>x<sub>start</sub> &lt;= x &lt;= x<sub>end</sub></code>. There is <strong>no limit</strong> to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.</p>

<p>Given the array <code>points</code>, return <em>the <strong>minimum</strong> number of arrows that must be shot to burst all balloons</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> points = [[10,16],[2,8],[1,6],[7,12]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> points = [[1,2],[3,4],[5,6],[7,8]]
<strong>Output:</strong> 4
<strong>Explanation:</strong> One arrow needs to be shot for each balloon for a total of 4 arrows.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> points = [[1,2],[2,3],[3,4],[4,5]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= points.length &lt;= 10<sup>5</sup></code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>-2<sup>31</sup> &lt;= x<sub>start</sub> &lt; x<sub>end</sub> &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


---

# 🛍️ Minimum-Number-of-Arrows-to-Burst-Balloons | Explained

It appears that the provided code snippet is incomplete and doesn't contain any actual solution to the problem. However, I can still explain the general approaches to solve the "Minimum-Number-of-Arrows-to-Burst-Balloons" problem.

## Approach 1 (Greedy)
### Intuition
Imagine you're shooting arrows at balloons, and each balloon has a range of x-coordinates where it's valid. You want to minimize the number of arrows you shoot while still popping all the balloons. A greedy approach would be to always aim for the balloon that ends first, as it will give you the most opportunities to pop other balloons with the same arrow.
### Approach
1. Sort the balloons by their end x-coordinates.
2. Initialize the number of arrows to 1, as you'll always need at least one arrow.
3. Initialize the current arrow position to the end of the first balloon.
4. Iterate over the remaining balloons. If a balloon starts after the current arrow position, it can't be popped by the current arrow, so increment the number of arrows and update the current arrow position to the end of this balloon.
### Code
```python
def findMinArrowShots(points):
    if not points:
        return 0
    
    points.sort(key=lambda x: x[1])
    arrows = 1
    current_arrow = points[0][1]
    
    for point in points[1:]:
        if point[0] > current_arrow:
            arrows += 1
            current_arrow = point[1]
    
    return arrows
```
### Complexity
- Time: O(n log n) due to sorting
- Space: O(1) if we don't count the input, as we're using a constant amount of space

## Approach 2 (Interval Merging)
### Intuition
This approach is similar to the greedy one, but it's more focused on merging overlapping intervals. If two balloons overlap, you can pop them with the same arrow.
### Approach
1. Sort the balloons by their start x-coordinates.
2. Initialize the number of arrows to 1, as you'll always need at least one arrow.
3. Initialize the current interval to the first balloon.
4. Iterate over the remaining balloons. If a balloon overlaps with the current interval, merge them by updating the end of the current interval. If a balloon doesn't overlap, increment the number of arrows and update the current interval.
### Code
```python
def findMinArrowShots(points):
    if not points:
        return 0
    
    points.sort(key=lambda x: x[0])
    arrows = 1
    current_interval = points[0]
    
    for point in points[1:]:
        if point[0] <= current_interval[1]:
            current_interval = [current_interval[0], min(current_interval[1], point[1])]
        else:
            arrows += 1
            current_interval = point
    
    return arrows
```
### Complexity
- Time: O(n log n) due to sorting
- Space: O(1) if we don't count the input, as we're using a constant amount of space

## 🕵️‍♂️ Follow-up Questions (Optional)
1. Q: What if the input balloons are not Axis-Aligned? 
A: In that case, we would need to use a more complex data structure, such as a sweep line algorithm or a geometric algorithm, to find the minimum number of arrows.
2. Q: Can we use a dynamic programming approach to solve this problem? 
A: While it's technically possible to use dynamic programming, it would likely be less efficient than the greedy or interval merging approaches, as it would require a lot of redundant computation.