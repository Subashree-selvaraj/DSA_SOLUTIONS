<h2><a href="https://leetcode.com/problems/boats-to-save-people">881. Boats to Save People</a></h2>

<p>You are given an array <code>people</code> where <code>people[i]</code> is the weight of the <code>i<sup>th</sup></code> person, and an <strong>infinite number of boats</strong> where each boat can carry a maximum weight of <code>limit</code>. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most <code>limit</code>.</p>

<p>Return <em>the minimum number of boats to carry every given person</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> people = [1,2], limit = 3
<strong>Output:</strong> 1
<strong>Explanation:</strong> 1 boat (1, 2)
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> people = [3,2,2,1], limit = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> 3 boats (1, 2), (2) and (3)
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> people = [3,5,3,4], limit = 5
<strong>Output:</strong> 4
<strong>Explanation:</strong> 4 boats (3), (3), (4), (5)
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= people.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= people[i] &lt;= limit &lt;= 3 * 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Boats-to-Save-People | Explained

## Approach 1: Two Pointer Technique
### Intuition
Imagine you are the rescue team leader, and you have a list of people with their weights. You want to assign them to boats with a limited capacity. The goal is to minimize the number of boats needed. A good strategy is to pair the heaviest person with the lightest person, as long as their combined weight does not exceed the boat's capacity. This way, you can reduce the number of boats required. This approach is similar to a real-world scenario where you would try to balance the weight in each boat to maximize the number of people rescued.

### Approach
The algorithm starts by sorting the list of people in ascending order of their weights. Then, it initializes two pointers, one at the beginning (left) and one at the end (right) of the sorted list. The algorithm then enters a loop that continues until all people have been assigned to a boat. Inside the loop, it checks if the combined weight of the people at the left and right pointers does not exceed the boat's capacity. If it does not exceed, it means they can be assigned to the same boat, so it increments the left pointer and decrements the right pointer. If the combined weight exceeds the capacity, it means they cannot be assigned to the same boat, so it only decrements the right pointer. In both cases, it increments the boat counter.

### Code
```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        int boats = 0;

        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            }
            else{
                right--;
            }
            boats++;
        }
        return boats;
    }
}
```

### Complexity
- Time: O(n log n) due to the sorting operation, where n is the number of people.
- Space: O(1) if the sorting is done in-place, or O(n) if a new sorted array is created.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions for this problem could be:
- What if the input list is already sorted? How would you modify the algorithm to take advantage of this?
  - Answer: If the list is already sorted, you can skip the sorting step and directly start the two-pointer technique. This would reduce the time complexity to O(n).
- What if there are multiple boats with different capacities? How would you assign people to these boats?
  - Answer: This would require a more complex algorithm, possibly involving dynamic programming or a greedy approach with a priority queue to manage the boats and their capacities.