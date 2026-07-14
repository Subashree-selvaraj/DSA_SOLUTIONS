<h2><a href="https://leetcode.com/problems/count-the-number-of-complete-components">2685. Count the Number of Complete Components</a></h2>

<p>You are given an integer <code>n</code>. There is an <strong>undirected</strong> graph with <code>n</code> vertices, numbered from <code>0</code> to <code>n - 1</code>. You are given a 2D integer array <code>edges</code> where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> denotes that there exists an <strong>undirected</strong> edge connecting vertices <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code>.</p>

<p>Return <em>the number of <strong>complete connected components</strong> of the graph</em>.</p>

<p>A <strong>connected component</strong> is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.</p>

<p>A connected component is said to be <b>complete</b> if there exists an edge between every pair of its vertices.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><strong class="example"><img alt="" src="https://assets.leetcode.com/uploads/2023/04/11/screenshot-from-2023-04-11-23-31-23.png" style="width: 671px; height: 270px;"></strong></p>

<pre><strong>Input:</strong> n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> From the picture above, one can see that all of the components of this graph are complete.
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong class="example"><img alt="" src="https://assets.leetcode.com/uploads/2023/04/11/screenshot-from-2023-04-11-23-32-00.png" style="width: 671px; height: 270px;"></strong></p>

<pre><strong>Input:</strong> n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 50</code></li>
	<li><code>0 &lt;= edges.length &lt;= n * (n - 1) / 2</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n - 1</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li>There are no repeated edges.</li>
</ul>


---

# 🛍️ Count-the-Number-of-Complete-Components | Explained

## Approach 1 (DFS-based Solution)
### Intuition
The given problem requires counting the number of complete components in a graph. A complete component is one in which every node is connected to every other node, i.e., it forms a complete subgraph. This approach uses a Depth-First Search (DFS) traversal to identify these complete components. The core idea is to visit each unvisited node in the graph, perform a DFS traversal from that node, and keep track of the number of vertices (`V`) and edges (`D`) visited. If the number of edges `D` is equal to the number of vertices `V` times `V-1` (the formula for the number of edges in a complete graph), then we have found a complete component.

### Approach
1. Initialize an adjacency list representation of the graph using an array of lists (`A`).
2. Populate the adjacency list by iterating through the given edges and adding each edge to the corresponding nodes' lists.
3. Initialize a boolean array (`vis`) to keep track of visited nodes and a variable (`res`) to count the number of complete components.
4. Iterate through each node in the graph. If a node has not been visited, perform a DFS traversal from that node.
5. During the DFS traversal, increment the `V` (vertex count) and `D` (edge count) variables. Mark each visited node as true in the `vis` array.
6. After the DFS traversal, check if the number of edges (`D`) is equal to `V * (V - 1)`, which indicates a complete component. If so, increment the `res` variable.
7. Finally, return the count of complete components (`res`).

### Detailed Code Analysis
The provided code implements this approach as follows:
- Lines 5-7: An array of lists (`A`) is created to represent the adjacency list of the graph. The `Arrays.setAll` method is used to initialize each list in the array.
- Lines 8-11: The adjacency list is populated by iterating through the given edges and adding each edge to the corresponding nodes' lists. This is done using a nested loop structure.
- Lines 13-14: A boolean array (`vis`) is created to keep track of visited nodes, and a variable (`res`) is initialized to count the number of complete components.
- Lines 16-26: The code iterates through each node in the graph. If a node has not been visited (i.e., `state` is false), a DFS traversal is performed from that node using the `dfs` method.
- Lines 20-21: The `V` and `D` variables are reset to 0 before each DFS traversal to keep track of the vertex and edge counts for the current component.
- Lines 32-39: The `dfs` method performs the actual DFS traversal. It increments the `V` variable, adds the number of edges of the current node to `D`, marks the node as visited, and recursively calls itself for each unvisited neighbor of the current node.
- Line 24: After the DFS traversal, the code checks if the number of edges (`D`) is equal to `V * (V - 1)`, which indicates a complete component. If so, the `res` variable is incremented.

### Code
```java
class Solution {
    static int V, D;

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] A = new ArrayList[n];
        Arrays.setAll(A, _ -> new ArrayList<>());

        for (int[] e : edges) {
            A[e[0]].add(e[1]);
            A[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            boolean state = vis[i];

            if (!state) {
                V = 0; D = 0;

                dfs(i, A, vis);

                if (D == V * (V - 1)) res++;
            }
        }

        return res;
    }

    private void dfs(int x, List<Integer>[] A, boolean[] vis) {
        V++;
        D += A[x].size();
        vis[x] = true;

        for (int state : A[x])
            if (!vis[state])
                dfs(state, A, vis);
    }
}
```

### Complexity
- Time: O(N + M), where N is the number of nodes and M is the number of edges. The reason is that we visit each node and edge once during the DFS traversal.
- Space: O(N + M), as we need to store the adjacency list representation of the graph, which requires O(N + M) space in the worst case.

## 🕵️‍♂️ Follow-up Questions (Optional)
- Q: What would be the time complexity if the graph is represented as an adjacency matrix instead of an adjacency list?
A: The time complexity would be O(N^2) because we would need to iterate through the entire matrix to find all the edges connected to a node.
- Q: How would you optimize the solution if the graph is very large and doesn't fit into memory?
A: To optimize the solution for a very large graph that doesn't fit into memory, you could consider using a distributed computing approach where the graph is divided into smaller subgraphs and processed in parallel across multiple machines. Alternatively, you could use a disk-based storage solution and process the graph in chunks, using a technique like external memory algorithms.