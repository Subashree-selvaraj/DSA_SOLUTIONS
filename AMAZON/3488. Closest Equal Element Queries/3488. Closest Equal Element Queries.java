1class Solution {
2    public List<Integer> solveQueries(int[] nums, int[] queries) {
3        int n = nums.length;
4        Map<Integer, List<Integer>> map = new HashMap<>();
5
6        // store indices
7        for (int i = 0; i < n; i++) {
8            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
9        }
10
11        List<Integer> ans = new ArrayList<>();
12
13        for (int q : queries) {
14            List<Integer> v = map.get(nums[q]);
15
16            // only one time present
17            if (v.size() == 1) {
18                ans.add(-1);
19                continue;
20            }
21
22            int pos = Collections.binarySearch(v, q);
23            int res = Integer.MAX_VALUE;
24
25            // left neighbor
26            int left = v.get((pos - 1 + v.size()) % v.size());
27            int d1 = Math.abs(q - left);
28            res = Math.min(res, Math.min(d1, n - d1));
29
30            // right neighbor
31            int right = v.get((pos + 1) % v.size());
32            int d2 = Math.abs(q - right);
33            res = Math.min(res, Math.min(d2, n - d2));
34
35            ans.add(res);
36        }
37
38        return ans;
39    }
40}