1class Solution {
2    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
3        List<List<Integer>> resV = new ArrayList<>(); // Result list to store the pairs
4        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
5        // Priority queue to store pairs with smallest sums, sorted by the sum
6
7        // Push the initial pairs into the priority queue
8        for (int x : nums1) {
9            pq.offer(new int[]{x + nums2[0], 0}); // The sum and the index of the second element in nums2
10        }
11
12        // Pop the k smallest pairs from the priority queue
13        while (k > 0 && !pq.isEmpty()) {
14            int[] pair = pq.poll();
15            int sum = pair[0]; // Get the smallest sum
16            int pos = pair[1]; // Get the index of the second element in nums2
17
18            List<Integer> currentPair = new ArrayList<>();
19            currentPair.add(sum - nums2[pos]);
20            currentPair.add(nums2[pos]);
21            resV.add(currentPair); // Add the pair to the result list
22
23            // If there are more elements in nums2, push the next pair into the priority queue
24            if (pos + 1 < nums2.length) {
25                pq.offer(new int[]{sum - nums2[pos] + nums2[pos + 1], pos + 1});
26            }
27
28            k--; // Decrement k
29        }
30
31        return resV; // Return the k smallest pairs
32    }
33}