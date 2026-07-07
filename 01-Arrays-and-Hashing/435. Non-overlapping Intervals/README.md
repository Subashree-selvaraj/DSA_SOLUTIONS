<h2><a href="https://leetcode.com/problems/non-overlapping-intervals">435. Non-overlapping Intervals</a></h2>

<p>Given an array of intervals <code>intervals</code> where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, return <em>the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping</em>.</p>

<p><strong>Note</strong> that intervals which only touch at a point are <strong>non-overlapping</strong>. For example, <code>[1, 2]</code> and <code>[2, 3]</code> are non-overlapping.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,2],[2,3],[3,4],[1,3]]
<strong>Output:</strong> 1
<strong>Explanation:</strong> [1,3] can be removed and the rest of the intervals are non-overlapping.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,2],[1,2],[1,2]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> You need to remove two [1,2] to make the rest of the intervals non-overlapping.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,2],[2,3]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> You don't need to remove any of the intervals since they're already non-overlapping.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= intervals.length &lt;= 10<sup>5</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>-5 * 10<sup>4</sup> &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= 5 * 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Non-overlapping-Intervals | Explained

## Approach 1 (Sorting and Greedy)
### Intuition
The core idea here is to sort the intervals by their end points. This can be thought of like planning a schedule where you want to finish one task before starting another. By sorting the tasks (intervals) by their end times, we can efficiently decide which tasks to keep in our schedule to maximize the number of non-overlapping tasks.

### Approach
1. Sort all intervals based on their end points.
2. Initialize a counter with 1 (since we can always select the first interval) and a variable to keep track of the end of the last selected interval.
3. Iterate through the sorted intervals. If the current interval does not overlap with the last selected interval (i.e., its start point is greater than or equal to the end point of the last selected interval), increment the counter and update the last selected interval.
4. The counter at the end represents the maximum number of non-overlapping intervals.

### Code
Unfortunately, the provided code snippet `-5 * 104 <= starti < endi <= 5 * 104` does not represent a solution to the "Non-overlapping-Intervals" problem. It seems to be a constraint or a condition related to the problem rather than an actual solution. A correct implementation in Python might look like this:
```python
def eraseOverlapIntervals(intervals):
    if not intervals:
        return 0
    
    intervals.sort(key=lambda x: x[1])
    end = intervals[0][1]
    count = 1
    
    for i in range(1, len(intervals)):
        if intervals[i][0] >= end:
            count += 1
            end = intervals[i][1]
    
    return len(intervals) - count
```

### Complexity
- Time: O(N log N) due to the sorting operation, where N is the number of intervals.
- Space: O(1) if the sorting is done in-place, otherwise O(N) for sorting algorithms that require additional space.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **What if the intervals are not given as pairs of integers but as a list of interval objects?** 
   - The approach remains largely the same, but you would need to adjust the sorting key and the comparison logic to access the start and end points of each interval object.

2. **Can this problem be solved without sorting?** 
   - While it's theoretically possible to solve without sorting by using a more complex data structure like an interval tree, the most straightforward and efficient solution involves sorting the intervals by their end points.