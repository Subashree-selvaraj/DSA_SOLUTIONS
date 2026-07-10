<h2><a href="https://leetcode.com/problems/merge-intervals">56. Merge Intervals</a></h2>

<p>Given an array&nbsp;of <code>intervals</code>&nbsp;where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, merge all overlapping intervals, and return <em>an array of the non-overlapping intervals that cover all the intervals in the input</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,3],[2,6],[8,10],[15,18]]
<strong>Output:</strong> [[1,6],[8,10],[15,18]]
<strong>Explanation:</strong> Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,4],[4,5]]
<strong>Output:</strong> [[1,5]]
<strong>Explanation:</strong> Intervals [1,4] and [4,5] are considered overlapping.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> intervals = [[4,7],[1,4]]
<strong>Output:</strong> [[1,7]]
<strong>Explanation:</strong> Intervals [1,4] and [4,7] are considered overlapping.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Merge-Intervals | Explained

## Approach 1 (Binary Search Tree)
### Intuition
Imagine you are organizing a conference with multiple sessions. Each session has a start and end time. You want to merge sessions that overlap with each other. This approach uses a binary search tree (BST) to store the sessions. Each node in the BST represents a session, and the tree is organized such that sessions with earlier end times are on the left and sessions with later start times are on the right. This allows for efficient merging of overlapping sessions.

### Approach
1. Start with an empty tree.
2. Iterate over each session (interval) in the input list.
3. For each session, insert it into the tree. If the tree is empty, create a new root node. Otherwise, recursively traverse the tree to find the correct location for the session.
4. When a session is inserted into the tree, check if it overlaps with the current node. If it does, merge the two sessions by updating the start and end times of the current node.
5. After all sessions have been inserted into the tree, traverse the tree to extract the merged sessions.

### Detailed Code Analysis
The code defines a `TreeNode` class to represent each session in the tree. Each node has `start`, `end`, and `middle` attributes, which represent the start and end times of the session and the midpoint of the session, respectively. The `middle` attribute is used to guide the insertion of new sessions into the tree.

The `Solution` class has a `merge` method that takes a list of sessions as input. It initializes an empty tree and then iterates over each session in the input list, inserting it into the tree using the `add` method.

The `add` method recursively traverses the tree to find the correct location for the new session. If the new session has an end time less than the midpoint of the current node, it goes left. If it has a start time greater than the midpoint, it goes right. If it overlaps with the current node, it merges the two sessions by updating the start and end times of the current node.

The `query` method traverses the tree to extract the merged sessions. It uses a merge-sort approach to divide and conquer the tree, recursively extracting the merged sessions from the left and right subtrees and then merging them together.

### Code
```python
class TreeNode:
    def __init__(self, start, end, middle):
        self.start = start
        self.end = end
        self.middle = middle
        self.left = self.right = None

class Solution:
    def __init__(self):
        self.root = None
    
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []
        
        for start, end in intervals:
            if not self.root:
                self.root = TreeNode(start, end, (start + end) // 2)
            else:
                self.add(self.root, start, end)
        
        return self.query(self.root)
    
    def add(self, node, start, end):     
        if end < node.middle:
            if node.left:
                self.add(node.left, start, end)
            else:
                node.left = TreeNode(start, end, (start + end) // 2)
        
        elif start > node.middle:
            if node.right:
                self.add(node.right, start, end)
            else:
                node.right = TreeNode(start, end, (start + end) // 2)
        
        else:
            node.start = min(node.start, start)
            node.end = max(node.end, end)
    
    def query(self, node):
        if not node:
            return []
        
        left_intervals = self.query(node.left)
        right_intervals = self.query(node.right)
        res = []
        
        inserted = False
        
        for lres in left_intervals:
            if lres[1] < node.start:
                res.append(lres)
            else:
                res.append([min(lres[0], node.start), node.end])
                inserted = True
                break
        
        if not inserted:
            res.append([node.start, node.end])
        
        for rres in right_intervals:
            if rres[0] <= node.end:
                res[-1][1] = max(node.end, rres[1])
            else:
                res.append(rres)
        
        return res
```

### Complexity
- Time: The time complexity of this solution is O(n log n) due to the recursive nature of the `add` and `query` methods. The `add` method has a time complexity of O(log n) because in the worst case, it needs to traverse the height of the tree. The `query` method has a time complexity of O(n) because it needs to traverse all nodes in the tree. Since the `merge` method calls `add` and `query` for each interval, the overall time complexity is O(n log n).
- Space: The space complexity of this solution is O(n) because in the worst case, the tree can have n nodes.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions for this solution include:
1. How would you optimize the solution to handle large input sizes?
Answer: One way to optimize the solution is to use a more efficient data structure, such as a balanced binary search tree, to reduce the time complexity of the `add` and `query` methods.
2. How would you modify the solution to handle intervals with different types of overlap (e.g., partially overlapping, fully overlapping, etc.)?
Answer: One way to modify the solution is to add additional logic to the `add` and `query` methods to handle different types of overlap. For example, you could add a `type` attribute to the `TreeNode` class to indicate the type of overlap.